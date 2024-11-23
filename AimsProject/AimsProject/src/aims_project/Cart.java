package aims_project;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemsOrdred[] = 
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		itemsOrdred[qtyOrdered] = dvd;
		qtyOrdered++;
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
//		itemsOrdred[qtyOrdered] = dvd1;
//		qtyOrdered++;
//		itemsOrdred[qtyOrdered] = dvd2;
//		qtyOrdered++;
//	}
//	
//	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//		for(int i=0; i<dvdList.length; i++) {
//			itemsOrdred[qtyOrdered+i+1] = dvdList[i];
//		}
//		qtyOrdered+=dvdList.length;
//	}
//	
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
			System.out.println("DVD thứ " + (i+1) +": " + itemsOrdred[i].getTitile() + ", " + itemsOrdred[i].getCategory() +", " 
					+ itemsOrdred[i].getDirector() + ", " + itemsOrdred[i].getLength() + ", " + itemsOrdred[i].getCost() + ".");
		}
	}
}
