import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OverrideFile {


    public  OverrideFile(InventoryManager inventoryManager, int arrayListSize)
    {

        //String addingTheVariables = "";
        ArrayList<String> addingTheVariables = new ArrayList<>();

        for(int i =0; i<= arrayListSize; i++)
        {
            // save all the variables in the correct order into a string then push that tring into a line on the file

            addingTheVariables.add( inventoryManager.myArrayList.get(i).getID() + "~" +
                    inventoryManager.myArrayList.get(i).getName() +"~" +inventoryManager.myArrayList.get(i).getCategory() + "~"
                    +  inventoryManager.myArrayList.get(i).getQuantity() + "~" + inventoryManager.myArrayList.get(i).getPrice());

        }


        //System.out.println(addingTheVariables); // now get the records into the file
        try{

            File file = new File("src/Database.txt");

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i <= arrayListSize;i++)
            {
            bw.write(addingTheVariables.get(i));
            bw.newLine();
            }
            bw.close();

            System.out.println("Done");
        }catch(IOException e){
            e.printStackTrace();
        }

    }







}
