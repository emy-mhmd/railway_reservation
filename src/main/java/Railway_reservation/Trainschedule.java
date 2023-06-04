package Railway_reservation;

import java.util.ArrayList;

public class Trainschedule {



    public Trainschedule() {


    }
public ArrayList<Train>gettrains()
{
    return MyJDBC.getInstance().getAllTrains();
}
public ArrayList<Train>getTrainsByRoute(String route){

          return MyJDBC.getInstance().showtrain(route);
}
}
