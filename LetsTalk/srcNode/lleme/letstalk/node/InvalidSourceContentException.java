package lleme.letstalk.node;

import org.omg.CORBA.UserException;

public class InvalidSourceContentException extends UserException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6555872692606361478L;

	public InvalidSourceContentException(String reason) {
		super(reason);
	}
}
