package Railway_reservation;

import java.sql.*;
import java.util.ArrayList;

public class MyJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/railway_reservation";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "emohanaa1";
    private static MyJDBC instance = null;

    private MyJDBC() {
        // private constructor to prevent instantiation
    }

    public static MyJDBC getInstance() {
        if (instance == null) {
            instance = new MyJDBC();


        }
        return instance;
    }

    public void insertpassenger(Passenger passenger) throws SQLException, ClassNotFoundException {

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "INSERT INTO passenger (name, age, email, phone_number, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, passenger.getName());
        stmt.setInt(2, passenger.getAge());
        stmt.setString(3, passenger.getEmail());
        stmt.setString(4, passenger.getPhone_number());
        stmt.setString(5, passenger.getPassword());


        stmt.executeUpdate();
        stmt.close();

    }

    public void insertstaff(Staff staff) throws SQLException, ClassNotFoundException {

        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "INSERT INTO staff (idstaff,name, age, email, phone_number, password,salary,role) VALUES " +
                "(?, ?, ?, ?, ?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, staff.getStaffid());
        stmt.setString(2, staff.getName());
        stmt.setInt(3, staff.getAge());
        stmt.setString(4, staff.getEmail());
        stmt.setString(5, staff.getPhone_number());
        stmt.setString(6, staff.getPassword());
        stmt.setDouble(7, staff.getSalary());
        stmt.setString(8, staff.getRole());


        stmt.executeUpdate();
        stmt.close();

    }

    public void inserttrain(Train train) throws SQLException, ClassNotFoundException {
        //  Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        String sql = "INSERT INTO train_schedule (train_number,departuretime, route,arriving_time, cost) VALUES " + "(?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, train.getTrain_number());
        stmt.setString(2, train.getDeparturetime());
        stmt.setString(3, train.getRoute());
        stmt.setString(4, train.getArrivingtime());
        stmt.setDouble(5, train.getCost());

        stmt.executeUpdate();
        stmt.close();

    }

    public void deletetrain(int trainnumber) {
        try {

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "DELETE FROM train_schedule WHERE train_number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, trainnumber);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean searchstaff(String staffid, String password) {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM staff WHERE idstaff = '" + staffid + "' AND password = '" + password + "'");

            return resultSet.next();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

            public boolean searchpassenger(String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM passenger WHERE name = '" + username + "' AND password = '" + password + "'");


            return resultSet.next();


        }


        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Train> showtrain(String route) {
        ArrayList<Train> trains = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM  train_schedule where route= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, route);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int trainNumber = rs.getInt("train_number");
                String arrivingTime = rs.getString("arriving_time");

                double cost = rs.getDouble("cost");
                String departureTime = rs.getString("departuretime");

                Train train = new Train(trainNumber, departureTime, route, arrivingTime, cost);
                trains.add(train);


            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return trains;
    }
    public boolean istrainexist(String route) {

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM  train_schedule where route= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, route);
            ResultSet rs = stmt.executeQuery();
            boolean result = rs.next();
            rs.close();
            stmt.close();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }
    public Passenger getpassengerdata(String username, String password) {

        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM passenger WHERE name = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String phonenumber = resultSet.getString("phone_number");
                Passenger passenger=new Passenger(username,age,email,phonenumber,password);
                return passenger;
            }
            resultSet.close();
            statement.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Train> getAllTrains() {
        ArrayList<Train> trains = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM train_schedule");

            while (resultSet.next()) {
                int trainNumber = Integer.parseInt(resultSet.getString("train_number"));
                String route = resultSet.getString("route");
                String departureTime = resultSet.getString("departuretime");
                String arrivingTime = resultSet.getString("arriving_time");
                double cost = resultSet.getDouble("cost");

                Train train = new Train(trainNumber, route, departureTime, arrivingTime, cost);
                trains.add(train);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trains;
    }


    public boolean available_seats(int train_number,int coach_number,int seat_number,String day) throws SQLException {



        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        try{
        String sql = "SELECT * FROM booked_seats WHERE train_number= ? AND coach_number= ? AND seat_number= ? AND day= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, train_number);
        stmt.setInt(2, coach_number);
        stmt.setInt(3, seat_number);
        stmt.setString(4,day);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
           Boolean isavailable = rs.getBoolean("is_booked");
            return isavailable;

        }
        rs.close();
       stmt.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
            if(conn!=null)
                conn.close();
        }

        return false ;
    }

    public void bookseat(int train_number, int coach_number, int seat_number, String day) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "INSERT INTO booked_seats (train_number, coach_number, seat_number, day, is_booked) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, train_number);
            stmt.setInt(2, coach_number);
            stmt.setInt(3, seat_number);
            stmt.setString(4, day);
            stmt.setBoolean(5, true);

            stmt.executeUpdate();


            stmt.close();
        }
       catch(SQLException e){
                e.printStackTrace();
            }
        }

       public boolean isemailexist(String email)
        {
            try {

                    Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM passenger WHERE email = ?");
                    ps.setString(1, email);
                    ResultSet rs = ps.executeQuery();
                    boolean emailExists = rs.next();
                    rs.close();
                    ps.close();
                     conn.close();

            return emailExists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



        }

    public boolean setPassword(String email, String newPassword) {
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conn.prepareStatement("UPDATE passenger SET password = ? WHERE email = ?");
            ps.setString(1, newPassword);
            ps.setString(2, email);
            int rowsUpdated = ps.executeUpdate();
            ps.close();
            conn.close();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    }

