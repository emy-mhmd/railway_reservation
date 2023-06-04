package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;


public class Admin extends Component {


    @FXML
    private TextField staff_id;

    @FXML
    private TextField staff_name;
    @FXML
    private TextField staff_age;

    @FXML
    private TextField staff_email;
    @FXML
    private TextField staff_phone;

    @FXML
    private PasswordField staff_password;
    @FXML
    private TextField staff_salary;

    @FXML
    private TextField staff_role;

    public String getStaff_age() {
        return staff_age.getText();
    }

    public String getStaff_email() {
        return staff_email.getText();
    }

    public String getStaff_id() {
        return staff_id.getText();
    }

    public String getStaff_name() {

        return staff_name.getText();
    }

    public String getStaff_password() {
        return staff_password.getText();
    }

    public String getStaff_phone() {
        return staff_phone.getText();
    }

    public String getStaff_role() {
        return staff_role.getText();
    }

    public String getStaff_salary() {
        return staff_salary.getText();
    }



    @FXML

    public void add_staff(javafx.event.ActionEvent event) throws SQLException, ClassNotFoundException, IOException {


        ValidatorTest emailValidatorTest = new ValidatorTest();
        if (getStaff_name().isEmpty() || getStaff_password().isEmpty() || getStaff_age().isEmpty()
                ||getStaff_phone().isEmpty() || getStaff_email().isEmpty()|| getStaff_salary().isEmpty()
                || getStaff_id().isEmpty()|| getStaff_role().isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter all fields", "try again",
                    JOptionPane.ERROR_MESSAGE);

        }
        if (!emailValidatorTest.testEmailFormat(getStaff_phone())) {
            JOptionPane.showMessageDialog(this, "please enter a correct email format", "try again",
                    JOptionPane.ERROR_MESSAGE);

        }
        else {
            int age= Integer.parseInt(getStaff_age());
            double salary= Double.parseDouble(getStaff_salary());

            Staff staff = new Staff(getStaff_id(),getStaff_name(), age,  getStaff_email(),getStaff_phone(),
                    getStaff_password()   , salary, getStaff_role());

            staff.addstaff(staff);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("staff is added Successfully");
            alert.setHeaderText(null);
            alert.setContentText("staff is added Successfully.");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void back(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }
}
