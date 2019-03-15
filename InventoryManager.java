import java.io.Serializable;
import java.util.LinkedList;

/**
 * Inventory manager holds linked lists containing appliances and small category(hardware) objects.
 * The class is also serializable
 *
 *
 */



public class InventoryManager implements Serializable {

    LinkedList<Item> myArrayList = new LinkedList<>();
    LinkedList<Appliances> appliancesLinkedList = new LinkedList<>();
    LinkedList<smallCategoryItems> smallCategoryItemsLinkedList = new LinkedList<>();

    public InventoryManager() {}


}
