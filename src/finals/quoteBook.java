package finals;

public class quoteBook {
	int count = 0;
	int id;
	String quote, author;

	public quoteBook(String quote, String author) {
		super();
		this.quote = quote;
		this.author = author;
		this.id = count++;
	}
	
	public quoteBook(int id, String quote, String author) {
		super();
		this.id = id;
		this.quote = quote;
		this.author = author;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

}
