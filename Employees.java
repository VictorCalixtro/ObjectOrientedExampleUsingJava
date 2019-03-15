/**
 *
 * Employees is a subclass of the users class
 * it has its own setter and getter functions
 *
 *
 *
 *
 *
 */



public class Employees extends Users{

    private int socialSecurityNumber;
    private float monthlySalary;

    public void setSocialSecurityNumber(int ssn)
    {
        socialSecurityNumber = ssn;
    }

    public void setMonthlySalary(float ms){

        monthlySalary = ms;


    }

    public int getSocialSecurityNumber(){
        return socialSecurityNumber;
    }

    public float getMonthlySalary(){
        return monthlySalary;
    }


}
