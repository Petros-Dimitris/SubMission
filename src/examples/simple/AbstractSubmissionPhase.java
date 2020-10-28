package examples.simple;

import java.time.LocalDateTime;

import examples.Base;
import interfaces.ISubmissionPhase;

public abstract class AbstractSubmissionPhase extends Base implements ISubmissionPhase {
	protected String title;
	protected SubmissionCycle submissionCycle;
	protected Boolean keepsHistory;
	protected Boolean supportsTemporarySaving;
	protected Integer phaseNo;
	protected Boolean hasActivePeriod;
	protected LocalDateTime activeFrom, activeUntil;
	protected Boolean active;
	private SubmissionPhaseType type;

	protected AbstractSubmissionPhase(SubmissionPhaseType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SubmissionCycle getSubmissionCycle() {
		return submissionCycle;
	}

	public void setSubmissionCycle(SubmissionCycle submissionCycle) {
		this.submissionCycle = submissionCycle;
	}

	public Boolean getKeepsHistory() {
		return keepsHistory;
	}

	public void setKeepsHistory(Boolean keepsHistory) {
		this.keepsHistory = keepsHistory;
	}

	public Boolean getSupportsTemporarySaving() {
		return supportsTemporarySaving;
	}

	public void setSupportsTemporarySaving(Boolean supportsTemporarySaving) {
		this.supportsTemporarySaving = supportsTemporarySaving;
	}

	public Integer getPhaseNo() {
		return phaseNo;
	}

	public void setPhaseNo(Integer phaseNo) {
		this.phaseNo = phaseNo;
	}

	public Boolean getHasActivePeriod() {
		return hasActivePeriod;
	}

	public void setHasActivePeriod(Boolean hasActivePeriod) {
		this.hasActivePeriod = hasActivePeriod;
	}

	public LocalDateTime getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(LocalDateTime activeFrom) {
		this.activeFrom = activeFrom;
	}

	public LocalDateTime getActiveUntil() {
		return activeUntil;
	}

	public void setActiveUntil(LocalDateTime activeUntil) {
		this.activeUntil = activeUntil;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public SubmissionPhaseType getType() {
		return type;
	}

	public void setType(SubmissionPhaseType type) {
		this.type = type;
	}
}
