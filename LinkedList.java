package CloudRestaurantSystem;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private Node<E> curr;
    private int size;

    public LinkedList() {

        head = null;
        tail = null;
        curr = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { 
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { 
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) { 
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) { 
        Node<E> newest = new Node<>(e, null); 
        if (isEmpty()) {
            head = newest; 
        } 
        else 
        {
            tail.setNext(newest); 
        }
        tail = newest; 
        size++;
    }
    public E removeFirst() { 
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public E removeLast() { 
        if (isEmpty()) {
            return null;
        }
        E answer = tail.getElement();

        if (head == tail) {
            head = tail = null;
        } else {
            curr = head;
            while (curr.getNext() != tail) {
                curr = curr.getNext();
            }
            tail = curr;
            curr.setNext(null);

        }
        size--;
        return answer;
    }

    public void add(E element, int index)
    {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0) {
            newest.setNext(head);
            head = newest;
            if (tail == null) {
                tail = head;
            }
        } else // add the middle 
        {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            newest.setNext(curr.getNext());
            curr.setNext(newest);
            if (tail == curr) {
                tail = tail.getNext();
            }
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            element = (E) curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return element;
    }

    public void print() {
    
        if (head == null) {
            return;
        }

        curr = head;
        while (curr != null) {
            System.out.print(" "+curr.getElement());
            curr = curr.getNext();
        }
    }    
}

