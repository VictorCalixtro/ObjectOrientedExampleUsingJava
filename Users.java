import java.io.Serializable;

/**
 * A class with the basic data nessesary to make a user object.
 *
 */

public class Users implements Serializable {

    protected int personId;
    protected String firstName;
    protected String lastName;

    public void setPersonId(int pid){
        personId = pid;
    }

    public void setFirstName(String fn){
        firstName = fn;
    }

    public void setLastName(String ln){
        lastName =ln;
    }

    public int getPersonId(){
        return personId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

}

