package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Staff_info {

    @FXML
    private TableView<Train> traintable;

    @FXML
    private TableColumn<Train, Integer> trainnumber;

    @FXML
    private TableColumn<Train, String> departuretime;

    @FXML
    private TableColumn<Train, String> arriving_time;

    @FXML
    private TableColumn<Train, Double> cost;

    @FXML
    private TableColumn<Train, String> route;



    public void showtrains() {
        Trainschedule trainschedule = new Trainschedule();
        ArrayList<Train> trains = trainschedule.gettrains();

        trainnumber.setCellValueFactory(new PropertyValueFactory<>("train_number"));
        departuretime.setCellValueFactory(new PropertyValueFactory<>("departuretime"));
        arriving_time.setCellValueFactory(new PropertyValueFactory<>("arrivingtime"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        route.setCellValueFactory(new PropertyValueFactory<>("route"));

        traintable.getItems().addAll(trains);
    }



    @FXML
    public void addtrain(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addtrain.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();





    }

    public void delete(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("deletetrain.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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