package hust.soict.dsai.aims;

import hust.soict.dsai.aims.controller.StoreScreenController;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AimsJavaFX extends Application {
    private Store store = new Store();

    @Override
    public void start(Stage primaryStage) throws Exception {
        inputData(); 
        store.display();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/Store.fxml"));
        Parent root = loader.load();

        StoreScreenController controller = loader.getController();
        controller.setStore(store);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Cart Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void inputData() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
       
		Track track1 = new Track("Mot Con Vit", 3);
		Track track2 = new Track("Be Len Ba", 4);
		Track track3 = new Track("Mashup 2017", 7);
		Track track4 = new Track("Mashup 2024", 10);
		Track track5 = new Track("Em Cua Ngay Hom Qua", 4);
		Track track6 = new Track("Hay Trao Cho Anh", 5);

		CompactDisc cd1 = new CompactDisc("Nhac Hay 01", "Nhac Tre", "Son Tung MTP", 10.00f);
		cd1.addTrack(track5);
		cd1.addTrack(track6);
		store.addMedia(cd1);
		
		CompactDisc cd2 = new CompactDisc("Nhac Hay 02", "Nhac Thieu Nhi", "Linh tinh", 5.50f);
		cd2.addTrack(track1);
		cd2.addTrack(track2);
		store.addMedia(cd2);
		
		CompactDisc cd3 = new CompactDisc("Nhac Hay 03", "Mashup", "Linh tinh", 12.05f);
		cd3.addTrack(track3);
		cd3.addTrack(track4);
		store.addMedia(cd3);

		String author1 = new String("Nguyen Thanh Dat");
		String author2 = new String("Phan Trung Duc");
		String author3 = new String("Duong Van Gioi");
		
		Book book1 = new Book("Giang Dao 4.0", "Dao Ly", 99.00f);
		book1.addAuthor(author1);
		book1.addAuthor(author3);
		store.addMedia(book1);
		
		Book book2 = new Book("Lien Quan Mobile", "Ky Nang Game", 100.00f);
		book2.addAuthor(author1);
		book2.addAuthor(author2);
		store.addMedia(book2);
		
		Book book3 = new Book("An Lau De", "An Uong", 20.00f);
		book3.addAuthor(author1);
		book3.addAuthor(author2);
		book3.addAuthor(author3);
		store.addMedia(book3);
		
    }

    public static void main(String[] args) {
        launch(args);
    }
}
