import java.io.Serializable;

/**
 * A class holding all the data nessesary to make a sales transaaction
 *
 */

public class SaleTransaction implements Serializable {

    private String itemId;
    private String saleDate;

    private int saleQuantity;
    private int customerId;
    private int employeeIdWhoCompletedTheSale;

public void setCustomerId(int customerId)
{
    this.customerId = customerId;
}

public void setEmployeeIdWhoCompletedTheSale(int employeeIdWhoCompletedTheSale)
{
    this.employeeIdWhoCompletedTheSale = employeeIdWhoCompletedTheSale;
}

public void setItemId(String itemId)
{
    this.itemId = itemId;
}

public void setSaleQuantity(int saleQuantity)
{
    this.saleQuantity =saleQuantity;
}
public void setSaleDate(String saleDate)
{
    this.saleDate = saleDate;
}

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeIdWhoCompletedTheSale() {
        return employeeIdWhoCompletedTheSale;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getSaleDate() {
        return saleDate;
    }

}
