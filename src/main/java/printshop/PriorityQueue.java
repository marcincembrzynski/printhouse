package printshop;

/** 
 * @param <E> the type of elements held in this collection
 */
public interface PriorityQueue<E extends Comparable<E>> extends Iterable<E>{
    
    /**
     * Inserts an element into PriorityQueue
     * @param e
     * @return PriorityQueue
     */
    public PriorityQueue<E> enqueue(E e);
    
    /**
     * @return the element with highest priority
     */
    public E head();
    
    /**
     * Removes the element with highest priority
     * @return PriorityQueue
     */    
    public PriorityQueue<E> dequeue();
    
    /**
     * @return {@code true} if contains no elements
     */
    public boolean isEmpty();
    
    /**     
     * @return length of the PriorityQueue
     */
    public int length ();
    
    /** 
     * @return tail of the queue
     */
    public PriorityQueue<E> tail();
    
    /**
     * @return copy of PriorityQueue
     */
    public PriorityQueue<E> copy();
    
    /**
     * Returns and removes the element with highest priority
     * @return element with highest priority
     */
    public E poll();   
}