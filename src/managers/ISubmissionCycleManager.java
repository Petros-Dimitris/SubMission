package managers;

import java.util.Set;

import interfaces.ISubmissionCycle;
import interfaces.ISubmissionExtension;
import interfaces.ISubmissionPhase;

public interface ISubmissionCycleManager {

	ISubmissionCycle save(ISubmissionCycle submissionCycle);

	ISubmissionPhase save(ISubmissionPhase submissionPhase);

	Set<ISubmissionPhase> getSubmissionPhases(ISubmissionCycle submissionCycle);

	default ISubmissionCycle advanceToNextPhase(ISubmissionCycle submissionCycle) {
		Set<ISubmissionPhase> submissionPhases = getSubmissionPhases(submissionCycle);
		ISubmissionPhase activePhase = submissionPhases.stream().filter(sp -> Boolean.TRUE.equals(sp.getActive()))
				.findFirst().orElse(null);
		Integer nextPhaseNo;
		if (activePhase == null) {
			nextPhaseNo = 1; // activate first phase
		} else {
			nextPhaseNo = activePhase.getPhaseNo() + 1;
		}

		ISubmissionPhase nextPhase = submissionPhases.stream().filter(sp -> nextPhaseNo.equals(sp.getPhaseNo()))
				.findFirst().orElse(null);
		if (nextPhase == null) {
			// last phase is active
		} else {
			nextPhase.setActive(true);
			save(activePhase);
			activePhase.setActive(false);
			save(nextPhase);
		}

		return save(submissionCycle);
	}

	ISubmissionExtension getSubmissionExtension(Long submissionPhaseId, Long submitterId);

}
