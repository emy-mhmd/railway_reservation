package Railway_reservation;

public class Paymentservice implements Payment {

    private boolean paymentStatus=false;
    public boolean makePaymentforticket() {
        return paymentStatus=true;
    }

    public boolean checkPaymentStatus(){
        return paymentStatus;}


}

