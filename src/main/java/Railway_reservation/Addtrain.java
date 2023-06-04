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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class Addtrain extends Component {

    @FXML
    private TextField trainnumber;

    @FXML
    private TextField arrivingtime;
    @FXML
    private TextField route;
    @FXML
    private TextField cost;
    @FXML
    private TextField departuetime;

    @FXML
    public void add(javafx.event.ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if (trainnumber.getText().isEmpty()||arrivingtime.getText().isEmpty()||route.getText().isEmpty()||
        cost.getText().isEmpty()||departuetime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter all fields ", "try again",
                    JOptionPane.ERROR_MESSAGE);
        }

        else{
        double costt= Double.parseDouble(cost.getText());
        int trainnumberr= Integer.parseInt(trainnumber.getText());
        Staff staff=new Staff();

        staff.addtrain(trainnumberr,departuetime.getText(),route.getText(),arrivingtime.getText(),costt);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("staff.fxml"));
        Parent root = loader.load();
        Staff_info staffInfo=loader.getController();
        staffInfo.showtrains();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }

    public void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("staff.fxml"));
        Parent root = loader.load();
        Staff_info staffInfo=loader.getController();
        staffInfo.showtrains();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
