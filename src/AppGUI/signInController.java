package AppGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class signInController implements Initializable {

    @FXML
    private Button bttSignIn;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfUsername;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bttSignIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean canSignIn = checkCredentials();

                if(canSignIn){
                    System.out.println("Credentials are correct!");
                    UtilsMethods.changeScene(actionEvent, "loggedIn.fxml", true, false);
                    printData();
                }
                else {
                    System.out.println("Credentials are incorrect!");
                }
            }
        });
    }

    public boolean checkCredentials(){
        return SQLConnection.checkUserInSQL(tfUsername.getText(), tfPassword.getText());
    }

    public void printData(){
        System.out.println(tfUsername.getText() + " " + tfPassword.getText());
    }


}
