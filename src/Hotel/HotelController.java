package Hotel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HotelController {

    @FXML
    private AnchorPane MainAnchor;
    @FXML
    private AnchorPane SubAnchor;
    @FXML
    private Region MainRegion, SidePanel,BotLeft;
    @FXML
    private Region TopLeft,TopBar;
    @FXML
    private Pane Select1;
    @FXML
    private Pane Select2;
    @FXML
    private Pane Select3;
    @FXML
    private Pane Select4;
    @FXML
    private TextField TextHotel;
    @FXML
    private Label welcomeText;
    @FXML
    private Button InCheck;
    @FXML
    private Button OutCheck;
    @FXML
    private Button Booking;
    @FXML
    private Button Guest;
    @FXML
    private Button close;
    @FXML
   void close(MouseEvent event){
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }


    public void paneSwitch(String input) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(input));
            SubAnchor.getChildren().clear();
            AnchorPane newPane = loader.load();
            AnchorPane.setBottomAnchor(newPane, 0.0);
            AnchorPane.setLeftAnchor(newPane, 0.0);
            AnchorPane.setRightAnchor(newPane, 0.0);
            AnchorPane.setTopAnchor(newPane, 0.0);
            SubAnchor.getChildren().setAll(newPane);

        } catch (IOException e) {

            e.printStackTrace();
        }


    }

    @FXML
    public void subSwitch(){
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setBlurType(BlurType.GAUSSIAN);
        innerShadow.setColor(Color.BLACK);
        innerShadow.setHeight(30);
        innerShadow.setWidth(30);
        innerShadow.setRadius(15);
        innerShadow.setChoke(0.1);

        InCheck.setOnMouseClicked( event -> {
           //----------------------------------------------------
            Select1.setStyle("-fx-background-color: #ffa800");
            Select1.setEffect(innerShadow);
           //---------------------------------------------------
            Select2.setStyle("-fx-background-color: transparent");
            Select2.setEffect(null);
            Select3.setStyle("-fx-background-color: transparent");
            Select3.setEffect(null);
            Select4.setStyle("-fx-background-color: transparent");
            Select4.setEffect(null);
            paneSwitch("/CheckIn/CheckIn-FXML.FXML");
        });
        OutCheck.setOnMouseClicked( event -> {
            Select1.setStyle("-fx-background-color: transparent");
            Select1.setEffect(null);
            //--------------------------------------------------
            Select2.setStyle("-fx-background-color: #ffa800");
            Select2.setEffect(innerShadow);
           //---------------------------------------------------
            Select3.setStyle("-fx-background-color: transparent");
            Select3.setEffect(null);
            Select4.setStyle("-fx-background-color: transparent");
            Select4.setEffect(null);

            paneSwitch("/CheckOut/CheckOut-FXML.fxml");
        });
        Booking.setOnMouseClicked( event -> {
            Select1.setStyle("-fx-background-color: transparent");
            Select1.setEffect(null);
            Select2.setStyle("-fx-background-color: transparent");
            Select2.setEffect(null);
            //----------------------------------------------------
            Select3.setStyle("-fx-background-color: #ffa800");
            Select3.setEffect(innerShadow);
            //-----------------------------------------------------
            Select4.setStyle("-fx-background-color: transparent");
            Select4.setEffect(null);

            paneSwitch("/Booking/Booking-FXML.fxml");
        });
        Guest.setOnMouseClicked( event -> {
            Select1.setStyle("-fx-background-color: transparent");
            Select1.setEffect(null);
            Select2.setStyle("-fx-background-color: transparent");
            Select2.setEffect(null);
            Select3.setStyle("-fx-background-color: transparent");
            Select3.setEffect(null);
            //---------------------------------------------------
            Select4.setStyle("-fx-background-color: #ffa800");
            Select4.setEffect(innerShadow);
            //---------------------------------------------------
            paneSwitch("/GuestList/GuestList-FXML.fxml");
        });

    }
}
