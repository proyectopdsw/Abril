package abril;

 
import java.util.ArrayList;
import java.util.List;
 
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import abril.Quote;
 
@Api(name="quoteapi",version="v1", description="An API to manage famous quotes")
public class QuoteServiceAPI {
 
	public static List<Quote> quotes = new ArrayList<Quote>();
 
	@ApiMethod(name="add")
	public Quote addQuote(@Named("id") Integer id, @Named("nombre") String nombre, @Named("message") String message) throws NotFoundException {
		//Check for already exists
		int index = quotes.indexOf(new Quote(id));
		if (index != -1) throw new NotFoundException("Quote Record already exists");
 
		Quote q = new Quote(id, nombre, message);
		quotes.add(q);
		return q;
	}
 
	@ApiMethod(name="update")
	public Quote updateQuote(Quote q) throws NotFoundException {
		int index = quotes.indexOf(q);
		if (index == -1)
			throw new NotFoundException("Quote Record does not exist");
		  Quote currentQuote = quotes.get(index);
		  currentQuote.setNombre(q.getNombre());
		  currentQuote.setMessage(q.getMessage());
		  return q;
	}
 
	@ApiMethod(name="remove")
	public void removeQuote(@Named("id") Integer id) throws NotFoundException {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new NotFoundException("Quote Record does not exist");
		quotes.remove(index);
	}
 
	@ApiMethod(name="list")
	public List<Quote> getQuotes() {
		return quotes;
	}
 
	@ApiMethod(name="listByNombre")
	public List<Quote> getQuotesByNombre(@Named("nombre") String nombre) {
		List<Quote> results = new ArrayList<Quote>();
		for (Quote quote : quotes) {
			if (quote.getNombre().indexOf(nombre) != -1) {
				results.add(quote);
			}
		}
		return results;
	}
 
	@ApiMethod(name="getQuote")
	public Quote getQuote(@Named("id") Integer id) throws NotFoundException {
		int index = quotes.indexOf(new Quote(id));
		if (index == -1)
			throw new NotFoundException("Quote Record does not exist");
		return quotes.get(index);
	}
 
}