package CloudRestaurantSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    TreeNode ItemsRoot = new TreeNode(1, "Menu");
    Queue<Order> kitchenQueue = new Queue<>();
    DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

    public Menu() {
        TreeNode Appetizers = new TreeNode(1, "Appetizers");
        TreeNode Salads = new TreeNode(2, "Salads");
        TreeNode Burgers = new TreeNode(3, "Burgers");
        TreeNode Pizzas = new TreeNode(4, "Pizzas");
        TreeNode Desserts = new TreeNode(5, "Desserts");
        TreeNode FriedBurgers = new TreeNode(6, "Fried_Burgers");
        TreeNode GrilledBurgers = new TreeNode(7, "Grilled_Burgers");

        ItemsRoot.children.addLast(Appetizers);
        ItemsRoot.children.addLast(Salads);
        ItemsRoot.children.addLast(Burgers);
        ItemsRoot.children.addLast(Pizzas);
        ItemsRoot.children.addLast(Desserts);
        Burgers.children.addLast(FriedBurgers);
        Burgers.children.addLast(GrilledBurgers);

        try {
            File myObj = new File("C:\\Users\\azoz5\\OneDrive\\سطح المكتب\\CloudRestaurantSystem\\Items.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();

            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Appetizers.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.nextLine();

            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Salads.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.nextLine();

            for (int i = 0; i < 2; i++) {
                String item = myReader.nextLine();
                FriedBurgers.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.nextLine();

            for (int i = 0; i < 3; i++) {
                String item = myReader.nextLine();
                GrilledBurgers.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.nextLine();

            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Pizzas.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.nextLine();

            for (int i = 0; i < 5; i++) {
                String item = myReader.nextLine();
                Desserts.items.addLast(new Item(Integer.parseInt(item.split(" ")[0]), item.split(" ")[1], Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), Integer.parseInt(item.split(" ")[4])));
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("C:\\Users\\azoz5\\OneDrive\\سطح المكتب\\CloudRestaurantSystem\\Drinks.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String item = myReader.nextLine();

                switch(item.split(" ")[1]){
                    case "Cola":{
                        vendingMachine.colaStack.push(new Item(Integer.parseInt(item.split(" ")[0]), "Cola", Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), null));
                        break;
                    }
                    case "Juice":{
                        vendingMachine.juiceStack.push(new Item(Integer.parseInt(item.split(" ")[0]), "Juice", Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), null));
                        break;
                    }
                    case "Water":{
                        vendingMachine.waterStack.push(new Item(Integer.parseInt(item.split(" ")[0]), "Water", Integer.parseInt(item.split(" ")[2]), Float.parseFloat(item.split(" ")[3]), null));
                        break;
                    }
                    default:
                        break;
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}