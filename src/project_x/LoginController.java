package project_x;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.sql.*;

public class LoginController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Pane homePane;
    private Pane registerPane;
    private Pane listPane;
    private Pane lotteryPane;
    private Pane aboutusPane;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private Label loginLabel;
    @FXML
    private Button loginButton;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void switchToHome(ActionEvent event) throws Exception {
        if(usernameTF.getText().isEmpty() || passwordTF.getText().isEmpty()){
            loginLabel.setText("Empty Password or Username");
        }
        else{
        
        DatabaseConectivity db = new DatabaseConectivity();
        Connection conn = db.databaseConnectivity();

        String query = "select * from admin where username=? and password=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, usernameTF.getText());
        pst.setString(2, passwordTF.getText());
        
        ResultSet rs = pst.executeQuery();
        if(rs.next()) {
            
            loginLabel.setText("Successfully logged In");
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
         stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         scene=new Scene(root);
         stage.setScene(scene);
         stage.show();
        }
                 //   loginButton.getScene().getWindow().hide();
         else {
            loginLabel.setText("Incorrect password or username");
        }
        
    }
    }

    /*public void loginValidation() throws Exception {
        DatabaseConectivity db = new DatabaseConectivity();
        Connection conn = db.databaseConectivity();

        String query = "select * from admin where username=? and password=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, usernameTF.getText());
        pst.setString(2, passwordTF.getText());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            loginLabel.setText("Successfully loged In");
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
 
        } else {
            loginLabel.setText("Incorrect password or username");
        }

    }*/




}
