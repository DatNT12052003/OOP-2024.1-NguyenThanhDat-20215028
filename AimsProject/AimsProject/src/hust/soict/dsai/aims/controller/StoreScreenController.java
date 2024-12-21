package hust.soict.dsai.aims.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.cart.CartSingleton;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
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

public class StoreScreenController {
    private static Store store; 
    private static Cart cart;
    
    public void setCart(Cart cart) {
        this.cart = cart;
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
    private Button btnDetails;
    
    @FXML
    private void details() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Media Details");
            alert.setHeaderText("Details of " + selectedMedia.getTitle());
            
            StringBuilder details = new StringBuilder();
            details.append("Title: ").append(selectedMedia.getTitle()).append("\n");
            details.append("Category: ").append(selectedMedia.getCategory()).append("\n");
            details.append("Cost: $").append(String.format("%.2f", selectedMedia.getCost())).append("\n");

            if (selectedMedia instanceof Book) {
                Book book = (Book) selectedMedia;
                details.append("Authors: ").append(String.join(", ", book.getAuthors())).append("\n");
            } else if (selectedMedia instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) selectedMedia;
                details.append("Artist: ").append(cd.getArtist()).append("\n");
                details.append("Tracks:\n");
                for (Track track : cd.getTracks()) {
                    details.append("  - ").append(track.getTitle())
                           .append(" (").append(track.getLength()).append(")\n");
                }
            } else if (selectedMedia instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) selectedMedia;
                details.append("Director: ").append(dvd.getDirector()).append("\n");
                details.append("Length: ").append(dvd.getLength()).append(" minutes\n");
            }

            alert.setContentText(details.toString());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Media Selected");
            alert.setHeaderText("No Media Selected");
            alert.setContentText("Please select a media item to view its details.");
            alert.showAndWait();
        }
    }

    
    @FXML
    private Button btnAdds;
    
    @FXML
    private void addToStore() {
        Stage addStage = new Stage();
        addStage.setTitle("Add Media to Store");

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20;");

        Label selectLabel = new Label("Select Media Type:");
        ChoiceBox<String> mediaTypeChoice = new ChoiceBox<>();
        mediaTypeChoice.getItems().addAll("Book", "CD", "DVD");

        VBox inputFields = new VBox(10);

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();

        Label categoryLabel = new Label("Category:");
        TextField categoryField = new TextField();

        Label costLabel = new Label("Cost:");
        TextField costField = new TextField();

        VBox authorInputBox = new VBox(10);
        Label authorLabel = new Label("Authors (comma-separated):");
        TextField authorField = new TextField();
        authorInputBox.getChildren().addAll(authorLabel, authorField);

        VBox cdInputBox = new VBox(10);
        Label artistLabel = new Label("Artist:");
        TextField artistField = new TextField();

        VBox trackInputBox = new VBox(10);
        Label trackLabel = new Label("Tracks:");
        VBox trackList = new VBox(5);
        Button addTrackButton = new Button("Add Track");

        HBox trackDetailsBox = new HBox(10);
        TextField trackTitleField = new TextField();
        trackTitleField.setPromptText("Track Title");
        TextField trackLengthField = new TextField();
        trackLengthField.setPromptText("Track Length");
        Button saveTrackButton = new Button("Save Track");

        trackDetailsBox.getChildren().addAll(trackTitleField, trackLengthField, saveTrackButton);
        cdInputBox.getChildren().addAll(artistLabel, artistField, trackLabel, trackList, trackDetailsBox);

        Label directorLabel = new Label("Director:");
        TextField directorField = new TextField();

        Label dvdLengthLabel = new Label("Length:");
        TextField dvdLengthField = new TextField();

        authorInputBox.setVisible(false);
        cdInputBox.setVisible(false);
        directorLabel.setVisible(false);
        directorField.setVisible(false);
        dvdLengthLabel.setVisible(false);
        dvdLengthField.setVisible(false);

        mediaTypeChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            authorInputBox.setVisible(false);
            cdInputBox.setVisible(false);
            directorLabel.setVisible(false);
            directorField.setVisible(false);
            dvdLengthLabel.setVisible(false);
            dvdLengthField.setVisible(false);

            if ("Book".equals(newValue)) {
                authorInputBox.setVisible(true);
            } else if ("CD".equals(newValue)) {
                cdInputBox.setVisible(true);
            } else if ("DVD".equals(newValue)) {
                directorLabel.setVisible(true);
                directorField.setVisible(true);
                dvdLengthLabel.setVisible(true);
                dvdLengthField.setVisible(true);
            }
        });

        Button submitButton = new Button("Add to Store");
        submitButton.setOnAction(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost;
            try {
                cost = Float.parseFloat(costField.getText());
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Cost must be a valid number.", Alert.AlertType.ERROR);
                return;
            }

            Media newMedia = null;
            String selectedType = mediaTypeChoice.getValue();

            if ("Book".equals(selectedType)) {
                String[] authorsArray = authorField.getText().split(",");
                List<String> authors = new ArrayList<>();
                for (String author : authorsArray) {
                    String trimmedAuthor = author.trim();
                    if (!trimmedAuthor.isEmpty()) {
                        authors.add(trimmedAuthor);
                    }
                }

                if (authors.isEmpty()) {
                    showAlert("Invalid Input", "Please enter at least one author.", Alert.AlertType.ERROR);
                    return;
                }

                newMedia = new Book(title, category, cost, authors);
            } else if ("CD".equals(selectedType)) {
                String artist = artistField.getText();
                List<Track> tracks = new ArrayList<>();
                for (javafx.scene.Node node : trackList.getChildren()) {
                    if (node instanceof Label) {
                        String[] trackInfo = ((Label) node).getText().split(":");
                        tracks.add(new Track(trackInfo[0].trim(), Float.parseFloat(trackInfo[1].trim())));
                    }
                }
                newMedia = new CompactDisc(title, category, cost, artist, tracks);
            } else if ("DVD".equals(selectedType)) {
                String director = directorField.getText();
                float length;
                try {
                    length = Float.parseFloat(dvdLengthField.getText());
                } catch (NumberFormatException ex) {
                    showAlert("Invalid Input", "Length must be a valid number.", Alert.AlertType.ERROR);
                    return;
                }
                newMedia = new DigitalVideoDisc(title, category, director, length, cost);
            }

            if (newMedia != null) {
                store.addMedia(newMedia);
                loadCartItems();
                addStage.close();
            }
        });

        saveTrackButton.setOnAction(e -> {
            String trackTitle = trackTitleField.getText();
            float trackLength;
            try {
                trackLength = Float.parseFloat(trackLengthField.getText());
            } catch (NumberFormatException ex) {
                showAlert("Invalid Input", "Track length must be a valid number.", Alert.AlertType.ERROR);
                return;
            }
            Label trackLabelEntry = new Label(trackTitle + ": " + trackLength);
            trackList.getChildren().add(trackLabelEntry);
            trackTitleField.clear();
            trackLengthField.clear();
        });

        inputFields.getChildren().addAll(
            titleLabel, titleField, 
            categoryLabel, categoryField, 
            costLabel, costField, 
            authorInputBox, cdInputBox, 
            directorLabel, directorField, 
            dvdLengthLabel, dvdLengthField);

        layout.getChildren().addAll(selectLabel, mediaTypeChoice, inputFields, submitButton);

        Scene scene = new Scene(layout, 400, 750);
        addStage.setScene(scene);
        addStage.show();
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }



    
    @FXML
    private Button btnViewStorePressed;
    
    @FXML
    private void viewCart() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/Cart.fxml"));
            Parent root = loader.load();

            Stage cartStage = new Stage();
            
            cartStage.setScene(new Scene(root));
            cartStage.setTitle("Cart");
            
            CartScreenController controller = loader.getController();
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
    private void addToCart() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null) {
            if (cart.containsMedia(selectedMedia)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Media Already In Cart");
                alert.setHeaderText("This Media is Already in the Cart");
                alert.setContentText("The media '" + selectedMedia.getTitle() + "' is already in your cart.");
                alert.showAndWait();
            } else {
                cart.addMedia(selectedMedia);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Item Added");
                alert.setHeaderText("Item Added to Cart");
                alert.setContentText("The media '" + selectedMedia.getTitle() + "' has been added to your cart.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Media Selected");
            alert.setHeaderText("Please select a media item");
            alert.setContentText("You need to select an item before adding it to the cart.");
            alert.showAndWait();
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

      //      playableMedia.play();
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
    public StoreScreenController() {
    }

    /**
     * Đặt giỏ hàng hiện tại
     */
    public void setStore(Store store) {
        this.store = store;
        this.cart = CartSingleton.getCart();  
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

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                } else {
                    btnPlay.setVisible(false);
                }
            }
        });
    }

    /**
     * Cập nhật các nút hiển thị dựa trên mục đã chọn
     */
    private void updateButtonBar(Media media) {
        btnPlay.setVisible(media instanceof Playable);
    }

    /**
     * Xử lý khi nhấn nút Remove
     */
    @FXML
    private void btnRemovePressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            store.removeMedia(selectedMedia);
            loadCartItems();
        }
    }

    /**
     * Tải danh sách các mặt hàng và cập nhật tổng tiền
     */
    private void loadCartItems() {
        if (store != null) {
            allMediaItems = FXCollections.observableArrayList(store.getItemsInStore());
            tblMedia.setItems(allMediaItems);

        }
    }
}
