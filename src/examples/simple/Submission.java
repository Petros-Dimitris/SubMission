package examples.simple;

import examples.Base;
import interfaces.ISubmission;
import statuses.SubmissionStatus;

public class Submission extends Base implements ISubmission {
	private SubmissionCycle submissionCycle;
	private Long submitterId;
	private SubmissionStatus status;
	private SubmissionAcceptanceStatus acceptanceStatus;

	public SubmissionCycle getSubmissionCycle() {
		return submissionCycle;
	}

	public void setSubmissionCycle(SubmissionCycle submissionCycle) {
		this.submissionCycle = submissionCycle;
	}

	public Long getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(Long submitterId) {
		this.submitterId = submitterId;
	}

	public SubmissionStatus getStatus() {
		return status;
	}

	public void setStatus(SubmissionStatus status) {
		this.status = status;
	}

	public SubmissionAcceptanceStatus getAcceptanceStatus() {
		return acceptanceStatus;
	}

	public void setAcceptanceStatus(SubmissionAcceptanceStatus acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

}
