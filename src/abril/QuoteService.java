package abril;

import java.util.ArrayList;
import java.util.List;
import abril.Quote;

public class QuoteService {
 
	public static List<Quote> quotes = new ArrayList<Quote>();
	public static List<Quote> usuarios = new ArrayList<Quote>();
 
	public Quote addQuote(Integer id, String author, String message) throws Exception {
		//Check for already exists
		int index = quotes.indexOf(new Quote(id));
		if (index != -1) throw new Exception("Quote Record already exists");
		Quote q = new Quote(id, author, message);
		quotes.add(q);
		return q;
	}
	
	public Quote addUsuario(Integer id, String clave, String nombre) throws Exception {
		//Check for already exists
		int index = quotes.indexOf(new Quote(id));
		if (index != -1) throw new Exception("Quote Record already exists");
		Quote q = new Quote(id, clave, nombre);
		usuarios.add(q);
		return q;
	} 
 
	public Quote updateQuote(Quote q) throws Exception {
		int index = quotes.indexOf(q);
		if (index == -1) throw new Exception("Quote Record does not exist");
		Quote currentQuote = quotes.get(index);
		currentQuote.setAuthor(q.getAuthor());
		currentQuote.setMessage(q.getMessage());
		return q;
	}
	
	public Quote updateClave(Quote q) throws Exception {
		int index = usuarios.indexOf(q);
		if (index == -1) throw new Exception("Quote Record does not exist");
		Quote currentQuote = usuarios.get(index);
		currentQuote.setClave(q.getClave());
		return q;
	}
 
	public void removeQuote(Integer id) throws Exception {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new Exception("Quote Record does not exist");
		quotes.remove(index);
	}
 
	public List<Quote> getQuotes() {
		return quotes;
	}
 
	public List<Quote> getQuotesByAuthor(String author) {
		List<Quote> results = new ArrayList<Quote>();
		for (Quote quote : quotes) {
			if (quote.getAuthor().indexOf(author) != -1) {
				results.add(quote);
			}
		}
		return results;
	}
 
	public Quote getQuote(Integer id) throws Exception {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new Exception("Quote Record does not exist");
		return quotes.get(index);
	}
 
}