package examples;

import interfaces.IBase;

public class Base implements IBase<Long> {
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
