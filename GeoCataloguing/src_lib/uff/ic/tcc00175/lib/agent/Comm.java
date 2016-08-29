package uff.ic.tcc00175.lib.agent;

/**
 * @alias Comm
 * @stereotype abstract*/
public abstract interface Comm {

	public abstract Message readMessage(Message type)
			throws InterruptedException;

	public abstract void sendMessage(Message msg);

}