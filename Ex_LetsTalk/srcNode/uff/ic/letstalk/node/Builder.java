package uff.ic.letstalk.node;

public abstract interface Builder {

	public abstract void build(MetadataElement[] elements)
			throws InvalidSourceContentException, NumberFormatException;

	public abstract Object getResult();
}
