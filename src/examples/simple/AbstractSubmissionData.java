package examples.simple;

import java.time.LocalDateTime;

import examples.Base;
import interfaces.ISubmissionData;
import statuses.SubmissionDataStatus;

public abstract class AbstractSubmissionData extends Base implements ISubmissionData {
	protected Submission submission;
	protected Long submitterId;
	protected SubmissionDataStatus submissionStatus;
	protected LocalDateTime submissionDate;

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	public Long getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(Long submitterId) {
		this.submitterId = submitterId;
	}

	public SubmissionDataStatus getSubmissionStatus() {
		return submissionStatus;
	}

	public void setSubmissionStatus(SubmissionDataStatus submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}

}
