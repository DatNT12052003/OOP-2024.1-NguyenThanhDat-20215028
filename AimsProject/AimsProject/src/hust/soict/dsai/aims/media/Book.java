package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
		
	public Book() {
		super();
	}
	
	public Book(String title) {
		super(title);
	}
	
	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public void addAuthor(String author) {
	    if (!authors.contains(author)) {
	        authors.add(author);
	    }
	}
	
	public void removeAuthor(String author) {
		if (authors.contains(author)) {
			authors.remove(author);
		}else {
			System.out.println("Error: Not exist " + author + " in List Author of Book!");
		}
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	@Override
	public String toString() {
	    StringBuilder listAuthor = new StringBuilder();
	    for (String s : authors) {
	        listAuthor.append(s).append(", ");
	    }

	    if (listAuthor.length() >= 2) {
	        listAuthor.setLength(listAuthor.length() - 2);
	    }

	    return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() +
	           " - " + listAuthor + " : " + this.getCost() + "$.";
	}
}
