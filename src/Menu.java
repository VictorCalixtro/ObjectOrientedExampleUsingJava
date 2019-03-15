//import java.util.Scanner;


import java.util.Scanner;

public class Menu {

    Scanner keyboardInput = new Scanner(System.in);
    int choice = -1;
    InventoryManager inventoryManager = new InventoryManager();
    int arrayListSize = 0;


    public void setList(InventoryManager inventoryManager, int arrayListSize) {
        this.inventoryManager = inventoryManager; // might need for loop

        this.arrayListSize = arrayListSize;


    }


    public void displayMenu() {
        do {
            System.out.println("1.Show all existing items in stock and their quantities.\n" +
                    "2.Add a new quantity of a specific item to the stock.\n" +
                    "3.Remove a certain quantity of a specific item type.\n" +
                    "4.Search for an item(given its name or part of its name\n" +
                    "5.Show a list of all items below a certain quantity,\n" +
                    "6.Exit program.)");

            System.out.print("Enter Choice: ");
            choice = keyboardInput.nextInt();
            while (choice > 6 || choice < 1) // Input Validation
            {
                System.out.println("Invalid Input; Try again.");
                System.out.print("Enter Choice: ");
                choice = keyboardInput.nextInt();
            }

            switch (choice) {
                case 1:
                    choiceOne();
                    break;
                case 2:
                    choiceTwo();
                    break;
                case 3:choiceThree();
                    break;
                case 4: choiceFour();
                    break;
                case 5: choiceFive();
                   break;
                default:
                    break;

            }
        } while (choice != 6);
    }


    public void choiceOne() {
        for (int i = 0; i <= arrayListSize; i++) {
            if (i == 0) {
                System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "Name", "Category",
                        "Quantity", "Price");
            }

            System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n", inventoryManager.myArrayList.get(i).getID(),
                    inventoryManager.myArrayList.get(i).getName(), inventoryManager.myArrayList.get(i).getCategory(),
                    inventoryManager.myArrayList.get(i).getQuantity(), inventoryManager.myArrayList.get(i).getPrice()
            );

        }
    }


    public void choiceTwo() {


        System.out.print("Enter a five character id: ");
        Scanner keyboardInput2 = new Scanner(System.in);
        String IdSearch2 = keyboardInput2.nextLine();


        while(IdSearch2.length()<5){ // Input Validation

            System.out.println("Error, That was less than 5 characters.");
           System.out.print("Enter a five character id: ");
           Scanner keyboardInput982 = new Scanner(System.in);
            IdSearch2 = keyboardInput982.nextLine();

       }
        String IdSearch = IdSearch2.substring(0, 5);
        System.out.println("I will now search the list if the id\n" +
                "is already on the list I wont do anything\n" +
                "otherwise i will add an item to the list.");

        for (int i = 0; i <= arrayListSize; i++) {



            if (i == arrayListSize) {
                if (IdSearch.equalsIgnoreCase(inventoryManager.myArrayList.get(i).getID()))
                    //If id is not in the file we will create one with the
                //logic in the else statement
                {
                } else {

                    System.out.println("ID not on list.\nCreating new record.");

                    Item item = new Item();
                    item.setId(IdSearch);

                    String Name, Category = "";
                    int stringQ;
                    double stringP = 0;
                    System.out.println("Enter the name:");
                    Scanner keyboardInput3 = new Scanner(System.in);
                    Name = keyboardInput3.nextLine();
                    item.setName(Name);




                    //The Category of the item can be only one of the following: “Door&Window”,
                    //“Cabinet& Furniture”, “Fasteners”, “Structural”, “Other”.


                    int choise2 = -1;
                    do {
                        System.out.println("Chose the type of Category.\n" +
                                "1.Door&Window\n" +
                                "2.Cabinet& Furniture\n" +
                                "3.Fasteners\n" +
                                "4.Structural\n" +
                                "5.Other");
                        Scanner keyboardInput11 = new Scanner(System.in);
                        choise2 = keyboardInput11.nextInt();
                        if(choise2 > 5 || choise2 < -1)
                        {
                            System.out.println("Invalid entry, try again.");
                        }
                    }while(choise2 > 5 || choise2 < 1);

                    if(choise2 == 1)
                    {
                        Category = "Door&Window";
                    }
                    if(choise2 == 2)
                    {
                        Category = "Cabinet& Furniture";
                    }
                    if(choise2 == 3)
                    {
                        Category = "Fasteners";
                    }
                    if(choise2 == 4)
                    {
                        Category = "Structural";
                    }
                    if(choise2 == 5)
                    {
                        Category = "Other";
                    }

                    item.setCategory(Category);



                    System.out.println("Enter the Quantity(int):");
                    Scanner keyboardInput15 = new Scanner(System.in);
                    stringQ = keyboardInput15.nextInt();
                    String numberAsString = Integer.toString(stringQ);
                    item.setQuantity(numberAsString);


                    System.out.println("Enter the Price(double):");
                    Scanner keyboardInput145 = new Scanner(System.in);
                    stringP = keyboardInput145.nextDouble();
                    String numberAsString1 = String.valueOf(stringP);
                    item.setPrice(numberAsString1);


                   inventoryManager. myArrayList.add(item);
                   this.arrayListSize +=1;


                }
            }

        }
    }

    public void choiceThree() {


        System.out.print("Enter a five character id: ");
        Scanner keyboardInput2 = new Scanner(System.in);
        String IdSearch = keyboardInput2.nextLine();

        Boolean found = false;

        for (int i = 0; i <= arrayListSize; i++) {


            if (IdSearch.equalsIgnoreCase(inventoryManager.myArrayList.get(i).getID())) {

                System.out.print("Enter the amount to reduce: ");
                Scanner keyboardInput200 = new Scanner(System.in);
                int amountToReduce = keyboardInput200.nextInt();




                if(inventoryManager.myArrayList.get(i).getQuantity() >= amountToReduce) {

                   int p =  inventoryManager.myArrayList.get(i).getQuantity() - amountToReduce;



                    String numberAsString = Integer.toString(p);
                    inventoryManager.myArrayList.get(i).setQuantity(numberAsString);
                    found = true;



                    }else
                {
                    System.out.println("Error, Can Not have a negative quantity.");
                    found = true;
                }
                }


            }

            if(found == false)
            {
                System.out.println("That id does not exist.");
            }
        }

   public void choiceFour()
   {

       String getItemName;

       Scanner keyboardInput2 = new Scanner(System.in);
       System.out.println("Enter the name or part of the name of \n" +
               "an item and if the item(s) exist I will print them.");
        getItemName = keyboardInput2.nextLine();


        for(int i = 0; i <= arrayListSize; i++)
        {

            if(inventoryManager.myArrayList.get(i).getName().contains(getItemName))
            {
                System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "Name", "Category",
                        "Quantity", "Price");



                System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n", inventoryManager.myArrayList.get(i).getID(),
                        inventoryManager.myArrayList.get(i).getName(), inventoryManager.myArrayList.get(i).getCategory(),
                        inventoryManager.myArrayList.get(i).getQuantity(), inventoryManager.myArrayList.get(i).getPrice());



            }




        }


   }

   public void choiceFive()
   {
       int getQuant = 0;

       do {
           System.out.println("Enter the Quantity: ");
           Scanner keyboardInput2 = new Scanner(System.in);
           getQuant = keyboardInput2.nextInt();
           if(getQuant <0)
           {
               System.out.println("Quantity cannot be negative, try again.");
           }
       }while(getQuant < 0);

       System.out.println("Will print  all quantities at or below " + getQuant);

       for (int i = 0; i <= arrayListSize; i++) {


           if( getQuant >= inventoryManager.myArrayList.get(i).getQuantity())
           {

               System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "Name", "Category",
                       "Quantity", "Price");



               System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n", inventoryManager.myArrayList.get(i).getID(),
                       inventoryManager.myArrayList.get(i).getName(), inventoryManager.myArrayList.get(i).getCategory(),
                       inventoryManager.myArrayList.get(i).getQuantity(), inventoryManager.myArrayList.get(i).getPrice());

           }









       }


   }

   public InventoryManager getInventoryManager()
   {
       return inventoryManager;
   }

   public int getArrayListSize()
   {
       return arrayListSize;
   }





    }


























