package Booking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.time.DayOfWeek.*;

public class BookingController implements Initializable {
    @FXML
    private AnchorPane SubPane;

    @FXML
    private GridPane Calendar;
    @FXML
    private Button pick;
    @FXML
    private Label Days;
    @FXML
    private Text text;
    @FXML
    private ActionEvent event;
   // @FXML
   // private Button close;

    double x, y = 0;

    String m = String.valueOf(MONDAY),t = String.valueOf(TUESDAY),w = String.valueOf(WEDNESDAY),
            th = String.valueOf(THURSDAY),f= String.valueOf(FRIDAY),s = String.valueOf(SATURDAY),su = String.valueOf(SUNDAY);

    @FXML
    public void close(MouseEvent event){
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
/*
    void butClose(){
        close.setOnMouseClicked( event -> {
            //----------------------------------------------------

        });
    }

 */


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      // DaysOfTheWeek day = DaysOfTheWeek.MONDAY;
        days();

    }

    public void days(){

        this.text = new Text();
        this.text.setText("DAYS");
        this.Calendar.add(text, 0, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.MONDAY));
        this.Calendar.add(text, 1, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.TUESDAY));
        this.Calendar.add(text, 2, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.WEDNESDAY));
        this.Calendar.add(text, 3, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.THURSDAY));
        this.Calendar.add(text, 4, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.FRIDAY));
        this.Calendar.add(text, 5, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.SATURDAY));
        this.Calendar.add(text, 6, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

        this.text = new Text();
        this.text.setText(String.valueOf(DaysOfTheWeek.SUNDAY));
        this.Calendar.add(text, 7, 0);
        this.text.setFill(Color.WHITE);
        this.text.setTextAlignment(TextAlignment.CENTER);

    }

    @FXML
    public void pickScene(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Booking/DatePicker/DatePicker-FXML.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root,570,560);
           scene.setFill(Color.TRANSPARENT);
            //stage.setScene(new Scene(root));
            root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent ->{
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });

            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/Booking/DatePicker/DatePicker-CSS.css")).toExternalForm());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.TRANSPARENT);



            stage.setScene(scene);
            stage.show();

        } catch (IOException e){

        }
    }
}