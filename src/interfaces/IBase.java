package interfaces;

@FunctionalInterface
public interface IBase<I> {

	public I getId();

	default boolean isPersistent() {
		return getId() != null;
	}

}
