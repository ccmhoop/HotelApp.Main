package CheckIn;

import Data.Guests;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckInController implements Initializable {

    Guests guest = new Guests();

    @FXML
    private AnchorPane SubPane;
    @FXML
    private TextField OrderID;

    @FXML
    private TextArea Fam;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    guest.read();


    }

    public void order(){
        String a;
        try{
            a = OrderID.getText();
           int b = guest.getGuest(a);
            System.out.println(b);
            Fam.setText(guest.Checkin(b));
        }catch (NumberFormatException e){

        }catch (Exception e){

        }

    }

}
