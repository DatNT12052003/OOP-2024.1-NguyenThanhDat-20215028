package aims_project;

import java.util.ArrayList;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
//		anOrder.showCart();
//		System.out.println();
//		
//		System.out.println("Total Cost is: " + anOrder.totalCost());
//		System.out.println();
//		
//		anOrder.removeDigitalVideoDisc(dvd1);
//		
//		DigitalVideoDisc[] dvdList = {new DigitalVideoDisc("Naruto", "Manga", "Masashi Kishimoto", 25.95f),
//				new DigitalVideoDisc("Onepice", "Manga", "Oda Eiichirō", 30.05f),
//				new DigitalVideoDisc("Fairy Tail","Manga", "Mashima Hiro", 21.50f),
//				};
//		anOrder.addDigitalVideoDisc(dvdList);
//		
//		anOrder.showCart();
//		System.out.println();
//		
//		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Conan", "Manga", "Masashi Kishimoto", 19.00f);
//		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Doraemon", "Manga", "Masashi Kishimoto", 23.05f);
//		anOrder.addDigitalVideoDisc(dvd7, dvd8);
//		
		anOrder.showCart();
		System.out.println();
		
		System.out.println("Total Cost is: " + anOrder.totalCost());
		System.out.println();
		
		anOrder.removeDigitalVideoDisc(dvd1);
		anOrder.showCart();
	}

}
