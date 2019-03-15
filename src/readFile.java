import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class readFile {

    public Scanner x;
    public void openFile(){

        try{
            x = new Scanner(new File("src/Database.txt"));
        }
        catch (Exception e){
            System.out.println("Error:File Not Found.");
        }

    }

    static ArrayList<String> myArray = new ArrayList<String>();
    public void readFile()
    {

        //int num = 0;
        while(x.hasNext())
        {
            myArray.add(x.nextLine());

        }
    }
    public void closeFile(){
        x.close();
    }
}
