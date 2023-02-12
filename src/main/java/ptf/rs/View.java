package ptf.rs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class View {
    public static Parent createView(String name){
        FXMLLoader loader = new FXMLLoader(View.class.getResource(name));
        try{
            return loader.load();
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
