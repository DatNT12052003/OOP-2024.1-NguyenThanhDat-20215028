/**
 * 
 */
/**
 * 
 */
module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.graphics;
	requires javafx.media;
    exports hust.soict.dsai.aims;
    exports hust.soict.dsai.test.cart;
    exports hust.soict.dsai.test.disc;
    exports hust.soict.dsai.test.store;
    exports hust.soict.dsai.aims.controller; 

    // Xuất package để JavaFX có thể truy cập
    opens hust.soict.dsai.aims.screen to javafx.fxml;

    // Nếu cần sử dụng lớp controller từ các module khác
    exports hust.soict.dsai.aims.screen;
    
    // Cho phép JavaFX truy cập package hust.soict.dsai.aims.media
    opens hust.soict.dsai.aims.media to javafx.base;
    
    opens hust.soict.dsai.aims.controller to javafx.fxml; 
    
   
}
