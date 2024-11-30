package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Đã thêm: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa: " + media.getTitle());
        } else {
            System.out.println("Không tồn tại: " + media.getTitle());
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
        System.out.println("****************************STORE**********************************");
        for (Media media : itemsInStore) {
            System.out.println("- " + media.getTitle());
        }
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng rỗng!");
        }
        System.out.println("******************************************************************");
    }

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
