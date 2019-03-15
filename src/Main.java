




public class Main {
    public static void main(String[] args)
    {
        Menu menu = new Menu();

        readFile r = new readFile();
        r.openFile();
        r.readFile();
        r.closeFile();

        InventoryManager inventoryManager = new InventoryManager(r);
        int arrayListSize = inventoryManager.getArrayListSize();
        menu.setList(inventoryManager, arrayListSize);
        menu.displayMenu();
        inventoryManager = menu.getInventoryManager();
         arrayListSize = menu.getArrayListSize();

        OverrideFile WriteFile = new OverrideFile(inventoryManager, arrayListSize);




    }
}
