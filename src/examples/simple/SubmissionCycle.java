package examples.simple;

import examples.Base;
import interfaces.ISubmissionCycle;
import statuses.SubmissionCycleStatus;

public class SubmissionCycle extends Base implements ISubmissionCycle {
	private String title;
	private Integer maximumSubmissionsPerSubmitter;
	private Boolean supportsNewSubmissionAfterCancellation;
	private SubmissionCycleStatus status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMaximumSubmissionsPerSubmitter() {
		return maximumSubmissionsPerSubmitter;
	}

	public void setMaximumSubmissionsPerSubmitter(Integer maximumSubmissionsPerSubmitter) {
		this.maximumSubmissionsPerSubmitter = maximumSubmissionsPerSubmitter;
	}

	public Boolean getSupportsNewSubmissionAfterCancellation() {
		return supportsNewSubmissionAfterCancellation;
	}

	public void setSupportsNewSubmissionAfterCancellation(Boolean supportsNewSubmissionAfterCancellation) {
		this.supportsNewSubmissionAfterCancellation = supportsNewSubmissionAfterCancellation;
	}

	public SubmissionCycleStatus getStatus() {
		return status;
	}

	public void setStatus(SubmissionCycleStatus status) {
		this.status = status;
	}

}
