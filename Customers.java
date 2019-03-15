/**
 * Customers is a subclass of the users class
 *
 * it has its own setter and getter functions.
 *
 *
 *
 *
 */




public class Customers extends Users {

    private String phoneNumber;
    private String address;

    public void setPhoneNumber(String pn){
        phoneNumber = pn;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getAddress(){
        return this.address;
    }

}
