package Railway_reservation;

import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;


public class SingleTrain {
    private Train train;
    @FXML
    private Label route;
    @FXML
    private Label cost;


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

    public void setSelectedcategory(String selectedcategory) {
        this.selectedcategory = selectedcategory;
    }


    public void settrain(Train train) {
        this.train = train;
    }

    public void showtraindata() throws IOException {
        double costtrain;
        route.setText(this.train.getDeparturetime() + "-" + this.train.getArrivingtime());
        if (selectedcategory.equals("class2")) {
            costtrain = this.train.getCost();
            costtrain = costtrain / 2.0;
            this.train.setCost(costtrain);
        }
        cost.setText(this.train.getCost() + "E£");
    }

      @FXML
    public void selecttrain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Book.fxml"));
        Parent root = loader.load();
        Book book = loader.getController();
        book.setSelectedCategory(selectedcategory);
        book.setCoach_number();
        book.setSelectedpassenger(selectedpassenger);


        book.settselectedrain(this.train);


        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
