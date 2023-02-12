package ptf.rs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class HelloApplication extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        Config.DEBUG_MODE = getParameters().getRaw().contains("-debug");
    }

    @Override
    public void start(Stage stage) {

            Scene scene = new Scene(View.createView("views/hello-view.fxml"));
            stage.setTitle("Support ticket app");
            stage.setScene(scene);
            stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}