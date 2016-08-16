package lleme.letstalk.scs;

public class Semaphore {

	public synchronized void acquire() throws java.lang.InterruptedException {
		wait();
	}

	public synchronized void release() throws SecurityException {
		notify();
	}

	public synchronized void end() {
		notify();
	}
}
