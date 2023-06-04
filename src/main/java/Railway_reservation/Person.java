package Railway_reservation;

public class Person {

    String name;
    int age;
    String email;
    String phone_number;

    String password;


   public Person(String name,int age,String email,String phone_number,String password){

        this.age=age;
        this.name=name;
        this.phone_number=phone_number;
        this.email=email;
        this.password=password;
    }

    public Person()
    {

    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
