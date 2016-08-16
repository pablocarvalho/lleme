package br.pucrio.inf.lib.observer;

/**
 * @alias Subject*/
public abstract interface Subject {
	public abstract void attach(Observer o);

	public abstract void deattach(Observer o);

	public abstract void notifyObservers();

	public abstract void finalize() throws Throwable;

}
