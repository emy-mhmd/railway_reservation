package Railway_reservation;

import java.sql.SQLException;


public class Passenger extends Person{




public Passenger(String name,int age,String email,String phone_number,String password)
{
super(name,age,email,phone_number,password);
}



public Passenger()
{
    super();
}

public boolean search(String username, String password)
{
    return MyJDBC.getInstance().searchpassenger(username,password);
}
public Passenger getpassenger(String username, String password)
{
    return MyJDBC.getInstance().getpassengerdata(username,password);
}

public void addpassenger(Passenger passenger) throws SQLException, ClassNotFoundException {
    MyJDBC.getInstance().insertpassenger(passenger);
}
    public boolean emailexist(String email) throws SQLException, ClassNotFoundException {
        return  MyJDBC.getInstance().isemailexist(email);
    }

    public boolean setpassword(String email,String newpassword) throws SQLException, ClassNotFoundException {
        return  MyJDBC.getInstance().setPassword(email,newpassword);
    }

}
