package br.pucrio.inf.catfwk.model;

import org.omg.CORBA.UserException;

public class InvalidDatasetDescException extends UserException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6555872692606361478L;

	public InvalidDatasetDescException(String reason) {
		super(reason);
	}
}
