package CloudRestaurantSystem;

public class Order {
    int id;
    double totalCost;
    LinkedList<Item> items;
    public Order(int id){
        this.id = id;
        items = new LinkedList<>();
        totalCost = 0;
    }
    public void print(){
        System.out.println("Order id:"+id+" totalCost:"+totalCost+"\nDetails{");
        items.print();
        System.out.println("\n}");
    }
}
