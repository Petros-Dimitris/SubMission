package statuses;

public enum SubmissionDataStatus {

	TemporarySaved, // data are saved but NOT submitted
	Replaced, // data were submitted, new data were submitted afterwards
	Submitted;// data are submitted

}
