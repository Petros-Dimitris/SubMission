package interfaces;

import java.time.LocalDateTime;
import java.util.Set;

//index on (submissionCycleId, phaseNo) & (submissionCycleId, active=true)
public interface ISubmissionPhase {

	ISubmissionCycle getSubmissionCycle();

	Boolean getKeepsHistory();

	Boolean getSupportsTemporarySaving();

	Boolean getHasActivePeriod();

	Integer getPhaseNo();

	Set<Integer> getRequiresSubmissionOfPreviousPhases();

	LocalDateTime getActiveFrom();

	LocalDateTime getActiveUntil();

	Boolean getActive();

	void setActive(Boolean active);

	default boolean isPhaseActive() {
		if (!getSubmissionCycle().isActive()) {
			return false;
		}
		if (!Boolean.TRUE.equals(getActive())) {
			return false;
		}
		if (getHasActivePeriod()) {
			return !LocalDateTime.now().isBefore(getActiveFrom()) && !LocalDateTime.now().isAfter(getActiveUntil());
		} else {
			return true;
		}
	}

}
