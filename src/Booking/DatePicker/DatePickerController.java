package Booking.DatePicker;


import Data.Guests;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DatePickerController implements Initializable {

    Guests guest = new Guests();
    @FXML
    private DatePicker StartDate;
    @FXML
    private DatePicker EndDate;
    @FXML
    private CheckBox R1;
    @FXML
    private CheckBox R2;
    @FXML
    private CheckBox R4;
    @FXML
    private TextField VoorNaam;
    @FXML
    private TextField AchterNaam;
    @FXML
    private TextField VoorNaam1;
    @FXML
    private TextField AchterNaam1;
    @FXML
    private TextField VoorNaam2;
    @FXML
    private TextField AchterNaam2;
    @FXML
    private TextField VoorNaam3;
    @FXML
    private TextField AchterNaam3;
    @FXML
    private Button close;

    @FXML
    public void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void PickStart() {
        LocalDate sDate = StartDate.getValue();
        System.out.println(sDate.toString());
    }

    public void PickEnd() {
        LocalDate eDate = EndDate.getValue();
        System.out.println(eDate.toString());
    }


    public void room() {

        R1.setOnMouseClicked(e -> {
            R1.setSelected(true);
            R2.setSelected(false);
            R4.setSelected(false);

            VoorNaam.setVisible(true);
            VoorNaam1.setVisible(false);
            VoorNaam2.setVisible(false);
            VoorNaam3.setVisible(false);
            AchterNaam.setVisible(true);
            AchterNaam1.setVisible(false);
            AchterNaam2.setVisible(false);
            AchterNaam3.setVisible(false);
        });

        R2.setOnMouseClicked(e -> {
            R1.setSelected(false);
            R2.setSelected(true);
            R4.setSelected(false);

            VoorNaam.setVisible(true);
            VoorNaam1.setVisible(true);
            VoorNaam2.setVisible(false);
            VoorNaam3.setVisible(false);
            AchterNaam.setVisible(true);
            AchterNaam1.setVisible(true);
            AchterNaam2.setVisible(false);
            AchterNaam3.setVisible(false);
        });

        R4.setOnMouseClicked(e -> {
            R1.setSelected(false);
            R2.setSelected(false);
            R4.setSelected(true);

            VoorNaam.setVisible(true);
            VoorNaam1.setVisible(true);
            VoorNaam2.setVisible(true);
            VoorNaam3.setVisible(true);
            AchterNaam.setVisible(true);
            AchterNaam1.setVisible(true);
            AchterNaam2.setVisible(true);
            AchterNaam3.setVisible(true);
        });
    }

    public void setName() throws FileNotFoundException {
        String a = VoorNaam.getText();
        String b = AchterNaam.getText();
        String c = guest.rndUnique();
        if (c == null) {
            System.out.println("Failed");
        } else {
            System.out.println(a + " " + b + " " + c);
            guest.setName(a, b, c);
            guest.write();
            guest.fullOrder(c);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guest.read();
        VoorNaam.setVisible(false);
        VoorNaam1.setVisible(false);
        VoorNaam2.setVisible(false);
        VoorNaam3.setVisible(false);
        AchterNaam.setVisible(false);
        AchterNaam1.setVisible(false);
        AchterNaam2.setVisible(false);
        AchterNaam3.setVisible(false);

    }
}




