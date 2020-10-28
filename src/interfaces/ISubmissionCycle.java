package interfaces;

import statuses.SubmissionCycleStatus;

public interface ISubmissionCycle extends IBase<Long> {

	Integer getMaximumSubmissionsPerSubmitter();

	@Deprecated
	Boolean getSupportsNewSubmissionAfterCancellation();

	SubmissionCycleStatus getStatus();

	void setStatus(SubmissionCycleStatus status);

	default boolean isActive() {
		return getStatus() == SubmissionCycleStatus.Active;
	}

}
