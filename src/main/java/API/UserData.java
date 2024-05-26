package API;

public class UserData {
    public UserData(String anna, String klo, int i, boolean b, String date, String date1) {
    }

    public class Bookingdates{
        public String checkin;
        public String checkout;
    }

    public class Root {
        public String firstname;
        public String lastname;
        public int totalprice;
        public boolean depositpaid;
        public Bookingdates bookingdates;
        public String additionalneeds;

        public int getBookingid() {
            return bookingid;
        }

        public int bookingid;

        public Root(String firstname, String lastname, int totalprice, boolean depositpaid, Bookingdates bookingdates, String additionalneeds) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.totalprice = totalprice;
            this.depositpaid = depositpaid;
            this.bookingdates = bookingdates;
            this.additionalneeds = additionalneeds;
            this.bookingid = bookingid;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public boolean isDepositpaid() {
            return depositpaid;
        }

        public Bookingdates getBookingdates() {
            return bookingdates;
        }

        public String getAdditionalneeds() {
            return additionalneeds;
        }

    }


}
