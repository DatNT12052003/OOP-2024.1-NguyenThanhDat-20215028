package hust.soict.dsai.aims.controller;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CartScreenController {
    private static Cart cart; 
    private static Store store;
    
    public void setStore(Store store) {
        this.store = store;
        loadCartItems();
    }
    
    private ObservableList<Media> allMediaItems; 

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costLabel;
    @FXML
    private Button btnViewStorePressed;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    public void order() {
        if (cart == null || cart.getItemsOrdered().isEmpty()) {
            Alert emptyCartAlert = new Alert(Alert.AlertType.WARNING);
            emptyCartAlert.setTitle("Empty Cart");
            emptyCartAlert.setHeaderText("Your cart is empty");
            emptyCartAlert.setContentText("Please add items to your cart before placing an order.");
            emptyCartAlert.showAndWait();
            return;
        }

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Order Confirmation");
        successAlert.setHeaderText("Order Placed Successfully!");
        successAlert.setContentText("Your order has been placed successfully. Thank you!");
        successAlert.showAndWait();

        cart.getItemsOrdered().clear();

        loadCartItems();
    }


    
    @FXML
    private void viewStore() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/Store.fxml"));
            Parent root = loader.load();

            Stage cartStage = new Stage();
            
            cartStage.setScene(new Scene(root));
            cartStage.setTitle("Store");
            
            StoreScreenController controller = loader.getController();
            controller.setCart(cart);
            controller.setStore(store);
            
            cartStage.show();
            
            Stage currentStage = (Stage) btnViewStorePressed.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void play() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null && selectedMedia instanceof Playable) {
            Playable playableMedia = (Playable) selectedMedia;

            Stage playStage = new Stage();
            playStage.setTitle("Now Playing: " + selectedMedia.getTitle());

            VBox playLayout = new VBox(10);
            playLayout.setStyle("-fx-padding: 20;");
            
            Label mediaTitleLabel = new Label("Now Playing: " + selectedMedia.getTitle());
            mediaTitleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            
            Label mediaInfoLabel = new Label("Category: " + selectedMedia.getCategory());
            Label mediaCostLabel = new Label("Cost: " + selectedMedia.getCost());

            HBox buttonLayout = new HBox(10);
            Button btnClose = new Button("Close");
            buttonLayout.getChildren().add(btnClose);
            HBox.setHgrow(btnClose, Priority.ALWAYS); 
            buttonLayout.setStyle("-fx-alignment: center-right;");

   
            playLayout.getChildren().addAll(mediaTitleLabel, mediaInfoLabel, mediaCostLabel, buttonLayout);

            btnClose.setOnAction(e -> playStage.close());

            Scene playScene = new Scene(playLayout, 400, 200);
            playStage.setScene(playScene);
            playStage.show();

         //   playableMedia.play();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Cannot play the selected media");
            alert.setContentText("This media is not playable.");
            alert.showAndWait();
        }
    }



    /**
     * Constructor không tham số
     */
    public CartScreenController() {
    }

    /**
     * Đặt giỏ hàng hiện tại
     */
    public void setCart(Cart cart) {
        this.cart = cart;
        loadCartItems();
    }


    /**
     * Khởi tạo các thành phần giao diện
     */
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                } else {
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                }
            }
        });

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> filterMediaItems(newValue));
    }

    /**
     * Cập nhật các nút hiển thị dựa trên mục đã chọn
     */
    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    /**
     * Xử lý khi nhấn nút Remove
     */
    @FXML
    private void btnRemovePressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            loadCartItems();
        }
    }

    /**
     * Tải danh sách các mặt hàng và cập nhật tổng tiền
     */
    private void loadCartItems() {
        if (cart != null) {
            allMediaItems = FXCollections.observableArrayList(cart.getItemsOrdered());
            tblMedia.setItems(allMediaItems);
            updateTotalCost();
        }
    }

    /**
     * Tính tổng tiền và cập nhật nhãn
     */
    private void updateTotalCost() {
        float totalCost = 0;
        for (Media media : cart.getItemsOrdered()) {
            totalCost += media.getCost();
        }
        costLabel.setText(String.format("Total Cost: $%.2f", totalCost));
    }

    /**
     * Lọc danh sách mặt hàng
     */
    private void filterMediaItems(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            tblMedia.setItems(allMediaItems);
            return;
        }

        ObservableList<Media> filteredList = FXCollections.observableArrayList();

        if (radioBtnFilterId.isSelected()) {
            for (Media media : allMediaItems) {
                if (String.valueOf(media.getId()).contains(filterText)) {
                    filteredList.add(media);
                }
            }
        } else if (radioBtnFilterTitle.isSelected()) {
            for (Media media : allMediaItems) {
                if (media.getTitle().toLowerCase().contains(filterText.toLowerCase())) {
                    filteredList.add(media);
                }
            }
        }

        tblMedia.setItems(filteredList);
    }
}
