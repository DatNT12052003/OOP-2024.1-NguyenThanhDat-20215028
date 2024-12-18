package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int storeQuantity=0;
    
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
        storeQuantity = storeQuantity + 1;
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            storeQuantity = storeQuantity - 1;
        } else {
            System.out.println("Not found: " + media.getTitle());
        }
    }
    
	public Media searchStoreByTitle(String title) {
		for(Media media : itemsInStore) {
			if(media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}

    public void display() {
		System.out.println("      ********************************STORE****************************");
		System.out.format("%10s%30s%20s%10s","ID","TITLE","CATEGORY", "COST");
		System.out.println();
		for (Media media : itemsInStore) {
        	if (media != null) {
        		System.out.format("%10s%30s%20s%10s",media.getId(),media.getTitle(),media.getCategory(), media.getCost());
        		System.out.println();
        	}
    	}
		return;
    }

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public int getStoreQuantity() {
		return storeQuantity;
	}

	public void setStoreQuantity(int storeQuantity) {
		this.storeQuantity = storeQuantity;
	}
	
	
}

//package hust.soict.dsai.aims.store;
//
//import java.util.ArrayList;
//
//
//import hust.soict.dsai.aims.media.Disc;
//import hust.soict.dsai.aims.media.Media;
//
//public class Store {
//	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
//	private int storeQuantity=0;
//	
//	public int getStoreQuantity() {
//		return storeQuantity;
//	}
//
//	public void setStoreQuantity(int storeQuantity) {
//		this.storeQuantity = storeQuantity;
//	}
//
//	public Store() {
//		super();
//	}
//
//	public void addMedia(Media med) {
//		itemsInStore.add(med);
//		storeQuantity++;
//		return;
//	}
//	
//	public void addMedia(Media med[]) {
//		for( int i = 0 ; i < med.length ; i++) {
//			itemsInStore.add(med[i]);
//			storeQuantity++;
//		}
//	}
//	
//	public void removeMedia(Media med) {
//		itemsInStore.remove(med);
//		storeQuantity--;
//		return;
//	}
//	
//	public void display() {
//		System.out.println("      ********************************CART****************************");
//		System.out.format("%10s%30s%20s%10s","ID","TITLE","CATEGORY", "COST");
//		System.out.println();
//		for (Media med : itemsInStore) {
//        	if (med != null) {
//        		System.out.format("%10s%30s%20s%10s",med.getId(),med.getTitle(),med.getCategory(), med.getCost());
//        		System.out.println();
//        	}
//    	}
//		return;
//	}
//	
//	public static void showMenu() {
//		System.out.println("AIMS: ");
//		System.out.println("--------------------------------");
//		System.out.println("1. View store");
//		System.out.println("2. Update store");
//		System.out.println("3. See current cart");
//		System.out.println("0. Exit");
//		System.out.println("--------------------------------");
//		System.out.println("Please choose a number: 0-1-2-3");
//		}
//
//	public static void storeMenu() {
//		System.out.println("Options: ");
//		System.out.println("--------------------------------");
//		System.out.println("1. See a media’s details");
//		System.out.println("2. Add a media to cart");
//		System.out.println("3. Play a media");
//		System.out.println("4. See current cart");
//		System.out.println("0. Back");
//		System.out.println("--------------------------------");
//		System.out.println("Please choose a number: 0-1-2-3-4");
//		}
//	
//
//	public static void mediaDetailsMenu() {
//		System.out.println("Options: ");
//		System.out.println("--------------------------------");
//		System.out.println("1. Add to cart");
//		System.out.println("2. Play");
//		System.out.println("0. Back");
//		System.out.println("--------------------------------");
//		System.out.println("Please choose a number: 0-1-2");
//		}
//
//	public static void cartMenu() {
//		System.out.println("Options: ");
//		System.out.println("--------------------------------");
//		System.out.println("1. Filter media in cart");
//		System.out.println("2. Sort media in cart");
//		System.out.println("3. Remove media from cart");
//		System.out.println("4. Play a media");
//		System.out.println("5. Place order");
//		System.out.println("0. Back");
//		System.out.println("--------------------------------");
//		System.out.println("Please choose a number: 0-1-2-3-4-5");
//		}
//	
//	public Media searchForItemInStore(String mediaNameToSearch) {
//		boolean founded = false;
//		for(Media med : itemsInStore) {
//			if(med.getTitle().equals(mediaNameToSearch)) {
//					System.out.format("%10s%30s%20s%10s",med.getId(),med.getTitle(),med.getCategory(), med.getCost());
//					System.out.println(med.toString());
//					System.out.println();
//					founded = true;
//					return med;	
//			} 
//		}
//		if(founded == false) System.out.println("No media named " + mediaNameToSearch + " founded!");
//		return null;
//	}
//
//	public ArrayList<Media> getItemsInStore() {
//		return itemsInStore;
//	}
//
//	public void setItemsInStore(ArrayList<Media> itemsInStore) {
//		this.itemsInStore = itemsInStore;
//	}
//
//}

