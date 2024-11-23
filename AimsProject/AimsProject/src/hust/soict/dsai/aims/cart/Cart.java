package hust.soict.dsai.aims.cart;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemsOrdred[] = 
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		itemsOrdred[qtyOrdered] = dvd;
		qtyOrdered++;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		itemsOrdred[qtyOrdered] = dvd1;
		qtyOrdered++;
		itemsOrdred[qtyOrdered] = dvd2;
		qtyOrdered++;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (int i = 0; i < dvdList.length; i++) {
	        if (qtyOrdered + i < itemsOrdred.length) {
	            itemsOrdred[qtyOrdered + i] = dvdList[i];
	        }
	    }
	    qtyOrdered += dvdList.length;
	}

	
	public float totalCost() {
		float total = 0;
		for(int i=0; i<qtyOrdered; i++) {
			total += itemsOrdred[i].getCost();
		}
		return total;
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
	    for (int i = 0; i < qtyOrdered; i++) {
	        if (dvd.equals(itemsOrdred[i])) {
	            for (int j = i; j < qtyOrdered - 1; j++) {
	                itemsOrdred[j] = itemsOrdred[j + 1];
	            }
	            itemsOrdred[qtyOrdered - 1] = null;
	            qtyOrdered--;
	            break;
	        }
	    }
	}
	
	public void showCart() {
		for(int i=0; i<qtyOrdered; i++) {
			System.out.println("DVD có id là " + itemsOrdred[i].getId() +": " + itemsOrdred[i].getTitle() + ", " + itemsOrdred[i].getCategory() +", " 
					+ itemsOrdred[i].getDirector() + ", " + itemsOrdred[i].getLength() + ", " + itemsOrdred[i].getCost() + ".");
		}
	}
	
	public void searchCartById(int id) {
		System.out.println("********************SEACRCH CART BY ID********************");
		for(int i=0; i<qtyOrdered; i++) {
			if(itemsOrdred[i].getId()==id) {
				System.out.println(itemsOrdred[i].getId() +". DVD - " + itemsOrdred[i].getTitle() + " - " + itemsOrdred[i].getCategory() +" - " 
						+ itemsOrdred[i].getDirector() + " - " + itemsOrdred[i].getLength() + " : " + itemsOrdred[i].getCost() + "$.");
			}
		}
		System.out.println("*********************************************************");
	}
	
	public void searchCartByTitle(String title) {
		System.out.println("********************SEACRCH CART BY TITLE********************");
		for(int i=0; i<qtyOrdered; i++) {
			if(itemsOrdred[i].getTitle().equals(title)) {
				System.out.println(itemsOrdred[i].getId() +". DVD - " + itemsOrdred[i].getTitle() + " - " + itemsOrdred[i].getCategory() +" - " 
						+ itemsOrdred[i].getDirector() + " - " + itemsOrdred[i].getLength() + " : " + itemsOrdred[i].getCost() + "$.");
			}
		}
		System.out.println("*************************************************************");
	}
	
	public void print() {
		System.out.println("********************CART********************");
		System.out.println("Ordered Items:");
		for(int i=0; i<qtyOrdered; i++) {
			System.out.println(itemsOrdred[i].getId() +". DVD - " + itemsOrdred[i].getTitle() + " - " + itemsOrdred[i].getCategory() +" - " 
					+ itemsOrdred[i].getDirector() + " - " + itemsOrdred[i].getLength() + " : " + itemsOrdred[i].getCost() + "$.");
		}
		System.out.println("********************************************");
		
	}
}
