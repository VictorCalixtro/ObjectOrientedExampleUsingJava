import java.io.Serializable;

/**
 *
 * Item is a class containing its own setter and getter functions
 * It is also serializable
 *
 *
 *
 */


public class Item implements Serializable {

    protected String ID, Name, Category;
    protected int Quantity;
    protected double Price;
    //protected String stringQ, stringP;

    public Item(String ID, String Name, String Category ,int Quantity ,double Price){ //constructor with variables
        this.ID = ID;
        this. Name = Name;
        this.Category = Category;
        this. Quantity = Quantity;
        this.Price = Price;
    }



    public Item(){} // empty constructor

    public void setName(String n)
    {
        Name = n;
    }

    public void setId(String i)
    {
        ID = i;
    }

    public void setQuantity(String q)
    {
        Quantity = Integer.parseInt(q); // converts string to int
    }

    public void setPrice(String p)
    {
        Price = Double.parseDouble(p); // converts string to double
    }
    public void setCategory(String c)
    {
        Category = c;
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return Name;
    }

    public String getCategory()
    {
        return Category;
    }

    public Integer getQuantity()
    {
        return Quantity;
    }
    public double getPrice()
    {
        return Price;
    }





}
