package CloudRestaurantSystem;

public class Queue <E> {
    LinkedList<E> list = new LinkedList();
    public Queue(){}
    public boolean isEmpty(){return list.isEmpty();}
    public void enqueue(E element){list.addLast(element);}
    public E first(){return list.first();}
    public E dequeue(){return list.removeFirst();}
    public int size(){return list.size();}
    public void print(){
        list.print();
    }
}
