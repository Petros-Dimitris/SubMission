package examples.simple;

import java.util.Collections;
import java.util.Set;

import interfaces.ISubmissionPhase;

public class UserSubmissionPhase extends AbstractSubmissionPhase {

	public UserSubmissionPhase() {
		super(SubmissionPhaseType.USER_SUBMISSION);
		setTitle("Υποβολή Αιτήσεων");
		setPhaseNo(1);
	}

	@Override
	public Set<Class<? extends ISubmissionPhase>> getRequiresSubmissionOfPreviousPhases() {
		return Collections.emptySet();
	}

}
