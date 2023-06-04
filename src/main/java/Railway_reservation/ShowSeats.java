package Railway_reservation;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.sql.SQLException;
import java.util.ArrayList;

public class ShowSeats {
    @FXML
    private GridPane gridPane1;

    private String selectedcategory;
    private int selected_coach;
    private String selected_day;
    private int trainnumber;
   private int buttonnumber;

   private int selectedbutton;



   public ArrayList<Integer>bookedseatsnumber=new ArrayList<>();

   public void setSelectedcategory(String selectedcategory) {
        this.selectedcategory = selectedcategory;
    }

    public void setselectedcoach(int selected_coach) {
        this.selected_coach = selected_coach;
    }

    public void setSelectedday(String selected_day) {
        this.selected_day = selected_day;
    }

    public void setchoosentrain_number(int triannumber) {
        this.trainnumber = triannumber;
    }

    public void  setselectedbutton(int selectedbutton){this.selectedbutton=selectedbutton;}


    public void printBookedSeatsNumber() {
        ArrayList<Integer> bookedSeats = getSelectedSeats();
        for (int i = 0; i < bookedSeats.size(); i++) {
            System.out.println("Booked seat " + (i+1) + ": " + bookedSeats.get(i));
        }
    }

    public ArrayList<Integer> getSelectedSeats() {
        return bookedseatsnumber;
    }




    public void showseats() throws SQLException {


        if (selectedcategory.equals("class1")) {

       seatsloop(4,10);


         }

        else if (selectedcategory.equals("class2")) {
       seatsloop(4,20);
        }

        for(int i=0;i<getSelectedSeats().size();i++)
        {
            System.out.println(getSelectedSeats().get(i));
        }
          printBookedSeatsNumber();

    }



    public void seatsloop(int columnloop,int rowloop) throws SQLException { Train train = new Train();
        for (int column = 0; column < columnloop; column++) {
            buttonnumber = column + 1;

            for (int row = 0; row < rowloop; row++) {

                Button button = new Button(String.valueOf(buttonnumber));


                Boolean isnotavailable = train.showseatavalibilty(selected_coach, trainnumber, buttonnumber, selected_day);

                if (!isnotavailable) {
                    button.setBackground(Background.fill(new Color(0, 1, 0, 1)));
                } else {
                    button.setBackground(Background.fill(new Color(1, 0, 0, 1)));
                }


                button.setOnAction(event -> {
                    int buttonnum = Integer.parseInt(button.getText());
                    if (!isnotavailable) {
                        if (bookedseatsnumber.contains(buttonnum)) {
                            button.setBackground(Background.fill(new Color(0, 1, 0, 1)));
                            synchronized(bookedseatsnumber) {
                                bookedseatsnumber.remove(Integer.valueOf(buttonnum));

                            }
                        } else {
                            button.setBackground(Background.fill(new Color(1, 0, 0, 1)));
                            synchronized(bookedseatsnumber) {
                                bookedseatsnumber.add(buttonnum);

                            }


                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Seat Already Booked");
                        alert.setHeaderText("This seat has already been booked.");
                        alert.showAndWait();
                    }
                });


                if (selectedcategory.equals("class1")) {

                    gridPane1.add(button, column, row);
                    gridPane1.setAlignment(Pos.CENTER);

                    gridPane1.setPrefHeight(350);
                    gridPane1.setPrefWidth(400);
                    gridPane1.setVgap(10);
                    gridPane1.setHgap(10);




                }

                if (selectedcategory.equals("class2")) {


                    gridPane1.add(button, column, row);
                    gridPane1.setAlignment(Pos.CENTER);

                    gridPane1.setPrefHeight(700);
                    gridPane1.setPrefWidth(400);
                    gridPane1.setVgap(10);
                    gridPane1.setHgap(10);




                }
                buttonnumber += 4;


            }
        }

    }
}
