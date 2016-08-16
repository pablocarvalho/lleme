package lleme.corba.testes.javaORB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import lleme.corba.testes.javaORB.StockObjects.Quote;

// This is a main function for a server.

public class StockServer {
	public static void main(String[] args) {
		args = new String[1];
		args[0] = "gii.ior";
		if (args.length != 1) {
			System.err.println("Required argument: stock ior file");
			return;
		}
		try {
			// Initialize the ORB.
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

			// Create a stock object.
			StockImpl theStock = new StockImpl("GII",
					"Global Industries Incorporated");
			orb.connect(theStock);

			// Give it a price.
			Quote quote = new Quote();
			quote.price = 28.0;
			quote.symbol = "GII";
			quote.volume = 0;
			quote.at_time = System.currentTimeMillis();
			theStock.set_quote(quote);

			// print stringified object reference
			System.out.println("Created GII:\n"
					+ orb.object_to_string(theStock));

			// write stringified object reference to disk
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(args[0])));
			out.println(orb.object_to_string(theStock));
			out.close();

			// wait for invocations from clients
			java.lang.Object sync = new java.lang.Object();
			synchronized (sync) {
				sync.wait();
			}

		} catch (Exception e) {
			System.err.println("Stock server error: " + e);
			e.printStackTrace(System.out);
		}
	}
}
