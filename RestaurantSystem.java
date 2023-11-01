package CloudRestaurantSystem;
import java.util.Scanner;

public class RestaurantSystem {
    // Static variables for the restaurant system
    static Menu menu = new Menu();
    static TreeNode itemsRoot = menu.ItemsRoot;
    static Queue<Order> kitchQueue = menu.kitchenQueue;
    static DrinkVendingMachine vendingMachine = menu.vendingMachine;
    static int id=0;
    static double totalsales = 0;
    static Queue<Order> historyOrders = new Queue<>();

    //methods
    // Method to print the list of orders
    public static void print_Orders_list(){
        for(int i=0; i<kitchQueue.size();i++){
            Order temp = kitchQueue.dequeue();
            temp.print();
            kitchQueue.enqueue(temp);
        }
    }
    // Method to delete an order by its ID
    public static void deleteOrder(int id){
        int size = kitchQueue.size();
        for(int i=0;i<size;i++){
            Order temp = kitchQueue.dequeue();
            if(id!=temp.id){
               kitchQueue.enqueue(temp);
            }
        }
    }
    // Method to delete an item from an order by its ID
    public static void deleteItem(int id){
        int size = kitchQueue.size();
        int iditem = 0;
        Order tempID = null;
        for(int i = 0; i<size;i++){
            Order temp = kitchQueue.dequeue();
            if(id==temp.id){
                tempID = temp;
            }
            kitchQueue.enqueue(temp);
        }
        int sizeItems = tempID.items.size();
        tempID.print();
        System.out.println("plase enter Item ID.");
        Scanner in = new Scanner(System.in);
        iditem = in.nextInt();
        for(int i=0;i<sizeItems;i++){
            Item temp1 = tempID.items.removeFirst();
            if(iditem!=temp1.id){
                tempID.items.addLast(temp1);
            }
        }
    
    }
    // Method to apply discount to an order by its ID
    public static void descount(int id, double descount){
        int size = kitchQueue.size();
        int iditem = 0;
        double totalCost = 0;
        descount = descount/100;
        Order tempID = null;
        for(int i = 0; i<size;i++){
            Order temp = kitchQueue.dequeue();
            if(id==temp.id){
                tempID = temp;
            }
            kitchQueue.enqueue(temp);
        }
        System.out.println("before descount");
        System.out.printf("totalCost:%1.3f%n",tempID.totalCost);
        totalCost = tempID.totalCost;
        totalCost= totalCost-(totalCost*descount);
        tempID.totalCost=totalCost;
        System.out.println("after descount");
        System.out.printf("totalCost:%1.3f%n",tempID.totalCost);

        }
        // Method to display the menu
        public static void menu(TreeNode tree){
            System.out.println(tree.name+" id:"+tree.id+" {");
            if(tree.children.isEmpty()){
                for(int i=0; i<tree.items.size();i++){
                    Item t = tree.items.removeFirst();
                    System.out.println(t);
                    tree.items.addLast(t);
                }
            }else{
                for(int i=0; i<tree.children.size(); i++){
                    TreeNode temp = tree.children.removeFirst();
                    menu(temp);
                    tree.children.addLast(temp);
                }
            }
            System.out.println(" }");
        }
        // Method to display the quantity of items in the menu
        public static void Quantity(TreeNode tree){
            System.out.println(tree.name+" Quantity{");
            if(tree.children.isEmpty()){
                for(int i=0; i<tree.items.size();i++){
                    Item t = tree.items.removeFirst();
                    System.out.println("[name:"+t.name+" count:"+t.count+"]");
                    tree.items.addLast(t);
                }
            }else{
                for(int i=0; i<tree.children.size(); i++){
                    TreeNode temp = tree.children.removeFirst();
                    Quantity(temp);
                    tree.children.addLast(temp);
                }
            }
            System.out.println(" }");
        }
        // Method to edit the quantity of items
        public static void editQuantity(){
            Scanner in = new Scanner(System.in);
            int choice = 0;
            String choice2 = null;
            do{
                        TreeNode Category = itemsRoot;
                        while(!Category.children.isEmpty()){
                            for(int i=0; i<Category.children.size(); i++){
                                TreeNode temp = Category.children.removeFirst();
                                System.out.print(temp+" ");
                                Category.children.addLast(temp);
                            }
                            System.out.println();
                            System.out.println("choose a category number.");
                            choice = in.nextInt();
                            TreeNode categoryChoice = Category;
                            for(int i =0; i<Category.children.size();i++){
                                TreeNode temp = Category.children.removeFirst();
                                if(temp.id==choice){
                                    categoryChoice = temp;
                                }
                                Category.children.addLast(temp);
                            }
                            Category = categoryChoice;
                        }
                        for(int i=0; i<Category.items.size(); i++){
                                Item temp = Category.items.removeFirst();
                                System.out.print(temp+" ");
                                Category.items.addLast(temp);
                            }
                            System.out.println();
                        Item item = null;
                        System.out.println("choose an item.");
                        choice = in.nextInt();
                        Item temp = null;
                        for(int i=0; i<Category.items.size(); i++){
                            item = Category.items.removeFirst();
                            if(choice==item.id){
                                temp=item;
                            }
                            Category.items.addLast(item);
                        }
                        System.out.println("enter the new count");
                        temp.count = in.nextInt();
                        System.out.println("edit another item? (y/n)");
                        choice2 = in.next();
                    }while(choice2.toLowerCase().equals("y"));
        }
        // Method to display the history of orders
        public static void historyOrders(){
             for(int i=0; i<historyOrders.size();i++){
                 Order temp = historyOrders.dequeue();
                temp.print();
                historyOrders.enqueue(temp);
            }
        }
        // Method to fill the quantity of items in the menu
         public static void fillQuantity(TreeNode tree){
            if(tree.children.isEmpty()){
                for(int i=0; i<tree.items.size();i++){
                    Item t = tree.items.removeFirst();
                    t.count = 20;
                    tree.items.addLast(t);
                }
            }else{
                for(int i=0; i<tree.children.size(); i++){
                    TreeNode temp = tree.children.removeFirst();
                    fillQuantity(temp);
                    tree.children.addLast(temp);
                }
            }
        }
        // Method to add a new item to the menu
        public static void AddNewItem() {
            Scanner in = new Scanner(System.in);
            Scanner in2 = new Scanner(System.in);
            System.out.println("Enter the category ID where the item should be added:");
            int categoryId = in.nextInt();
            in.nextLine();  // Consume newline left-over
            System.out.println("Enter the Id of the new item:");
            int itemId = in.nextInt();
            System.out.println("Enter the name of the new item:");
            String itemName = in2.nextLine();
        
            System.out.println("Enter the cost of the new item:");
            double itemCost = in.nextDouble();
        
            System.out.println("Enter the preparing time of the new item:");
            int itemPreparingTime = in.nextInt();
            System.out.println("Enter the quantity of the new item:");
            int itemquantity = in.nextInt();
            // Create new item
            Item newItem = new Item(itemId, itemName, itemPreparingTime, itemCost, itemquantity);
        
            // Find the category and add the item
            TreeNode category = findCategoryById(itemsRoot, categoryId);
            if (category != null) {
                category.items.addLast(newItem);
                System.out.println("Item added successfully.");
                System.out.println("the new menu:");
                menu(itemsRoot);
            } else {
                System.out.println("Category not found.");
            }
        }
        
        // Helper method to find a category by its ID
        public static TreeNode findCategoryById(TreeNode root, int id) {
            TreeNode foundCategory = null;
            if(root.children.first().id==id){
                return root.children.first();
            }
            for(int i=0; i<root.children.size(); i++){
                TreeNode temp = root.children.removeFirst();
                if(temp.id==id){
                    foundCategory = temp;
                }
                root.children.addLast(temp);
            }
            return foundCategory;
        }
        // Method to display the main menu and handle user input
        public static void mainmenu(){
            Scanner in = new Scanner(System.in);
            int choice = 0;
        do{
            System.out.println("Choose an option.\n 1-Menu to order. \n 2-preparing orders \n 3-Drinks vending machine \n 4-Kitchen status. \n 5-The basket \n 6-admin \n 7-descount \n 8-Menu \n 9-add new item \n 10-exit the application ");
            choice = in.nextInt();
            String choice2 = null;
            switch(choice){
                case 1: {
                    Order order = new Order(++id);
                    do{
                        TreeNode Category = itemsRoot;
                        while(!Category.children.isEmpty()){
                            for(int i=0; i<Category.children.size(); i++){
                                TreeNode temp = Category.children.removeFirst();
                                System.out.print(temp+" ");
                                Category.children.addLast(temp);
                            }
                            System.out.println();
                            System.out.println("choose a category number.");
                            choice = in.nextInt();
                            TreeNode categoryChoice = Category;
                            for(int i =0; i<Category.children.size();i++){
                                TreeNode temp = Category.children.removeFirst();
                                if(temp.id==choice){
                                    categoryChoice = temp;
                                }
                                Category.children.addLast(temp);
                            }
                            Category = categoryChoice;
                        }
                        for(int i=0; i<Category.items.size(); i++){
                                Item temp = Category.items.removeFirst();
                                System.out.print(temp+" ");
                                Category.items.addLast(temp);
                            }
                            System.out.println();
                        Item item = null;
                        System.out.println("choose an item.");
                        choice = in.nextInt();
                        for(int i=0; i<Category.items.size(); i++){
                            item = Category.items.removeFirst();
                            if(choice==item.id){
                                if(item.count>0){
                                    item.count--;
                                    order.items.addLast(item);
                                }else{
                                    System.out.println("sorry, this item is not available right now.");
                                }
                            }
                            Category.items.addLast(item);
                        }
                        System.out.println("Add another item? (y/n)");
                        choice2 = in.next();
                    }while(choice2.toLowerCase().equals("y"));
                    double totalCost = 0;
                    int totalTime = 0;
                    System.out.println("your order is:"+order.id);
                    for(int i=0; i<order.items.size(); i++){
                        Item temp = order.items.removeFirst();
                        totalCost+= temp.cost;
                        totalTime+= temp.preparingTime;
                        System.out.print(temp+" ");
                        order.items.addLast(temp);
                    }
                    order.totalCost=totalCost;
                    System.out.println("\nTotal order cost:"+totalCost+"\nTotal order Time:"+ totalTime);
                    kitchQueue.enqueue(order);
                    break;
                }
                case 2: {
                    do{
                        
                        if(!kitchQueue.isEmpty()){
                            Order temp = kitchQueue.dequeue();
                            totalsales+=temp.totalCost;
                            System.out.println("orders list:");
                            for(int i=0; i<temp.items.size(); i++){
                                Item temp1 = temp.items.removeFirst();
                                System.out.print(temp1+" ");
                                temp.items.addLast(temp1);
                            }
                            System.out.println();
                            historyOrders.enqueue(temp);
                        }else{
                            System.out.println("kitchen is empty of orders");
                        }
                        System.out.println("prepate another order? (y/n)");
                        choice2 = in.next();
                    }while(choice2.toLowerCase().equals("y"));
                        break;
                }
                case 3: {
                    do{
                        System.out.println("choose a drink. \n 1-juice \n 2-cola \n 3-water");
                        choice = in.nextInt();
                        switch(choice){
                           case 1: {
                            if(!vendingMachine.juiceStack.isEmpty()){
                                Item temp = vendingMachine.juiceStack.pop();
                                System.out.println(temp+" ");
                            }else{
                                System.out.println("sorry, this drink is not available right now.");
                            }
                            break;
                           }
                           case 2: {
                            if(!vendingMachine.colaStack.isEmpty()){
                                Item temp = vendingMachine.colaStack.pop();
                                System.out.println(temp+" ");
                            }else{
                                System.out.println("sorry, this drink is not available right now.");
                            }
                            break;
                           }
                            case 3: {
                            if(!vendingMachine.waterStack.isEmpty()){
                                Item temp = vendingMachine.waterStack.pop();
                                System.out.println(temp+" ");
                            }else{
                                System.out.println("sorry, this drink is not available right now.");
                            }
                            break;
                           }
                           default:
                           System.out.println("invalid drink");
                        }
                        System.out.println("order another Drink? (y/n)");
                        choice2 = in.next();
                    }while(choice2.toLowerCase().equals("y"));
                    break;
                }
                case 4:
                    print_Orders_list();
                break;
                case 5:
                    System.out.println("1- for deleteing an Order\n2- for deleteing an items");
                    System.out.println("choose your option.");
                    choice = in.nextInt();
                    if(choice==1){
                        System.out.println("plase enter Order ID");
                        deleteOrder(in.nextInt());
                    }else if(choice==2){
                        System.out.println("plase enter Order ID");
                        deleteItem(in.nextInt());
                    }else{
                        System.out.println("invaild input");
                    }
                    break;
                case 6:{
                    do{
                    System.out.println("[admin]");
                    System.out.println("1-totalsales");
                    System.out.println("2-Quantity");
                    System.out.println("3-edit Quantity");
                    System.out.println("4-History Orders");
                     System.out.println("5-fill Quantity");
                    System.out.println("6-exit");
                    System.out.println("choose your option.");
                    choice = in.nextInt();
                    if(choice==1){
                        System.out.println("Totalsales:"+totalsales);
                    }else if(choice==2){
                        Quantity(itemsRoot);
                    }else if(choice==3){
                        editQuantity();
                    }
                    else if(choice==4){
                        historyOrders();
                    }else if(choice==5){
                        fillQuantity(itemsRoot);
                    }
                    else{
                        System.out.println("invaild input");
                    }
                    }while(choice!=6);
                    break;
                }
                case 7:
                    System.out.println("plase enter Order ID");
                    int id= in.nextInt();
                    System.out.println("plase enter the descount by 10% or 20% or 30% or 40%");
                    double descount = in.nextDouble();
                    descount(id, descount);
                    break;
                case 8:
                    menu(itemsRoot);
                    break;
                case 9:
                AddNewItem();
                default: {
                    if (choice!=10) {
                        System.out.println("invalid input");
                    }
                }
            }
        }while(choice!=10);
        }
        // Method to run the restaurant system
        public static void myCloudRestaurant(){
             Scanner in = new Scanner(System.in);
             int choice = 0;
        do{
            System.out.println("Welcome to My-Cloud_restaurant");
            System.out.println("please select one option.\n 1-Menu to order. \n 2-Add new item to the menu \n 3-Kitchen status. \n 4-Back to main menu. \n 5-exit");
            choice = in.nextInt();
            String choice2 = null;
            switch(choice){
                case 1: {
                    Order order = new Order(++id);
                    menu(itemsRoot);
                    do{
                        TreeNode Category = itemsRoot;
                        while(!Category.children.isEmpty()){
                            for(int i=0; i<Category.children.size(); i++){
                                TreeNode temp = Category.children.removeFirst();
                                System.out.print(temp+" ");
                                Category.children.addLast(temp);
                            }
                            System.out.println();
                            System.out.println("choose a category number.");
                            choice = in.nextInt();
                            TreeNode categoryChoice = Category;
                            for(int i =0; i<Category.children.size();i++){
                                TreeNode temp = Category.children.removeFirst();
                                if(temp.id==choice){
                                    categoryChoice = temp;
                                }
                                Category.children.addLast(temp);
                            }
                            Category = categoryChoice;
                        }
                        for(int i=0; i<Category.items.size(); i++){
                                Item temp = Category.items.removeFirst();
                                System.out.print(temp+" ");
                                Category.items.addLast(temp);
                            }
                            System.out.println();
                        Item item = null;
                        System.out.println("choose an item.");
                        choice = in.nextInt();
                        for(int i=0; i<Category.items.size(); i++){
                            item = Category.items.removeFirst();
                            if(choice==item.id){
                                if(item.count>0){
                                    item.count--;
                                    order.items.addLast(item);
                                }else{
                                    System.out.println("sorry, this item is not available right now.");
                                }
                            }
                            Category.items.addLast(item);
                        }
                        System.out.println("Add another item? (y/n)");
                        choice2 = in.next();
                    }while(choice2.toLowerCase().equals("y"));
                    double totalCost = 0;
                    int totalTime = 0;
                    System.out.println("your order is:"+order.id);
                    for(int i=0; i<order.items.size(); i++){
                        Item temp = order.items.removeFirst();
                        totalCost+= temp.cost;
                        totalTime+= temp.preparingTime;
                        System.out.print(temp+" ");
                        order.items.addLast(temp);
                    }
                    order.totalCost=totalCost;
                    System.out.println("\nTotal order cost:"+totalCost+"\nTotal order Time:"+ totalTime);
                    kitchQueue.enqueue(order);
                    break;
                }
                case 3:
                    print_Orders_list();
                break;
                case 4:
                mainmenu();
                break;
                case 2:
                AddNewItem();
                break;
                default: {
                    if (choice!=5) {
                        System.out.println("invalid input");
                    }
                }
            }
        }while(choice!=5);
        }
        // Main method to start the restaurant system
    public static void main(String[] args) {
        myCloudRestaurant();
    }
}
