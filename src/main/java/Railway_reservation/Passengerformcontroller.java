package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Passengerformcontroller extends Component implements Initializable {


    @FXML
    public TextField fromm;
    @FXML
    public TextField to;
    @FXML
    public ChoiceBox<String> categore;
     private String username;
     private String password;
    private   Passenger selectedpassenger;
    public void setSelectedpassenger(Passenger selectedpassenger)
    {
        this.selectedpassenger=selectedpassenger;
    }

     public void setUsername(String username)
     {
         this.username=username;
     }

    public void setPassword(String password)
    {
        this.password=password;
    }
     public String getUsername()
     {
         return username;
     }
     public String getPassword()
     {
         return password;
     }



    public String[] categores={"class1","class2"};




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categore.getItems().addAll(categores);
    }
    public String returnroute()
    {

        String start=fromm.getText();
        String distination=to.getText();
        String route=start+"-"+distination;

        return route;
    }
    @FXML
        protected void trainroute(ActionEvent event) throws IOException {
        Train train=new Train();


        if (fromm.getText().isEmpty() || to.getText().isEmpty() || categore == null ||
                categore.getValue() == null || categore.getValue().isEmpty()) {
            JOptionPane.showMessageDialog(this, "please enter all fields ", "try again",
                    JOptionPane.ERROR_MESSAGE);


        }
       else if(!train.istrainexist(returnroute()))
        {
            JOptionPane.showMessageDialog(this, "no trains for the selected route ", "try again",
                    JOptionPane.ERROR_MESSAGE);

        }
        else{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("showtrains.fxml"));
            Parent root = loader.load();
            Showtrains showtrains = loader.getController();
            showtrains.setUsername(getUsername());
            showtrains.setPassword(getPassword());
            showtrains.setSelectedpassenger(selectedpassenger);

            showtrains.setSelectedcategory(this.getcategore());
            showtrains.setSelectedroute(this.returnroute());

            showtrains.displayTrainDetails();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
        public String getcategore () {


            return categore.getValue();
        }


    }


