import java.util.ArrayList;

public class InventoryManager {

    ArrayList<Item> myArrayList = new ArrayList<>();
    int arrayListSize = 0;

    public InventoryManager() {}


    public  InventoryManager(readFile r) {
        for (int i = 0; i < r.myArray.size(); i++) {
            //System.out.println(r.myArray.get(i));

            String[] splitted = r.myArray.get(i).split("~");
            String ID = splitted[0].trim();
            String Name = splitted[1].trim();
            String Category = splitted[2].trim();
            String stringQ = splitted[3].trim();
            String stringP = splitted[4].trim();

            Item item = new Item();
            item.setId(ID);
            item.setName(Name);
            item.setCategory(Category);
            item.setQuantity(stringQ);
            item.setPrice(stringP);

            if(i == r.myArray.size() - 1)
            {arrayListSize = i;}

            myArrayList.add(item);



        }


    }
    public int getArrayListSize()
    {
        return arrayListSize;
    }


}
