import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import marshmallow.Marshmallow;
import marshmallow.ui.MainViewController;

/**
 * The main application.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainView.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);

            MainViewController controller = fxmlLoader.<MainViewController>getController();
            Marshmallow marshmallow = new Marshmallow("data/tasks.txt");
            marshmallow.setDelegate(controller);
            controller.setMarshmallow(marshmallow);

            stage.setMinHeight(220);
            stage.setMinWidth(417);
            stage.setTitle("Marshmallow");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
