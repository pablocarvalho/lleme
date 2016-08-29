package uff.ic.tcc00175.lib.factoryMethod;

public class ConcreteCreator extends Creator {
	public Product factoryMethod() {
		return new ConcreteProduct();
	}

	/** @link dependency */
	/* #ConcreteProduct lnkConcreteProduct; */
}
