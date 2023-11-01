package CloudRestaurantSystem;

public class Stack<E> {
    LinkedList<E>list=new LinkedList<>();
    public Stack(){}
    public int size(){return list.size();}
    public boolean isEmpty(){return list.isEmpty();}
    public void push(E element){list.addFirst(element);}
    public E top(){return list.first();}
    public E pop(){return list.removeFirst();}   
     
}
