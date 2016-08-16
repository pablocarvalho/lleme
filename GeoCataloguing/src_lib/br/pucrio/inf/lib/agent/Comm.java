package br.pucrio.inf.lib.agent;

/**
 * @alias Comm
 * @stereotype abstract*/
public abstract interface Comm {

	public abstract Message readMessage(Message type)
			throws InterruptedException;

	public abstract void sendMessage(Message msg);

}