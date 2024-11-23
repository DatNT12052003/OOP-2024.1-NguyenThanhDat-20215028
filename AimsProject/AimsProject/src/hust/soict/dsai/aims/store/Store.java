package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("Đã thêm DVD: " + dvd.getTitle());
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd)) {
            itemsInStore.remove(dvd);
            System.out.println("Đã xóa DVD: " + dvd.getTitle());
        } else {
            System.out.println("Không tồn tại: " + dvd.getTitle());
        }
    }

    public void displayStore() {
        System.out.println("****************************STORE**********************************");
        for (DigitalVideoDisc dvd : itemsInStore) {
            System.out.println("- " + dvd.getTitle());
        }
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng rỗng!");
        }
        System.out.println("******************************************************************");
    }
}
