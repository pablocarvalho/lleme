package lleme.corba.testes.javaORB;

import lleme.corba.testes.javaORB.StockObjects.Quote;
import lleme.corba.testes.javaORB.StockObjects.Unknown;

public class StockImpl extends lleme.corba.testes.javaORB.StockObjects._StockImplBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6723413468828463591L;

	private Quote _quote = null;

	private String _description = null;

	public StockImpl(String name, String description) {
		super();
		_description = description;
	}

	public Quote get_quote() throws Unknown {
		if (_quote == null)
			throw new Unknown();
		return _quote;
	}

	// *** put your method implementing the IDL operation
	// for setting the quote here
	public void set_quote(Quote quote) {
		this._quote = quote;
	}

	public String description() {
		return _description;
	}

}
