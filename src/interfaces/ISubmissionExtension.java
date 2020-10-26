package interfaces;

import java.time.LocalDateTime;

public interface ISubmissionExtension extends IBase<Long> {

	ISubmissionPhase getSubmissionPhase();

	ISubmission getSubmission();

	LocalDateTime getDateUntil();

}
