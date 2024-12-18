package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	Boolean whatColor = true;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(whatColor == true) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLUE);
            drawingAreaPane.getChildren().add(newCircle);
    	} else {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 15, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
    	}
    }
    
    @FXML
    void eraseToolChosen(ActionEvent event) {
    	whatColor = false;
    }

    @FXML
    void penToolChosen(ActionEvent event) {
    	whatColor = true;
    }
}
