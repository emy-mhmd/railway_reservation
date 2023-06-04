
package Railway_reservation;

import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;


public class Showtrains extends Component {

  @FXML
  private FlowPane flowpan1;

    private String selectedroute;
    private String selectedcategory;

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



    @FXML
    public void back(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("passengerform.fxml"));
        Parent root = loader.load();
        Passengerformcontroller passengerformcontroller=loader.getController();
        passengerformcontroller.setSelectedpassenger(this.selectedpassenger);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



    public void displayTrainDetails() throws IOException {


        Trainschedule trains=new Trainschedule();
        ArrayList<Train> Trains_same_route = trains.getTrainsByRoute(this.selectedroute);

        for(int i=0;i<Trains_same_route.size();i++)
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Single_train.fxml"));
            AnchorPane pane=fxmlLoader.load();

           SingleTrain singletrain=fxmlLoader.getController();
           singletrain.setUsername(getUsername());
           singletrain.setPassword(getPassword());
           singletrain.settrain(Trains_same_route.get(i));
           singletrain.setSelectedcategory(this.selectedcategory);
           singletrain.setSelectedpassenger(selectedpassenger);
           singletrain.showtraindata();

           flowpan1.getChildren().add(pane);




        }


}
    public void setSelectedcategory(String selectedcategory)
    {
        this.selectedcategory=selectedcategory;
    }

    public String getselectedroute()
    {
        return selectedroute;
    }

    public void setSelectedroute(String selectedroute)
    {
        this.selectedroute=selectedroute;
    }


}
