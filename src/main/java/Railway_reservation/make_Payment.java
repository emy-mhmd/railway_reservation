package Railway_reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class make_Payment extends Component {
    @FXML
    private Button ticketbutton;
    @FXML
    private TextField ticketamount;
    @FXML
    private TextField nameofcard;

    @FXML
    private PasswordField cardnumber;

    @FXML
    private TextField expiry;
    @FXML
    private TextField cvc;

  private   Passenger selectedpassenger;

    private String username;
    private String password;

    private String selectedcalss;

    private int selectedcoach;
    private ArrayList<Integer> selected_seats;


    private Train selectedtrain;
    private String selected_day;

    private double cost;
    private String seats;

    Paymentservice paymentservice=new Paymentservice();


    public void setSelectedpassenger(Passenger selectedpassenger)
    {
        this.selectedpassenger=selectedpassenger;
    }

      public void setSelected_day(String selected_day){this.selected_day=selected_day;}

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSelected_seats(ArrayList<Integer> selected_seats) {
        this.selected_seats = selected_seats;
    }

    public void setSelectedcalss(String selectedcalss) {
        this.selectedcalss = selectedcalss;
    }

    public void setSelectedcoach(String selectedcoach) {
        this.selectedcoach = Integer.parseInt(selectedcoach);
    }

    public void setSelectedtrain(Train selectedtrain) {
        this.selectedtrain = selectedtrain;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @FXML
    public void PAY(ActionEvent event) {
        Train train=new Train();
        ValidatorTest validatorTest = new ValidatorTest();

        if(cardnumber.getText().isEmpty()||nameofcard.getText().isEmpty()||expiry.getText().isEmpty()
        ||cvc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "please enter all fields ", "try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (!validatorTest.isValidCardNumber(cardnumber.getText()) || !validatorTest.isValidNameOfCard(nameofcard.getText())
                || !validatorTest.isValidExpiryDate(expiry.getText()) || !validatorTest.isValidCVCCode(cvc.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter valid payment details", "Try again", JOptionPane.ERROR_MESSAGE);

        }

        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful payment");
            alert.setHeaderText(null);
            alert.setContentText("Congratulations on choosing to travel with us! We hope you have a wonderful experience.");
            alert.showAndWait();


      paymentservice.makePaymentforticket();


        ticketbutton.setVisible(true);
        try {
            if (paymentservice.checkPaymentStatus()) {


                for (int i = 0; i < selected_seats.size(); i++) {
                    train.bookseat(selectedcoach, selectedtrain.getTrain_number(), selected_seats.get(i), selected_day);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }}

    @FXML
    public void show_ticket(ActionEvent event) throws IOException {
        seatsnumberinstring();
        System.out.println(seats);
        if(paymentservice.checkPaymentStatus())
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket_info.fxml"));
            Parent root = loader.load();
            TicketInfo ticketInfo=loader.getController();
            ticketInfo.setlabels(selectedpassenger.getName(),selectedtrain.getRoute(),cost,selectedcoach,
                    selectedtrain.getTrain_number(),selectedtrain.getArrivingtime(),selectedtrain.getDeparturetime(),
                    selectedcalss,selected_day,seats);
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }


    public void setTicketamount()
    {

        cost= selectedtrain.getCost();
        Tickets tickets=new Tickets();

       int age=selectedpassenger.getAge();
       if(16<age&&age<18)
       {
        tickets.setTicket_cost(cost,0.2);

       }
       else
           tickets.setTicket_cost(cost);

       cost=tickets.getTicket_cost()*selected_seats.size();
        ticketamount.setText(cost+"E£");
    }

    public void seatsnumberinstring()
    { this.seats = String.valueOf(selected_seats.get(0));
        for (int i = 1; i < selected_seats.size(); i++) {
            this.seats += "," + selected_seats.get(i);
        }

    }


}
