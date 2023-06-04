package Railway_reservation;

import java.sql.SQLException;

public class Train {
    private  int train_number;
    private String departuretime;
    private String arrivingtime;
    private String route;
    private int coach_number;
   private int number_of_seats_percoah;
    private double cost;




    public Train(int train_number, String departuretime, String route,String arriving_time,double cost) {
        this.coach_number=8;
        this.departuretime=departuretime;
        this.route=route;
        this.number_of_seats_percoah=80;
        this.train_number=train_number;
        this.arrivingtime=arriving_time;
        this.cost=cost;

        }




    public  Train()
    {

    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {

        this.cost = cost;
    }

    public String getArrivingtime() {
        return arrivingtime;
    }

    public void setArrivingtime(String arrivingtime) {
        this.arrivingtime = arrivingtime;
    }

    public int getCoach_number() {
        return coach_number;
    }

    public void setCoach_number(int coach_number) {
        this.coach_number = coach_number;
    }

    public int getTrain_number() {
        return train_number;
    }

    //going to use it in the staff form
    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }

    public String getRoute() {
        return route;
    }

    //going to use it in the staff form
    public void setRoute(String route) {
        this.route = route;
    }

    public int getNumber_of_seats() {
         return number_of_seats_percoah;
    }

    //going to use it in the staff form
    public void setNumber_of_seats(int number_of_seats) {

        this.number_of_seats_percoah = number_of_seats;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    //going to use it in the staff form
    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public boolean showseatavalibilty(int choosen_coach, int choosen_trainnuber,  int choosen_seatnumber,String day) throws SQLException {

          return MyJDBC.getInstance().available_seats(choosen_trainnuber,choosen_coach,choosen_seatnumber,day);

    }

    public void bookseat(int choosen_coach, int choosen_trainnuber, int choosen_seatnumber, String day) throws SQLException {

         MyJDBC.getInstance().bookseat(choosen_trainnuber,choosen_coach,choosen_seatnumber,day);

    }

    public boolean istrainexist(String route)
    {
       return MyJDBC.getInstance().istrainexist(route);

    }





}
