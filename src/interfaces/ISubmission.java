package interfaces;

import statuses.SubmissionStatus;

public interface ISubmission extends IBase<Long> {

	ISubmissionCycle getSubmissionCycle();

	Long getSubmitterId();

	SubmissionStatus getStatus();

	void setStatus(SubmissionStatus status);

	default boolean isActive() {
		return getStatus() == SubmissionStatus.Active;
	}

	default boolean isNewSubmission() {
		return !(isPersistent() && isActive());
	}

}
