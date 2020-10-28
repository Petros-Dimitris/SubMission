package examples.simple;

public class UserSubmissionData extends AbstractSubmissionData {
	private UserSubmissionPhase submissionPhase;

	public UserSubmissionPhase getSubmissionPhase() {
		return submissionPhase;
	}

	public void setSubmissionPhase(UserSubmissionPhase submissionPhase) {
		this.submissionPhase = submissionPhase;
	}

}
