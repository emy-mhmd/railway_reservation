package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class Registercontroller extends Component {
    @FXML
    private TextField usernameTextfield;

    @FXML
    protected PasswordField passwordfield;

    @FXML
    private TextField emailTextfield;

    @FXML
    private TextField ageTextfield;

    @FXML
    private TextField phonenumberTextfield;
    @FXML
    private PasswordField confpasswordfield;





    public void backlog(javafx.event.ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        String username = usernameTextfield.getText();
        String password = passwordfield.getText();
        String email = emailTextfield.getText();
        String age = ageTextfield.getText();
        String phone = phonenumberTextfield.getText();
        String conf = confpasswordfield.getText();
        ValidatorTest emailValidatorTest = new ValidatorTest();
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || age.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter all fields", "try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!emailValidatorTest.testEmailFormat(email)) {
            JOptionPane.showMessageDialog(this, "please enter a correct email format", "try again",
                    JOptionPane.ERROR_MESSAGE);

        }
        else if (!conf.equals(password)) {
            JOptionPane.showMessageDialog(this, "the password is not correct", "try again",
                    JOptionPane.ERROR_MESSAGE);

        }
        else {
            int agenumber = Integer.parseInt(age);

            Passenger passenger = new Passenger(username, agenumber, email, phone, password);

            try {
                passenger.addpassenger(passenger);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration Successful");
            alert.setHeaderText(null);
            alert.setContentText("Your account has been created.");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
}