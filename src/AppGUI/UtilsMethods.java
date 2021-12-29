package AppGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UtilsMethods {

    public static void changeScene(ActionEvent event, String fxmlfile, boolean signingIn, boolean signingOut){
        Parent root = null;

        if (signingIn){
            try{
                FXMLLoader loader = new FXMLLoader(UtilsMethods.class.getResource(fxmlfile));
                root = loader.load();

            }catch (IOException e){
                e.printStackTrace();
            }
        } else if (signingOut){
            try{
                root = FXMLLoader.load(UtilsMethods.class.getResource(fxmlfile));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Logged in!");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }


}
