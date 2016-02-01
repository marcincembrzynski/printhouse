package printshop;

import java.util.Iterator;

/**
 * Implementation of PriorityQueue interface, signifies the end of the priority queue, contains no element.
 * @param <E>
 */
public class EmptyLinkedList<E extends Comparable<E>> implements PriorityQueue<E>, Iterable<E> {
   
    private static EmptyLinkedList emptyLinkedList = new EmptyLinkedList();   

    private EmptyLinkedList() {  
    }
    
    public static <E extends Comparable<E>> EmptyLinkedList<E> getEmptyLinkedList() {
        return emptyLinkedList;
    }

    @Override
    public PriorityQueue<E> enqueue(E element) {
        return new LinkedList(element);
    }

    @Override
    public E head() {
        return null;
    }

    @Override
    public PriorityQueue<E> dequeue() {
        return EmptyLinkedList.getEmptyLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public int length() {
        return 0;
    }   

    @Override
    public PriorityQueue<E> tail() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }   

    @Override
    public E poll() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public PriorityQueue<E> copy() {       
        return EmptyLinkedList.getEmptyLinkedList();
    }        

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}