package CheckOut;

import Data.Guests;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class CheckOutController implements Initializable {
    Guests guest = new Guests();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        guest.read();
    }
}
