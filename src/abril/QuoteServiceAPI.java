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
	public static List<Quote> Usuarios = new ArrayList<Quote>();
 
	@ApiMethod(name="addUsuarios")
	public Quote addUsuarios(@Named("ID") Integer ID, @Named("clave") String clave, @Named("nombre") String nombre) throws NotFoundException {
		//Check for already exists
		int index = Usuarios.indexOf(new Quote(ID));
		if (index != -1) throw new NotFoundException("Quote Record already exists");
 
		Quote q = new Quote(ID, clave, nombre);
		Usuarios.add(q);
		return q;
	}
 
	@ApiMethod(name="cambiar_clave")
	public Quote updateQuote(Quote q) throws NotFoundException {
		int index = Usuarios.indexOf(q);
		if (index == -1)
			throw new NotFoundException("Quote Record does not exist");
		  Quote currentQuote = Usuarios.get(index);
		  currentQuote.setClave(q.getClave());
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
		return Usuarios;
	}
 
	@ApiMethod(name="listByAuthor")
	public List<Quote> getQuotesByAuthor(@Named("author") String author) {
		List<Quote> results = new ArrayList<Quote>();
		for (Quote quote : quotes) {
			if (quote.getAuthor().indexOf(author) != -1) {
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