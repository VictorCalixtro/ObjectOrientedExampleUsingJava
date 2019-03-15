import java.io.*;

import java.util.Scanner;


/**
 * This class is the heart of the program and contains all the functions nessesary in order
 * for the program to function.
 *
 *
 */

public class Menu {

    Scanner keyboardInput = new Scanner(System.in);
    int choice = -1;
    UserManager customerUser = new UserManager();
    UserManager employeesUser = new UserManager();
    InventoryManager applienceManager = new InventoryManager();
    InventoryManager HardwareItemManager = new InventoryManager();
    SaleTransactionInventoryManager salesManager = new SaleTransactionInventoryManager();


    /**
     * Displays The menu
     */
    public void displayMenu() {

        deserializationCustomer();
        deserializationEmployee();
        deserializationAppliances();
        deserializationHardware();
        deserializationSalesTransactions();

        do {
            int inputVal = 1;
            do{

                try {

                    System.out.println(

                            "1.Show all existing items records in the database (sorted by ID number).\n" +
                                    "2.Add new item (or quantity) to the database.\n" +
                                    "3.Delete an item from a database.\n" +
                                    "4.Search for an item(given its name or part of its name.\n" +
                                    "5.Show a list of users in the database.\n" +
                                    "6.Add new user to the database.\n" +
                                    "7.Update user info (given their id).\n" +
                                    "8.Complete a sale transaction.\n" +
                                    "9.Show completed sale transactions.\n" +
                                    "10.Exit program.");

                    System.out.print("Enter Choice: ");
                    choice = keyboardInput.nextInt();

                    while (choice > 10 || choice < 1) // Input Validation
                    {

                        System.out.println("Invalid Input; choice must be from 1-10");
                        System.out.print("Enter Choice: ");
                        choice = keyboardInput.nextInt();

                    }

                    inputVal =2;
                }catch (Exception e){
                    System.out.println("Error, Invalid input choice.\n" +
                            "Not a digit.");
                    keyboardInput.nextLine();

                }



            }while (inputVal !=2);

            switch (choice) {
                case 1:
                    choiceOne();
                    break;
                case 2:
                    choiceTwo();
                    break;
                case 3:
                    choiceThree();
                    break;
                case 4:
                    choiceFour();
                    break;
                case 5:
                    choiceFive();
                    break;
                case 6:
                    choiceSix();
                    break;
                case 7:
                    choiceSeven();
                    break;
                case 8:
                    choiceEight();
                    break;
                case 9:
                    choiceNine();
                    break;
                case 10:
                    serializableCustomer();
                    serializableEmployee();
                    serializableAppliances();
                    serializableHardware();
                    serializablleSalesTransactions();
                    break;
                default:
                    break;

            }
        } while (choice != 10);
    }

    /**
     *
     * Adds a new user to the database
     *
     */
    private void choiceSix() {

        //6.Add new user to the database.


        int choice = -1;

        System.out.println("What type of user are you trying to add to the database?\n" +
                "1. Customer\n" +
                "2. Employee");


        System.out.print("Enter Choice: ");
        choice = keyboardInput.nextInt();
        while (choice > 2 || choice < 1) // Input Validation
        {
            System.out.println("Invalid Input; Try again.");
            System.out.print("Enter Choice: ");
            choice = keyboardInput.nextInt();
        }

        if (choice == 1) {

            int personId;
            String firstName;
            String lastName;
            String phoneNumber;
            String address;

            System.out.print("Enter a five character id: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            String IdSearch2 = keyboardInput2.nextLine();


            while (IdSearch2.length() < 5) { // Input Validation

                System.out.println("Error, That was less than 5 characters.");
                System.out.print("Enter a five character id: ");
                Scanner keyboardInput982 = new Scanner(System.in);
                IdSearch2 = keyboardInput982.nextLine();

            }
            String IdSearch = IdSearch2.substring(0, 5);
            personId = Integer.valueOf(IdSearch);

            System.out.println("Enter the first name:");
            Scanner keyboardInput30 = new Scanner(System.in);
            firstName = keyboardInput30.nextLine();

            System.out.println("Enter the last name:");
            Scanner keyboardInput300 = new Scanner(System.in);
            lastName = keyboardInput300.nextLine();

            System.out.println("Enter the phone number:");
            Scanner keyboardInput360 = new Scanner(System.in);
            phoneNumber = keyboardInput360.nextLine();

            System.out.println("Enter the address:");
            Scanner keyboardInput3980 = new Scanner(System.in);
            address = keyboardInput3980.nextLine();


            Customers customer = new Customers();

            customer.setPersonId(personId);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customer.setPhoneNumber(phoneNumber);

            customerUser.CustomerLinkedList.add(customer);

        }

        if (choice == 2) {

            int personId;
            String firstName;
            String lastName;
            float monthlySalary;
            int socialSecurity;


            System.out.print("Enter a five character id: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            String IdSearch2 = keyboardInput2.nextLine();


            while (IdSearch2.length() < 5) { // Input Validation

                System.out.println("Error, That was less than 5 characters.");
                System.out.print("Enter a five character id: ");
                Scanner keyboardInput982 = new Scanner(System.in);
                IdSearch2 = keyboardInput982.nextLine();

            }
            String IdSearch = IdSearch2.substring(0, 5);
            personId = Integer.valueOf(IdSearch);

            System.out.println("Enter the first name:");
            Scanner keyboardInput30 = new Scanner(System.in);
            firstName = keyboardInput30.nextLine();

            System.out.println("Enter the last name:");
            Scanner keyboardInput300 = new Scanner(System.in);
            lastName = keyboardInput300.nextLine();

            System.out.println("Enter the Monthly Salary:");
            Scanner keyboardInput360 = new Scanner(System.in);
            monthlySalary = keyboardInput360.nextFloat();

            System.out.println("Social Security:");
            Scanner keyboardInput3980 = new Scanner(System.in);
            socialSecurity = keyboardInput3980.nextInt();


            Employees employees = new Employees();

            employees.setPersonId(personId);
            employees.setFirstName(firstName);
            employees.setLastName(lastName);
            employees.setSocialSecurityNumber(socialSecurity);
            employees.setMonthlySalary(monthlySalary);

            employeesUser.EmployeeLinkedList.add(employees);


        }


    }

    /**
     *
     * Shows all of the existing items in the database
     */
    private void choiceOne() {
        for (int i = 0; i < applienceManager.appliancesLinkedList.size(); i++) {
            if (i == 0) {
                System.out.println("****************Applience Items****************************");
                System.out.printf("| %10s | %20s | %20s | %10s | %12s |  %13s |       \n", "ID", "Name",
                        "Quantity", "Price", "Brand", "Type");
            }

            System.out.printf("| %10s | %20s | %20s | %10s | %12s | %13s |\n", applienceManager.appliancesLinkedList.get(i).getID(),
                    applienceManager.appliancesLinkedList.get(i).getName(), applienceManager.appliancesLinkedList.get(i).getQuantity(),
                    applienceManager.appliancesLinkedList.get(i).getPrice(), applienceManager.appliancesLinkedList.get(i).getBrand(),
                    applienceManager.appliancesLinkedList.get(i).getType()
            );

        }


        for (int i = 0; i < HardwareItemManager.smallCategoryItemsLinkedList.size(); i++) {
            if (i == 0) {
                System.out.println("****************Hardware Items****************************");
                System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "Name", "Category",
                        "Quantity", "Price");
            }

            System.out.printf("| %10s | %20s | %20s | %10d | %12.2f |\n", HardwareItemManager.smallCategoryItemsLinkedList.get(i).getID(),
                    HardwareItemManager.smallCategoryItemsLinkedList.get(i).getName(),
                    HardwareItemManager.smallCategoryItemsLinkedList.get(i).getCategory(),
                    HardwareItemManager.smallCategoryItemsLinkedList.get(i).getQuantity(),
                    HardwareItemManager.smallCategoryItemsLinkedList.get(i).getPrice()
            );

        }


    }

    /**
     * Adds a new item to the database or adds to the quantity variable of one of the items
     *
     */

    private void choiceTwo() {

        int choice = -1;

        int inputValidation =1;

        do{
        try{

        do {
            System.out.println("Enter 1 to add a new item.\n" +
                    "Enter 2 to add a quantity.");
            Scanner keyboardInput2 = new Scanner(System.in);
            choice = keyboardInput2.nextInt();

            if (choice > 2 || choice < 1) {
                System.out.println("Error: Invalid Input; Choice must either be 1 or 2\n" +
                        "Try again. ");
            }


        } while (choice != 1 && choice != 2);


        if (choice == 1) {

            int choice2 = -1;


            do {
                System.out.println("What type of item are we adding to the database?\n" +
                        "1.Appliances\n" +
                        "2.Small Hardware Items"); // typo named it category

                Scanner keyboardInput222 = new Scanner(System.in);
                choice2 = keyboardInput222.nextInt();

                if (choice2 > 2 || choice2 < 1) {
                    System.out.println("Error: Invalid Input; Choice must either be 1 or 2\n" +
                            "Try again. ");
                }


            } while (choice2 != 1 && choice2 != 2);

            if (choice2 == 1) {

                //add appliences item

                Appliances appliances = new Appliances();

                String b = " ";


                System.out.println("Enter the Brand:");
                Scanner keyboardInput3 = new Scanner(System.in);
                b = keyboardInput3.nextLine();
                ((Appliances) appliances).setBrand(b);


                int t = -1;

                System.out.println("1.Refrigerators\n" +
                        "2.Washers&Dryers\n" +
                        "3.Ranges&Ovens\n" +
                        "4.Small Appliences");


                while (t > 4 || t < 1) {
                    System.out.println("Enter the Type:");
                    Scanner keyboardInput364 = new Scanner(System.in);
                    t = keyboardInput364.nextInt();

                    if (t > 4 || t < 1) {
                        System.out.println("Error: Invalid Input; Choice must either be 1 or 4\n" +
                                "Try again. ");
                    }

                }

                ((Appliances) appliances).setType(t);


                System.out.println("Enter the Quantity(int):");
                Scanner keyboardInput15 = new Scanner(System.in);
                int stringQ = keyboardInput15.nextInt();
                String numberAsString = Integer.toString(stringQ);
                appliances.setQuantity(numberAsString);


                System.out.println("Enter the Price(double):");
                Scanner keyboardInput145 = new Scanner(System.in);
                double stringP = keyboardInput145.nextDouble();
                String numberAsString1 = String.valueOf(stringP);
                appliances.setPrice(numberAsString1);

                System.out.println("Enter the name:");
                Scanner keyboardInput39 = new Scanner(System.in);
                String Name = keyboardInput39.nextLine();
                appliances.setName(Name);


                System.out.print("Enter a five character id: ");
                Scanner keyboardInput2 = new Scanner(System.in);
                String IdSearch2 = keyboardInput2.nextLine();


                while (IdSearch2.length() < 5) { // Input Validation

                    System.out.println("Error, That was less than 5 characters.");
                    System.out.print("Enter a five character id: ");
                    Scanner keyboardInput982 = new Scanner(System.in);
                    IdSearch2 = keyboardInput982.nextLine();

                }
                String IdSearch = IdSearch2.substring(0, 5);
                appliances.setId(IdSearch);


                applienceManager.appliancesLinkedList.add(appliances);


            } else {

                // add hardware item

                smallCategoryItems hardware = new smallCategoryItems();


                String Category = " ";


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
                    if (choise2 > 5 || choise2 < -1) {
                        System.out.println("Invalid entry, try again.");
                    }
                } while (choise2 > 5 || choise2 < 1);

                if (choise2 == 1) {
                    Category = "Door&Window";
                }
                if (choise2 == 2) {
                    Category = "Cabinet& Furniture";
                }
                if (choise2 == 3) {
                    Category = "Fasteners";
                }
                if (choise2 == 4) {
                    Category = "Structural";
                }
                if (choise2 == 5) {
                    Category = "Other";
                }
                hardware.setCategory(Category);


                System.out.println("Enter the Quantity(int):");
                Scanner keyboardInput15 = new Scanner(System.in);
                int stringQ = keyboardInput15.nextInt();
                String numberAsString = Integer.toString(stringQ);
                hardware.setQuantity(numberAsString);


                System.out.println("Enter the Price(double):");
                Scanner keyboardInput145 = new Scanner(System.in);
                double stringP = keyboardInput145.nextDouble();
                String numberAsString1 = String.valueOf(stringP);
                hardware.setPrice(numberAsString1);

                System.out.println("Enter the name:");
                Scanner keyboardInput39 = new Scanner(System.in);
                String Name = keyboardInput39.nextLine();
                hardware.setName(Name);

                System.out.print("Enter a five character id: ");
                Scanner keyboardInput2 = new Scanner(System.in);
                String IdSearch2 = keyboardInput2.nextLine();


                while (IdSearch2.length() < 5) { // Input Validation

                    System.out.println("Error, That was less than 5 characters.");
                    System.out.print("Enter a five character id: ");
                    Scanner keyboardInput982 = new Scanner(System.in);
                    IdSearch2 = keyboardInput982.nextLine();

                }
                String IdSearch = IdSearch2.substring(0, 5);
                hardware.setId(IdSearch);

                HardwareItemManager.smallCategoryItemsLinkedList.add(hardware);

            }


        } else {


            System.out.println("What type of item is the quantity you are trying to update?\n" +
                    "1.Appliance\n" +
                    "2.Hardware");

            int choiceOfTheCentury = -1;

            do {

                Scanner keyboardInput222 = new Scanner(System.in);
                choiceOfTheCentury = keyboardInput222.nextInt();

                if (choiceOfTheCentury > 2 || choiceOfTheCentury < 1) {
                    System.out.println("Error: Invalid Input; Choice must either be 1 or 2\n" +
                            "Try again. ");
                }


            } while (choiceOfTheCentury != 1 && choiceOfTheCentury != 2);

            if (choiceOfTheCentury == 1) {
                //Search appliances

                System.out.print("Enter a five character id: ");
                Scanner keyboardInput2 = new Scanner(System.in);
                String IdSearch2 = keyboardInput2.nextLine();


                while (IdSearch2.length() < 5) { // Input Validation

                    System.out.println("Error, That was less than 5 characters.");
                    System.out.print("Enter a five character id: ");
                    Scanner keyboardInput982 = new Scanner(System.in);
                    IdSearch2 = keyboardInput982.nextLine();

                }
                String IdSearch = IdSearch2.substring(0, 5);
                System.out.println("I will now search the list if the id exists\n" +
                        "I will add a quantity to the item.");
                Boolean isOnList = false;

                for (int i = 0; i < applienceManager.appliancesLinkedList.size(); i++) {


                    if (IdSearch.equalsIgnoreCase(applienceManager.appliancesLinkedList.get(i).getID())) {

                        System.out.println("Enter the Quantity to add");

                        Scanner keyboardInput982 = new Scanner(System.in);
                        int crazyNum = keyboardInput982.nextInt();

                        int number9 = applienceManager.appliancesLinkedList.get(i).getQuantity();

                        number9 += crazyNum;
                        String holder = Integer.toString(number9);
                        applienceManager.appliancesLinkedList.get(i).setQuantity(holder);
                        isOnList = true;
                    }
                }

                if (isOnList == false) {
                    System.out.println("Error,That Id Does Not Exist.");
                }


            }


            if (choiceOfTheCentury == 2) {
                //Search hardware

                System.out.print("Enter a five character id: ");
                Scanner keyboardInput2 = new Scanner(System.in);
                String IdSearch2 = keyboardInput2.nextLine();


                while (IdSearch2.length() < 5) { // Input Validation

                    System.out.println("Error, That was less than 5 characters.");
                    System.out.print("Enter a five character id: ");
                    Scanner keyboardInput982 = new Scanner(System.in);
                    IdSearch2 = keyboardInput982.nextLine();

                }
                String IdSearch = IdSearch2.substring(0, 5);
                System.out.println("I will now search the list if the id exists\n" +
                        "I will add a quantity to the item.");
                Boolean isOnList = false;

                for (int i = 0; i < HardwareItemManager.smallCategoryItemsLinkedList.size(); i++) {


                    if (IdSearch.equalsIgnoreCase(HardwareItemManager.smallCategoryItemsLinkedList.get(i).getID())) {

                        System.out.println("Enter the Quantity to add");

                        Scanner keyboardInput982 = new Scanner(System.in);
                        int crazyNum = keyboardInput982.nextInt();

                        int number9 = HardwareItemManager.smallCategoryItemsLinkedList.get(i).getQuantity();

                        number9 += crazyNum;
                        String holder = Integer.toString(number9);
                        HardwareItemManager.smallCategoryItemsLinkedList.get(i).setQuantity(holder);
                        isOnList = true;
                    }
                }

                if (isOnList == false) {
                    System.out.println("Error,That Id Does Not Exist.");
                }


            }
        }
        inputValidation =2;
        }catch (Exception e)
        {
            System.out.println("Error, Invalid input choice");
            inputValidation =2;
            System.out.println("Returning to main menu...");
            return;
        }
        }while(inputValidation !=2);
    }

    /**
     *
     * Deletes an item from the database
     *
     *
     */

    private void choiceThree() {


        System.out.println("What type of item are you trying to remove?\n" +
                "1.Appliance Item\n" +
                "2.Hardware Item");

        int choice = -1;

        do {
            System.out.print("Enter Choice: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            choice = keyboardInput2.nextInt();

            if (choice > 2 || choice < 1) {

                System.out.println("Error, invalid input choice, try again.");

            }

        } while (choice > 2 || choice < 1);


        if (choice == 1) {

            System.out.print("Enter a five character id: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            String IdSearch = keyboardInput2.nextLine();

            Boolean found = false;

            for (int i = 0; i < applienceManager.appliancesLinkedList.size(); i++) {


                if (IdSearch.equalsIgnoreCase(applienceManager.appliancesLinkedList.get(i).getID())) {

                    applienceManager.appliancesLinkedList.remove(i);

                    found = true;

                }

            }

            if (found == false) {
                System.out.println("That id does not exist.");
            }


        } else {


            System.out.print("Enter a five character id: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            String IdSearch = keyboardInput2.nextLine();

            Boolean found = false;

            for (int i = 0; i < HardwareItemManager.smallCategoryItemsLinkedList.size(); i++) {


                if (IdSearch.equalsIgnoreCase(HardwareItemManager.smallCategoryItemsLinkedList.get(i).getID())) {

                    HardwareItemManager.smallCategoryItemsLinkedList.remove(i);

                    found = true;

                }

            }

            if (found == false) {
                System.out.println("That id does not exist.");
            }

        }


    }


    /**
     *
     * Searches for an item in the database
     *
     */


    private void choiceFour() {

        String getItemName; // note case sensitive

        System.out.println("What type of item are you searching for?\n" +
                "1.Appliance Item\n" +
                "2.Hardware Item");

        int myChoice = -1;

        do {
            System.out.print("Enter Choice: ");
            Scanner keyboardInput29 = new Scanner(System.in);
            myChoice = keyboardInput29.nextInt();

            if (myChoice > 2 || myChoice < 1) {

                System.out.println("Error, invalid input choice, try again.");

            }

        } while (myChoice > 2 || myChoice < 1);


        if (myChoice == 1) {


            Scanner keyboardInput2 = new Scanner(System.in);
            System.out.println("Enter the name or part of the name of \n" +
                    "an item and if the item(s) exist I will print them.");
            getItemName = keyboardInput2.nextLine();


            for (int i = 0; i < applienceManager.appliancesLinkedList.size(); i++) {

                if (applienceManager.appliancesLinkedList.get(i).getName().contains(getItemName)) {
                    System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "Name", "Category",
                            "Quantity", "Price");


                    System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n", applienceManager.appliancesLinkedList.get(i).getID(),
                            applienceManager.appliancesLinkedList.get(i).getName(), applienceManager.appliancesLinkedList.get(i).getCategory(),
                            applienceManager.appliancesLinkedList.get(i).getQuantity(), applienceManager.appliancesLinkedList.get(i).getPrice());


                }

            }
        } else {

            Scanner keyboardInput2 = new Scanner(System.in);
            System.out.println("Enter the name or part of the name of \n" +
                    "an item and if the item(s) exist I will print them.");
            getItemName = keyboardInput2.nextLine();


            for (int i = 0; i < HardwareItemManager.smallCategoryItemsLinkedList.size(); i++) {

                if (HardwareItemManager.smallCategoryItemsLinkedList.get(i).getName().contains(getItemName)) {
                    System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "Name", "Category",
                            "Quantity", "Price");


                    System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n", HardwareItemManager.smallCategoryItemsLinkedList.get(i).getID(),
                            HardwareItemManager.smallCategoryItemsLinkedList.get(i).getName(), HardwareItemManager.smallCategoryItemsLinkedList.get(i).getCategory(),
                            HardwareItemManager.smallCategoryItemsLinkedList.get(i).getQuantity(), HardwareItemManager.smallCategoryItemsLinkedList.get(i).getPrice());


                }

            }


        }

    }

    /**
     *
     * Prints the list of users in the database
     *
     *
     */

    private void choiceFive() {

        //Show a list of users in the database.


        System.out.println("What type of user list are you trying to print?\n" +
                "1.Customers\n" +
                "2.Employees");

        int choice = -1;

        System.out.print("Enter Choice: ");
        choice = keyboardInput.nextInt();


        while (choice != 1 && choice != 2) {

            System.out.println("Invalid Input; Try again.");
            System.out.print("Enter Choice: ");
            choice = keyboardInput.nextInt();

        }

        if (choice == 1) {

            for (int i = 0; i < customerUser.CustomerLinkedList.size(); i++) {


                System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "First Name", "Last Name",
                        "Address", "Phone Number");


                System.out.printf("| %10s | %20s | %20s | %20s | %20s |\n", customerUser.CustomerLinkedList.get(i).getPersonId(),
                        customerUser.CustomerLinkedList.get(i).getFirstName(),
                        customerUser.CustomerLinkedList.get(i).getLastName(),
                        customerUser.CustomerLinkedList.get(i).getAddress(),
                        customerUser.CustomerLinkedList.get(i).getPhoneNumber());

                System.out.println();

            }
        }

        if (choice == 2) {


            for (int i = 0; i < employeesUser.EmployeeLinkedList.size(); i++) {


                System.out.printf("| %10s | %20s | %20s | %10s | %12s |\n", "ID", "First Name", "Last Name",
                        "Social Security", "Monthly Salary");


                System.out.printf("| %10s | %20s | %20s | %10s | %10s |\n", employeesUser.EmployeeLinkedList.get(i).getPersonId(),
                        employeesUser.EmployeeLinkedList.get(i).getFirstName(),
                        employeesUser.EmployeeLinkedList.get(i).getLastName(),
                        employeesUser.EmployeeLinkedList.get(i).getSocialSecurityNumber(),
                        employeesUser.EmployeeLinkedList.get(i).getMonthlySalary());

                System.out.println();

            }


        }

    }

    /**
     * Updates the variables of one of the users given their id exists
     *
     */
    private void choiceSeven() {
        // 7.Update user info (given their id).

        int choice = -1;
        System.out.print("What type of user are you trying to update?\n" +
                "1.Customer\n" +
                "2.Employee");

        Scanner keyboardInput2 = new Scanner(System.in);
        choice = keyboardInput2.nextInt();

        while (choice != 1 && choice != 2) {

            System.out.println("Invalid Input; Try again.");
            System.out.print("Enter Choice: ");
            choice = keyboardInput.nextInt();

        }


        if (choice == 1) {

            System.out.print("Enter a five character id: ");
            Scanner keyboardInput25423 = new Scanner(System.in);
            String IdSearch = keyboardInput25423.nextLine();

            Boolean found = false;

            for (int i = 0; i < customerUser.CustomerLinkedList.size(); i++) {


                if (IdSearch.equalsIgnoreCase(Integer.toString(customerUser.CustomerLinkedList.get(i).getPersonId()))) {

                    found = true;

                    Boolean flag2 = false;
                    do {

                        System.out.println("What would you like to update?\n" +
                                "1.Phone Number\n" +
                                "2.Address\n" +
                                "3.First Name\n" +
                                "4.Last Name\n" +
                                "5.Exit");

                        Scanner keyboardInput254232 = new Scanner(System.in);
                        int escojer = keyboardInput254232.nextInt();

                        while (escojer < 1 && escojer > 5) {

                            System.out.println("Invalid Input; Try again.");
                            System.out.print("Enter Choice: ");
                            escojer = keyboardInput.nextInt();

                        }
                        if (escojer == 5) {
                            flag2 = true;
                        } else if (escojer == 1) {

                            System.out.println("Enter new phone number: ");
                            Scanner keyboardInput987 = new Scanner(System.in);
                            String phoneNumba = keyboardInput987.nextLine();
                            customerUser.CustomerLinkedList.get(i).setPhoneNumber(phoneNumba);
                        } else if (escojer == 2) {

                            System.out.println("Enter new address: ");
                            Scanner keyboardInput9876 = new Scanner(System.in);
                            String add = keyboardInput9876.nextLine();
                            customerUser.CustomerLinkedList.get(i).setAddress(add);
                        } else if (escojer == 3) {

                            System.out.println("Enter new First name: ");
                            Scanner keyboardInput98765 = new Scanner(System.in);
                            String fname = keyboardInput98765.nextLine();
                            customerUser.CustomerLinkedList.get(i).setFirstName(fname);

                        } else if (escojer == 4) {

                            System.out.println("Enter new last name: ");
                            Scanner keyboardInput987654 = new Scanner(System.in);
                            String lname = keyboardInput987654.nextLine();
                            customerUser.CustomerLinkedList.get(i).setLastName(lname);

                        }

                    } while (flag2 == false);

                }


            }

            if (found == false) {
                System.out.println("That id does not exist.");
            }


        } else {


            System.out.print("Enter a five character id: ");
            Scanner keyboardInput25423 = new Scanner(System.in);
            String IdSearch = keyboardInput25423.nextLine();

            Boolean found = false;

            for (int i = 0; i < employeesUser.EmployeeLinkedList.size(); i++) {


                if (IdSearch.equalsIgnoreCase(Integer.toString(employeesUser.EmployeeLinkedList.get(i).getPersonId()))) {

                    found = true;

                    Boolean flag2 = false;
                    do {

                        System.out.println("What would you like to update?\n" +
                                "1.Social Security\n" +
                                "2.Monthly Salary\n" +
                                "3.First Name\n" +
                                "4.Last Name\n" +
                                "5.Exit");

                        Scanner keyboardInput254232 = new Scanner(System.in);
                        int escojer = keyboardInput254232.nextInt();

                        while (escojer < 1 && escojer > 5) {

                            System.out.println("Invalid Input; Try again.");
                            System.out.print("Enter Choice: ");
                            escojer = keyboardInput.nextInt();

                        }
                        if (escojer == 5) {
                            flag2 = true;
                        } else if (escojer == 1) {

                            System.out.println("Enter new Social Security Number: ");
                            Scanner keyboardInput987 = new Scanner(System.in);
                            int ssn = keyboardInput987.nextInt();
                            employeesUser.EmployeeLinkedList.get(i).setSocialSecurityNumber(ssn);
                        } else if (escojer == 2) {

                            System.out.println("Enter new Monthly Salary: ");
                            Scanner keyboardInput9876 = new Scanner(System.in);
                            float ms = keyboardInput9876.nextFloat();
                            employeesUser.EmployeeLinkedList.get(i).setMonthlySalary(ms);
                        } else if (escojer == 3) {

                            System.out.println("Enter new First name: ");
                            Scanner keyboardInput98765 = new Scanner(System.in);
                            String fname = keyboardInput98765.nextLine();
                            employeesUser.EmployeeLinkedList.get(i).setFirstName(fname);

                        } else if (escojer == 4) {

                            System.out.println("Enter new last name: ");
                            Scanner keyboardInput987654 = new Scanner(System.in);
                            String lname = keyboardInput987654.nextLine();
                            employeesUser.EmployeeLinkedList.get(i).setLastName(lname);

                        }

                    } while (flag2 == false);

                }


            }

            if (found == false) {
                System.out.println("That id does not exist.");
            }


        }


    }

    /**
     * Completes a sale transaction
     *
     */

    private void choiceEight() {

        //8.Complete a sale transaction.

        SaleTransaction sales = new SaleTransaction();

        System.out.println("What type of item is being sold?\n" +
                "1.Appliance Item\n" +
                "2.Hardware Item");

        int choice = -1;

        do {
            System.out.print("Enter Choice: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            choice = keyboardInput2.nextInt();

            if (choice > 2 || choice < 1) {

                System.out.println("Error, invalid input choice, try again.");

            }

        } while (choice > 2 || choice < 1);

        if (choice == 1) {

            //Appliance item id

            System.out.print("Enter a five character Item id: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            String IdSearch2 = keyboardInput2.nextLine();


            while (IdSearch2.length() < 5) { // Input Validation

                System.out.println("Error, That was less than 5 characters.");
                System.out.print("Enter a five character Item id: ");
                Scanner keyboardInput982 = new Scanner(System.in);
                IdSearch2 = keyboardInput982.nextLine();

            }
            String IdSearch = IdSearch2.substring(0, 5);
            System.out.println("I will now search the list if the id exists\n" +
                    "I will complete a sale transaction.");
            Boolean isOnList = false;

            for (int i = 0; i < applienceManager.appliancesLinkedList.size(); i++) {


                if (IdSearch.equalsIgnoreCase(applienceManager.appliancesLinkedList.get(i).getID())) {

                    Boolean fiesta = true;
                    do {
                        System.out.println("Enter the Quantity to Subtract");
                        Scanner keyboardInput982 = new Scanner(System.in);
                        int crazyNum = keyboardInput982.nextInt();
                        int number9 = applienceManager.appliancesLinkedList.get(i).getQuantity();

                        if (number9 > crazyNum) {

                            number9 -= crazyNum;
                            String holder = Integer.toString(number9);
                            applienceManager.appliancesLinkedList.get(i).setQuantity(holder);
                            sales.setSaleQuantity(number9);
                            fiesta = false;
                        } else {
                            System.out.println("The Quantity sold cannot be greater than the quantity in stock\n" +
                                    "Try again.");
                        }
                    } while (fiesta == true);


                    System.out.println("Enter The Customer Id");
                    Scanner keyboardInput9812 = new Scanner(System.in);
                    int cus = keyboardInput9812.nextInt();

                    Boolean flags = false;
                    for (int j = 0; j < customerUser.CustomerLinkedList.size(); j++) {
                        if (cus == customerUser.CustomerLinkedList.get(j).getPersonId()) {
                            sales.setCustomerId(cus);
                            flags = true;
                        }
                    }

                    if (flags == false) {
                        System.out.println("Error, The Id does not exist.");
                        return;
                    }

                    System.out.println("Enter The Employee Id");
                    Scanner keyboardInput981f2 = new Scanner(System.in);
                    int fat = keyboardInput981f2.nextInt();

                    Boolean flags2 = false;
                    for (int j = 0; j < employeesUser.EmployeeLinkedList.size(); j++) {
                        if (fat == employeesUser.EmployeeLinkedList.get(j).getPersonId()) {
                            sales.setEmployeeIdWhoCompletedTheSale(fat);
                            flags2 = true;
                        }
                    }

                    if (flags2 == false) {
                        System.out.println("Error, The Id does not exist.");
                        return;
                    }

                    System.out.println("Enter the sales date: ");
                    Scanner salesDate123456 = new Scanner(System.in);
                    String salesDate = salesDate123456.nextLine();
                    sales.setSaleDate(salesDate);
                    sales.setItemId(IdSearch2);

                    salesManager.saleTransactions.add(sales);

                    isOnList = true;
                }
            }

            if (isOnList == false) {
                System.out.println("Error,That Id Does Not Exist.\n" +
                        "Cannot Complete Sale Transaction.");
            }


        } else {


            System.out.print("Enter a five character Item id: ");
            Scanner keyboardInput2 = new Scanner(System.in);
            String IdSearch2 = keyboardInput2.nextLine();


            while (IdSearch2.length() < 5) { // Input Validation

                System.out.println("Error, That was less than 5 characters.");
                System.out.print("Enter a five character Item id: ");
                Scanner keyboardInput982 = new Scanner(System.in);
                IdSearch2 = keyboardInput982.nextLine();

            }
            String IdSearch = IdSearch2.substring(0, 5);
            System.out.println("I will now search the list if the id exists\n" +
                    "I will complete a sale transaction.");
            Boolean isOnList = false;

            for (int i = 0; i < HardwareItemManager.smallCategoryItemsLinkedList.size(); i++) {


                if (IdSearch.equalsIgnoreCase(HardwareItemManager.smallCategoryItemsLinkedList.get(i).getID())) {

                    Boolean fiesta = true;
                    do {
                        System.out.println("Enter the Quantity to Subtract");
                        Scanner keyboardInput982 = new Scanner(System.in);
                        int crazyNum = keyboardInput982.nextInt();
                        int number9 = HardwareItemManager.smallCategoryItemsLinkedList.get(i).getQuantity();

                        if (number9 > crazyNum) {

                            number9 -= crazyNum;
                            String holder = Integer.toString(number9);
                            HardwareItemManager.smallCategoryItemsLinkedList.get(i).setQuantity(holder);
                            sales.setSaleQuantity(number9);
                            fiesta = false;
                        } else {
                            System.out.println("The Quantity sold cannot be greater than the quantity in stock\n" +
                                    "Try again.");
                        }
                    } while (fiesta == true);


                    System.out.println("Enter The Customer Id");
                    Scanner keyboardInput9812 = new Scanner(System.in);
                    int cus = keyboardInput9812.nextInt();

                    Boolean flags = false;
                    for (int j = 0; j < customerUser.CustomerLinkedList.size(); j++) {
                        if (cus == customerUser.CustomerLinkedList.get(j).getPersonId()) {
                            sales.setCustomerId(cus);
                            flags = true;
                        }
                    }

                    if (flags == false) {
                        System.out.println("Error, The Id does not exist.");
                        return;
                    }

                    System.out.println("Enter The Employee Id");
                    Scanner keyboardInput981f2 = new Scanner(System.in);
                    int fat = keyboardInput981f2.nextInt();

                    Boolean flags2 = false;
                    for (int j = 0; j < employeesUser.EmployeeLinkedList.size(); j++) {
                        if (fat == employeesUser.EmployeeLinkedList.get(j).getPersonId()) {
                            sales.setEmployeeIdWhoCompletedTheSale(fat);
                            flags2 = true;
                        }
                    }

                    if (flags2 == false) {
                        System.out.println("Error, The Id does not exist.");
                        return;
                    }

                    System.out.println("Enter the sales date: ");
                    Scanner salesDate123456 = new Scanner(System.in);
                    String salesDate = salesDate123456.nextLine();
                    sales.setSaleDate(salesDate);

                    sales.setItemId(IdSearch2);

                    salesManager.saleTransactions.add(sales);

                    isOnList = true;
                }
            }

            if (isOnList == false) {
                System.out.println("Error,That Id Does Not Exist.\n" +
                        "Cannot Complete Sale Transaction.");
            }


        }


    }


    /**
     *
     * Prints a list of the sales transactions that have occured.
     *
     */


    private void choiceNine() {



        for(int i =0; i < salesManager.saleTransactions.size();i++){
            if (i == 0) {
                System.out.println("****************Completed Sale Transactions****************************");
                System.out.printf("| %10s | %20s | %20s | %10s | %12s |        \n", "Item ID", "Date",
                        "Sale Quantity", "Customer Id", "Employee Id");
            }

            System.out.printf("| %10s | %20s | %20d | %10d | %12d |\n", salesManager.saleTransactions.get(i).getItemId(),
                    salesManager.saleTransactions.get(i).getSaleDate(), salesManager.saleTransactions.get(i).getSaleQuantity(),
                    salesManager.saleTransactions.get(i).getCustomerId(), salesManager.saleTransactions.get(i).getEmployeeIdWhoCompletedTheSale()
            );


        }





    }


    /**
     * Overides the customer.dat file with all of the updated information stored in the linked list
     *
     */

    private void serializableCustomer() {


        Customers customer = new Customers();


        try {

            FileOutputStream fileOut = new FileOutputStream("src/Customers.dat");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);


            out.writeObject(customerUser);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in Customers.dat file");


        } catch (IOException e) {
            e.printStackTrace();


        }


    }

    /**
     * Reads the file and saves the contents of the customer.dat file into a linked list
     *
     */
    private void deserializationCustomer() {

        Customers customer = null;


        try {

            FileInputStream fileIn = new FileInputStream("src/Customers.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            customerUser = (UserManager) in.readObject();
            in.close();
            fileIn.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        //customerUser.CustomerLinkedList.add(customer);

        customerUser = this.customerUser;


    }

/**
 * Overides the employee.dat file with all of the updated information stored in the linked list
 *
 */

    private void serializableEmployee() {


        Employees employees = new Employees();


        try {

            FileOutputStream fileOut = new FileOutputStream("src/Employee.dat");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);


            out.writeObject(employeesUser);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in Employee.dat file");


        } catch (IOException e) {
            e.printStackTrace();


        }


    }

    /**
     * Reads the file and saves the contents of the employee.dat file into a linked list
     *
     */

    private void deserializationEmployee() {


        try {

            FileInputStream fileIn = new FileInputStream("src/Employee.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            employeesUser = (UserManager) in.readObject();
            in.close();
            fileIn.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        employeesUser = this.employeesUser;


    }

    /**
     * Reads the file and saves the contents of the appliances.dat file into a linked list
     *
     */
    private void serializableAppliances() {


        try {

            FileOutputStream fileOut = new FileOutputStream("src/Appliances.dat");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);


            out.writeObject(applienceManager);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in Appliances.dat file");


        } catch (IOException e) {
            e.printStackTrace();


        }


    }

    /**
     * Reads the file and saves the contents of the hardware.dat file into a linked list
     *
     */


    private void serializableHardware() {


        try {

            FileOutputStream fileOut = new FileOutputStream("src/smallHardwareItems.dat");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);


            out.writeObject(HardwareItemManager);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in smallHardwareItems.dat file");


        } catch (IOException e) {
            e.printStackTrace();


        }


    }

    /**
     * Reads the file and saves the contents of the appliances.dat file into a linked list
     *
     */
    private void deserializationAppliances() {


        try {

            FileInputStream fileIn = new FileInputStream("src/Appliances.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            applienceManager = (InventoryManager) in.readObject();
            in.close();
            fileIn.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        applienceManager = this.applienceManager;


    }

    /**
     * Reads the file and saves the contents of the hardware.dat file into a linked list
     *
     */

    private void deserializationHardware() {


        try {

            FileInputStream fileIn = new FileInputStream("src/smallHardwareItems.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            HardwareItemManager = (InventoryManager) in.readObject();
            in.close();
            fileIn.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        HardwareItemManager = this.HardwareItemManager;


    }

    /**
     *  Reads from the salestransaction.dat file and saves the contents on it to a linked list.
     *
     *
     */
    private void deserializationSalesTransactions(){


    try {

        FileInputStream fileIn = new FileInputStream("src/salesTransactions.dat");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        salesManager = (SaleTransactionInventoryManager) in.readObject();
        in.close();
        fileIn.close();


    } catch (Exception e) {
        e.printStackTrace();

    }

    salesManager = this.salesManager;

}

    /**
     * Saves the contents from the link list into the salestransactions.dat file
     *
     */


private void serializablleSalesTransactions(){

    try {

        FileOutputStream fileOut = new FileOutputStream("src/salesTransactions.dat");

        ObjectOutputStream out = new ObjectOutputStream(fileOut);


        out.writeObject(salesManager);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in salesTransactions.dat file");


    } catch (IOException e) {
        e.printStackTrace();


    }

}




}
























