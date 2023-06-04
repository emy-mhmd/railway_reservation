package Railway_reservation;


import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;


import javafx.scene.layout.AnchorPane;


import java.awt.*;
import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.swing.*;



public class Book extends Component implements Initializable {
    @FXML
    public ChoiceBox<String> coach_number;

 @FXML
 private AnchorPane pane1;


    @FXML
    public ChoiceBox<String>day;
    public String[] dayes={"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};

    private ArrayList<Integer>selectedseats;

    public String[] coachs;

    private String selectedCategory;

    private String username;
    private String password;
    private Train train;
    private   Passenger selectedpassenger;
    public void setSelectedpassenger(Passenger selectedpassenger)
    {
        this.selectedpassenger=selectedpassenger;
    }

    public void settselectedrain(Train train)
    {
        this.train=train;
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

    public void setSelectedseats(ArrayList<Integer>selectedseats)
    {
        this.selectedseats=selectedseats;
    }


    @FXML
    public void back_to_showtrain(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("passengerform.fxml"));
        Parent root = loader.load();
        Passengerformcontroller passengerformcontroller=loader.getController();
        passengerformcontroller.setSelectedpassenger(this.selectedpassenger);



        Scene scene = new Scene(root);


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.setScene(scene);
        stage.show();
    }
    public void setSelectedCategory(String selectedCategory)
    {
        this.selectedCategory=selectedCategory;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        day.getItems().addAll(dayes);


    }

    public void selectCoaches() {
        if (selectedCategory.equals("class1")) {
            coachs = new String[]{"1", "2", "3", "4"};
        } else if (selectedCategory.equals("class2")) {
            coachs = new String[]{"5", "6", "7", "8"};
        }


    }
    @FXML
    public void payment(ActionEvent event) throws IOException {

        if(this.coach_number.getValue()==null||this.get_day()==null||selectedseats==null)
        {
            JOptionPane.showMessageDialog(this, "please enter all fields ", "try again",
                    JOptionPane.ERROR_MESSAGE);
        }

        if(selectedseats.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "please select a seat ", "try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
            Parent root = loader.load();
            make_Payment makePayment = loader.getController();
            makePayment.setSelectedpassenger(selectedpassenger);
            makePayment.setPassword(getPassword());
            makePayment.setUsername(getUsername());
            makePayment.setSelectedcalss(selectedCategory);
            makePayment.setSelectedcoach(coach_number.getValue());
            makePayment.setSelected_seats(selectedseats);
            makePayment.setSelectedtrain(this.train);
            makePayment.setSelected_day(this.get_day());
            makePayment.setTicketamount();


        Scene scene = new Scene(root);


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.setScene(scene);
        stage.show();
    }}

   @FXML
    public void selectseats(ActionEvent event) throws SQLException, IOException {

       if(this.coach_number.getValue()==null||this.get_day()==null)
       {
           JOptionPane.showMessageDialog(this, "please enter all fields ", "try again",
                   JOptionPane.ERROR_MESSAGE);
       }

       else {
           FXMLLoader fxmlLoader = new FXMLLoader();
           fxmlLoader.setLocation(getClass().getResource("show_seats.fxml"));
           AnchorPane pane = fxmlLoader.load();
           ShowSeats showSeats = fxmlLoader.getController();
           showSeats.setSelectedcategory(selectedCategory);
           showSeats.setselectedcoach(this.get_coach());
           showSeats.setchoosentrain_number(this.train.getTrain_number());
           showSeats.setSelectedday(this.get_day());

           showSeats.showseats();
           setSelectedseats(showSeats.getSelectedSeats());


           if (selectedCategory.equals("class2")) {
               pane1.setPrefHeight(750);
               pane1.setPrefWidth(411);
           }
           pane1.getChildren().add(pane);

       }
}



    public void setCoach_number()
    {
        this.selectCoaches();
        coach_number.getItems().addAll(coachs);
    }



public int get_coach()
{
    return Integer.parseInt(coach_number.getValue());
}
public String get_day()
{
    return day.getValue();
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
