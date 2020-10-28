package examples.simple;

import java.util.HashSet;
import java.util.Set;

import interfaces.ISubmissionPhase;

public class AdministrativeVerificationPhase extends AbstractSubmissionPhase {
	public AdministrativeVerificationPhase() {
		super(SubmissionPhaseType.ADMINISTRATIVE_VERIFICATION);
		setTitle("Διοικητική Επαλήθευση");
		setPhaseNo(2);
	}

	@Override
	public Set<Class<? extends ISubmissionPhase>> getRequiresSubmissionOfPreviousPhases() {
		Set<Class<? extends ISubmissionPhase>> set = new HashSet<>();
		set.add(AdministrativeVerificationPhase.class);
		return set;
	}

}
