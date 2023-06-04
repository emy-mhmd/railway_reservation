package Railway_reservation;

import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Logincontroller extends Component {

    @FXML
    private TextField usernamefield;

    @FXML
    private TextField loginpasswordfield;

    public String getusername()
    {
        return usernamefield.getText();
    }
   public String getpassword()
   {
       return loginpasswordfield.getText();
   }

    @FXML


    protected void reg(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void log(ActionEvent event) throws IOException {
        Passenger passenger=new Passenger();
        Staff staff=new Staff();
        String username = usernamefield.getText();
       String password = loginpasswordfield.getText();
        if (password.isEmpty() || username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter all fields ", "try again",
                    JOptionPane.ERROR_MESSAGE);
        }

       else if(password.equals("1")&&username.equals("1"))
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } else if (staff.search(username,password)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("staff.fxml"));
            Parent root = loader.load();
            Staff_info staffInfo=loader.getController();
            staffInfo.showtrains();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();


        } else if (passenger.search(username,password)) {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("passengerform.fxml"));
            Parent root = loader.load();
            Passengerformcontroller passengerformcontroller=loader.getController();
            passengerformcontroller.setUsername(getusername());
            passengerformcontroller.setPassword(getpassword());
            passengerformcontroller.setSelectedpassenger(passenger.getpassenger(username,password));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else {
            JOptionPane.showMessageDialog(this, "username or password wrong please try again", "try again",
                    JOptionPane.ERROR_MESSAGE);

        }


        }

    public void forgetpassword(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetpassword.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}






