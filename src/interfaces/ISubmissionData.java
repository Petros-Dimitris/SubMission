package interfaces;

import java.time.LocalDateTime;

import statuses.SubmissionDataStatus;

//index on (submissionId, submissionPhaseId, status=SUBMITTED)
public interface ISubmissionData extends IBase<Long> {

	ISubmission getSubmission();

	ISubmissionPhase getSubmissionPhase();

	Long getSubmitterId();

	SubmissionDataStatus getSubmissionStatus();

	void setSubmissionStatus(SubmissionDataStatus submissionStatus);

	LocalDateTime getSubmissionDate();

	void setSubmissionDate(LocalDateTime submissionDate);

	default boolean isTemporarySaved() {
		return getSubmissionStatus() == SubmissionDataStatus.TemporarySaved;
	}

	default boolean isSubmitted() {
		return getSubmissionStatus() == SubmissionDataStatus.Submitted;
	}

}
