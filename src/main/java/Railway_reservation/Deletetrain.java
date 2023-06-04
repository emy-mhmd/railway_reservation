package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Deletetrain extends Component {

    @FXML
    private TextField trainnumber;

    public void delete(ActionEvent event) throws IOException {
        if (trainnumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter the train number ", "try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{

        int trainnum= Integer.parseInt(trainnumber.getText());
        Staff staff=new Staff();
        staff.deletetrain(trainnum);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("staff.fxml"));
        Parent root = loader.load();
        Staff_info staffInfo=loader.getController();
        staffInfo.showtrains();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }}

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
