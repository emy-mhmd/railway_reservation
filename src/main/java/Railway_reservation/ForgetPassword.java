package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;


import java.sql.SQLException;


public class ForgetPassword {

    @FXML
    private TextField selectedemail;
    @FXML
    private PasswordField pass;

    @FXML

    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void backlogin(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        boolean successfully=false;
        String email = selectedemail.getText();
        Passenger passenger = new Passenger();

        boolean exist = passenger.emailexist(email);
        if (exist) {
             successfully = passenger.setpassword(email, pass.getText());
        }
            if (successfully) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Password Retrieval");
                alert.setHeaderText(null);
                alert.setContentText("Your password has been changed");
                alert.showAndWait();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password Retrieval");
                alert.setHeaderText(null);
                alert.setContentText("The email address you entered is not registered with us.");
                alert.showAndWait();
            }





    }
        }


