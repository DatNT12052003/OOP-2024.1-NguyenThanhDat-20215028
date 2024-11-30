package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		itemsOrdered.add(dvd);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		itemsOrdered.add(dvd1);
		itemsOrdered.add(dvd2);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (int i = 0; i < dvdList.length; i++) {
	    	itemsOrdered.add(dvdList[i]);
	    }
	}
	
	public void addBook(Book book) {
		itemsOrdered.add(book);
	}
	
	public void addMedia(Media media) {
		itemsOrdered.add(media);
	}
	
	public void removeMedia(Media media) {
		itemsOrdered.remove(media);
	}
	
	public float totalCost() {
		float total = 0;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
		itemsOrdered.remove(dvd);
	}
	
	public void showCart() {
		for(Media media : itemsOrdered) {
			media.toString();
		}
	}
	
	public Media searchCartById(int id) {
		for(Media media : itemsOrdered) {
			if(media.getId()==id) {
				return media;
			}
		}
		return null;
	}
	
	public Media searchCartByTitle(String title) {
		for(Media media : itemsOrdered) {
			if(media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
	
    // Sắp xếp theo tiêu đề và giá
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARATOR_BY_TITLE_COST);
    }

    // Sắp xếp theo giá và tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARATOR_BY_COST_TITLE);
    }
	
	public void display() {
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		for(Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
		System.out.println("********************************************");
		
	}

	public void emptyCart() {
		itemsOrdered.clear();
	}

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
