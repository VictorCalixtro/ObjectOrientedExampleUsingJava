/**
 *Appliances is a child class of the item class
 * Has setter and getter functions that set and return variables
 *
 *
 */


public class Appliances extends Item {

    private String brand;
    private String type;

    public void setBrand(String b)
    {
        brand = b;
    }

    public void setType(int choice){ // remember to have input validation to make sure choice is between 1-4

        if(choice == 1)
        {
            type = "Refrigerators";
        }
        else if(choice ==2)
        {
            type = "Washers&Dryers";
        }
        else if(choice == 3)
        {
            type = "Ranges&Ovens";
        }
        else
        {
            type = "Small Appliences";
        }







    }


    public String getBrand()
    {
        return brand;
    }
    public String getType(){
        return type;
    }



}
