package Railway_reservation;

public class Tickets {


        String choosentrain_number;
        String choosen_departuretime;
        int selected_nuofseats;
        int selected_coach_number;
        String ticketcategort;
        int passenger_age;
        double ticket_cost;
        String choosen_route;


        public Tickets(String choosen_departuretime,int selected_nuofseats, int selected_coach_number,String ticketcategort,
                     int passenger_age,double ticket_cost,String choosen_route ) {
            this.choosen_departuretime = choosen_departuretime;
            this.selected_nuofseats=selected_nuofseats;
            this.selected_coach_number=selected_coach_number;
            this.ticketcategort=ticketcategort;
            this.passenger_age=passenger_age;
            this.ticket_cost=ticket_cost;
            this.choosen_route=choosen_route;
        }

        public Tickets()
        {


        }

        public String getChoosen_departuretime() {
            return choosen_departuretime;
        }

        public void setChoosen_departuretime(String choosen_departuretime) {
            this.choosen_departuretime = choosen_departuretime;
        }

        public String getChoosen_route() {
            return choosen_route;
        }

        public void setChoosen_route(String choosen_route) {
            this.choosen_route = choosen_route;
        }

        public String getChoosentrain_number() {
            return choosentrain_number;
        }

        public void setChoosentrain_number(String choosentrain_number) {
            this.choosentrain_number = choosentrain_number;
        }

        public int getPassenger_age() {
            return passenger_age;
        }

        public void setPassenger_age(int passenger_age) {
            this.passenger_age = passenger_age;
        }



        public int getSelected_coach_number() {
            return selected_coach_number;
        }

        public void setSelected_coach_number(int selected_coach_number) {
            this.selected_coach_number = selected_coach_number;
        }

        public int getSelected_seatpreference() {
            return selected_nuofseats;
        }

        public void setSelected_seatpreference(int selected_seatpreference) {
            this.selected_nuofseats = selected_seatpreference;
        }

        public double getTicket_cost() {
            return ticket_cost;
        }

        public void setTicket_cost(double ticket_cost) {
            this.ticket_cost = ticket_cost;
        }

        public void setTicket_cost(double ticket_cost,double discount){
            double amount=discount*ticket_cost;
          this.ticket_cost=ticket_cost-amount;

    }

        public String getTicketcategort() {
            return ticketcategort;
        }

        public void setTicketcategort(String ticketcategort) {
            this.ticketcategort = ticketcategort;
        }



public String toString(){
            return null;
}


}





