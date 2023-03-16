package Hotel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Hotel extends Application {

    double x, y = 0;

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Hotel-FXMl.fxml"))));
            primaryStage.setTitle("Title");
            Scene scene = new Scene(root,1030,640);
            scene.setFill(Color.TRANSPARENT);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });
            root.setOnMouseDragged(mouseEvent ->{
                primaryStage.setX(mouseEvent.getScreenX() - x);
                primaryStage.setY(mouseEvent.getScreenY() - y);
            });
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Hotel-CSS.css")).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

