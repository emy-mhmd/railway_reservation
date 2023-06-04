package Railway_reservation;

import java.sql.SQLException;

public class Staff extends Person{

    double salary;
    String staffid;
    String role;

    public Staff(String staffid,String name, int age, String email ,  String phone_number, String password,double salary,  String role) {
        super(name, age, phone_number, email,password);

        this.role=role;
        this.salary=salary;
        this.staffid=staffid;
    }

    public Staff()
    {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public void addstaff(Staff staff) throws SQLException, ClassNotFoundException {
        MyJDBC.getInstance().insertstaff(staff);
    }
    public boolean search(String staffid, String password)
    {
        return MyJDBC.getInstance().searchstaff(staffid,password);
    }
    public void addtrain(int trainnumberr,String departuetime, String route,String arrivingtime,double costt)
            throws SQLException, ClassNotFoundException {
    Train train=new Train(trainnumberr,departuetime,route,arrivingtime,costt);
        MyJDBC.getInstance().inserttrain(train);
    }
    public void deletetrain(int train_number) {
        MyJDBC.getInstance().deletetrain(train_number);
    }
}
