package managers;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import interfaces.ISubmission;
import interfaces.ISubmissionCycle;
import interfaces.ISubmissionData;
import interfaces.ISubmissionPhase;
import managers.exceptions.FailedToSubmitPreviousDataException;
import managers.exceptions.InvalidStatusException;
import managers.exceptions.SubmissionLimitReachedException;
import managers.exceptions.SubmissionPhaseIsNotActiveException;
import managers.exceptions.TemporarySavedAlreadyExistsException;
import statuses.SubmissionDataStatus;

public interface ISubmissionManager {

	ISubmission getById(Long id);

	ISubmissionData getActiveSubmissionData(ISubmission submission, ISubmissionPhase submissionPhase);

	Long getActiveSubmissionCount(Long submitterId, Long submissionCycleId);

	Long getSubmittedSubmissionDataCount(Long submitteId, Collection<Integer> submissionPhaseNos);

//	ISubmissionExtension getSubmissionExtension(ISubmission submission, ISubmissionPhase submissionPhase);

	long getSubmissionExtensionCount(ISubmission submission, LocalDateTime dateUntil_From,
			ISubmissionPhase... submissionPhases);

	void save(ISubmission submission);

	void save(ISubmissionData submissionData);

	default boolean isSubmissionPhaseActive(ISubmissionData submissionData) {
		// maybe should check for submission extensions of other phases
		ISubmissionPhase submissionPhase = submissionData.getSubmissionPhase();
		if (!submissionPhase.isPhaseActive()) {
			if (getSubmissionExtensionCount(submissionData.getSubmission(), LocalDateTime.now(),
					submissionPhase) == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	default void validateTemporarySave(ISubmissionData submissionData) {
		// 1. check if temporary saving is supported
		ISubmissionPhase submissionPhase = submissionData.getSubmissionPhase();
		if (!submissionPhase.getSupportsTemporarySaving()) {
			throw new UnsupportedOperationException();
		}
		// 2. check status
		if (!submissionData.isTemporarySaved()) {
			throw new InvalidStatusException();
		}
		// 3. check if submission phase is active
		if (!isSubmissionPhaseActive(submissionData)) {
			throw new SubmissionPhaseIsNotActiveException();
		}
		// 4. check if previous data are submitted
		Set<Integer> requiredPreviousPhases = submissionPhase.getRequiresSubmissionOfPreviousPhases();
		if (requiredPreviousPhases != null && !requiredPreviousPhases.isEmpty()) {
			if (getSubmittedSubmissionDataCount(submissionData.getSubmission(),
					requiredPreviousPhases) != requiredPreviousPhases.size()) {
				throw new FailedToSubmitPreviousDataException();
			}
		}
		// 5. check if there is submitted / temporary saved data
		ISubmissionData activeData = getActiveSubmissionData(submissionData.getSubmission(), submissionPhase);
		if (activeData != null) {
			if (activeData.isSubmitted()) {
				throw new TemporarySavedAlreadyExistsException();
			} else if (activeData.isTemporarySaved()) {
				if (!activeData.equals(submissionData)) {
					throw new TemporarySavedAlreadyExistsException();
				}
			}
		}
	}

	int getSubmittedSubmissionDataCount(ISubmission submission, Set<Integer> requiredPreviousPhases);

	default void temporarySave(ISubmissionData submissionData) {
		validateTemporarySave(submissionData);
		save(submissionData);
	}

	default void validateSubmission(ISubmissionData submissionData) {
		// 1. check status
		if (!submissionData.isSubmitted()) {
			throw new InvalidStatusException();
		}
		// 2. check if submission phase is active
		ISubmission submission = submissionData.getSubmission();
		ISubmissionPhase submissionPhase = submissionData.getSubmissionPhase();
		if (!isSubmissionPhaseActive(submissionData)) {
			throw new SubmissionPhaseIsNotActiveException();
		}
		// 3. check if previous data are submitted
		Set<Integer> requiredPreviousPhases = submissionPhase.getRequiresSubmissionOfPreviousPhases();
		if (requiredPreviousPhases != null && !requiredPreviousPhases.isEmpty()) {
			if (getSubmittedSubmissionDataCount(submissionData.getSubmission(),
					requiredPreviousPhases) != requiredPreviousPhases.size()) {
				throw new FailedToSubmitPreviousDataException();
			}
		}
		// 4. check if submitter is about to exceed submission limit
		ISubmissionCycle submissionCycle = submission.getSubmissionCycle();
		if (submission.isNewSubmission() && submissionCycle.getMaximumSubmissionsPerSubmitter() != null) {
			if (getActiveSubmissionCount(submission.getSubmitterId(), submissionCycle.getId()) >= submissionCycle
					.getMaximumSubmissionsPerSubmitter()) {
				throw new SubmissionLimitReachedException();
			}
		}
	}

	default void submit(ISubmissionData submissionData) {
		validateSubmission(submissionData);
		boolean keepsHistory = submissionData.getSubmissionPhase().getKeepsHistory();

		ISubmissionData activeData = getActiveSubmissionData(submissionData.getSubmission(),
				submissionData.getSubmissionPhase());
		if (activeData != null) {
			if (activeData.isSubmitted()) {
				if (keepsHistory) {
					if (submissionData.isPersistent()) {
						throw new UnsupportedOperationException();
					}
					activeData.setSubmissionStatus(SubmissionDataStatus.Replaced);
					save(activeData);
				} else {
					if (!submissionData.equals(activeData)) {
						throw new UnsupportedOperationException();
					}
				}
			} else if (activeData.isTemporarySaved()) {
				if (!activeData.equals(submissionData)) {
					throw new TemporarySavedAlreadyExistsException();
				}
			}
		}
		submissionData.setSubmissionDate(LocalDateTime.now());
		save(submissionData);
	}

}
