package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.showCart();
		System.out.println();
		
		System.out.println("Total Cost is: " + anOrder.totalCost());
		System.out.println();
		
		anOrder.removeDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc[] dvdList = {new DigitalVideoDisc("Naruto", "Manga", "Masashi Kishimoto", 25.95f),
				new DigitalVideoDisc("Onepice", "Manga", "Oda Eiichirō", 30.05f),
				new DigitalVideoDisc("Fairy Tail","Manga", "Mashima Hiro", 21.50f),
				};
		anOrder.addDigitalVideoDisc(dvdList);
		
		anOrder.showCart();
		System.out.println();
		
		anOrder.removeDigitalVideoDisc(dvdList[2]);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Conan", "Manga", "Masashi Kishimoto", 19.00f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Doraemon", "Manga", "Masashi Kishimoto", 23.05f);
		anOrder.addDigitalVideoDisc(dvd7, dvd8);
		
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd7);
		store.addMedia(dvd8);
		
		
		anOrder.showCart();
		System.out.println();
		
		System.out.println("Total Cost is: " + anOrder.totalCost());
		System.out.println();
		
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.showCart();
		
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
}
