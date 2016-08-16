package lleme.corba.testes.javaORB;

import java.io.BufferedReader;
import java.io.FileReader;

import org.omg.CORBA.ORB;

import lleme.corba.testes.javaORB.StockObjects.Quote;
import lleme.corba.testes.javaORB.StockObjects.Stock;
import lleme.corba.testes.javaORB.StockObjects.StockHelper;

public class StockClient {
	public static void main(String args[]) {
		args = new String[1];
		args[0] = "gii.ior";
		if (args.length != 1) {
			System.err.println("Required argument: stock ior file");
			return;
		}
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// Read in a stringified reference to a stock object
			// This assumes that the server created it
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			String ior = in.readLine();
			in.close();

			// "destringify" the object
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			// narrow it to a stock object
			Stock theStock = StockHelper.narrow(obj);

			// call the stock object for it's description and current price
			Quote currentQuote = theStock.get_quote();
			System.out.print(theStock.description());
			System.out
					.println(" is currently selling at " + currentQuote.price);
			System.out.println("Volume is " + currentQuote.volume);

			currentQuote.price = 88;
			theStock.set_quote(currentQuote);
			currentQuote = theStock.get_quote();
			System.out.print(theStock.description());
			System.out
					.println(" is currently selling at " + currentQuote.price);
			System.out.println("Volume is " + currentQuote.volume);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
