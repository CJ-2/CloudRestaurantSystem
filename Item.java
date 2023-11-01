package CloudRestaurantSystem;

public class Item {
    int id;
    String name;
    int preparingTime;
    double cost;
    Integer count;
    public Item(int id, String name, int preparingTime, double cost, Integer count){
        this.id = id;
        this.name = name;
        this.preparingTime = preparingTime;
        this.cost = cost;
        this.count = count;
    }
    public String toString(){
        return "["+"id:"+id+", name:"+name+", cost:"+cost +", preparingTime:"+preparingTime+ "]";
    }
}
