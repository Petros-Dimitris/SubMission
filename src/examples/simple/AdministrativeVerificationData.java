package examples.simple;

public class AdministrativeVerificationData extends AbstractSubmissionData {
	private AbstractSubmissionPhase submissionPhase;
	private SubmissionAcceptanceStatus acceptanceStatus;

	public AbstractSubmissionPhase getSubmissionPhase() {
		return submissionPhase;
	}

	public void setSubmissionPhase(AbstractSubmissionPhase submissionPhase) {
		this.submissionPhase = submissionPhase;
	}

	public SubmissionAcceptanceStatus getAcceptanceStatus() {
		return acceptanceStatus;
	}

	public void setAcceptanceStatus(SubmissionAcceptanceStatus acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}

}
