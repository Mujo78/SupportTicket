package ptf.rs.utils;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Utilities {

    public static void displaySeparateModel(String name, Parent parent){
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Support ticket form");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    public static void displayAlertMessage(String conText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(conText);
        alert.showAndWait();
    }
}
