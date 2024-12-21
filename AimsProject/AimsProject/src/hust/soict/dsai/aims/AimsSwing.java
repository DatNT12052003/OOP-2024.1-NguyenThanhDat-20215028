package hust.soict.dsai.aims;

import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class AimsSwing {
    public static void main(String[] args) {
    	StoreScreen.databaseInput();
    	new StoreScreen(StoreScreen.store);
    }
}
