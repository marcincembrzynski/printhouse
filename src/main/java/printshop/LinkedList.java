package printshop;

import java.util.Iterator;

/**
 * Implementation of PriorityQueue interface. 
 * @param <E>
 */
public final class LinkedList<E extends Comparable<E>> implements PriorityQueue<E>, Iterable<E> {

    private E head;
    private PriorityQueue tail;

    public LinkedList() {
        this.head = null;
        this.tail = EmptyLinkedList.getEmptyLinkedList();
    }

    public LinkedList(E head) {
        this.head = head;
        this.tail = EmptyLinkedList.getEmptyLinkedList();
    }

    private LinkedList(E head, PriorityQueue<E> tail) {
        this.head = head;
        this.tail = tail;
    }   

    @Override
    public PriorityQueue<E> enqueue(E element) {

        if (isEmpty()) {
            head = element;
            return new LinkedList<>(element);           
        }

        if (head.compareTo(element) == -1) {
            tail = tail.enqueue(element);

        } else {
            tail = new LinkedList<>(head, tail.copy());
            head = element;
        }
        
        return new LinkedList<>(head, tail.copy());
    }

    @Override
    public E head() {
        return this.head;
    }

    @Override
    public PriorityQueue<E> dequeue() {

        if (this.length() == 0) {
            head = null;
            return EmptyLinkedList.getEmptyLinkedList();
        }

        head = (E) tail.head();
        tail = tail.dequeue();
        return new LinkedList<>(head, tail.copy());
    }
   
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        
        if(head == null){
            return 0;
        }        
        return 1 + tail.length();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public PriorityQueue<E> copy() {            
        return new LinkedList<>(head, tail.copy());
    }

    @Override
    public PriorityQueue<E> tail() {
        return tail.copy();
    }  

    @Override
    public E poll() {
        E h = head;
        PriorityQueue<E> dequeue = this.dequeue();        
        return h;        
    }
    
    protected class LinkedListIterator implements Iterator<E> {

        private PriorityQueue<E> temp;
        private E h;

        protected LinkedListIterator() {
            this.temp = LinkedList.this;
        }

        @Override
        public boolean hasNext() {
            return !temp.isEmpty();
        }

        @Override
        public E next() {

            h = (E) temp.head();
            temp = temp.tail();
            return h;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
}