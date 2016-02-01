package printshop;

import java.util.Iterator;

/** 
 * PrintQueue contains PrintJobs ordered by urgency.
 */
public final class PrintQueue implements PriorityQueue<PrintJob>, Comparable<PrintQueue>{
    
    private final PriorityQueue<PrintJob> list = new LinkedList<>();
    private PrintConfiguration printConfiguration;

    public PrintQueue(PrintConfiguration printConfiguration) {
        this.printConfiguration = printConfiguration;
    }      

    public PrintConfiguration getPrintConfiguration() {
        return printConfiguration;
    } 
    
    @Override
    public PriorityQueue<PrintJob> enqueue(PrintJob e){
        return list.enqueue(e);
    }

    @Override
    public PrintJob head() {
        return list.head();
    }

    @Override
    public PriorityQueue<PrintJob> dequeue() {
       return list.dequeue();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int length() {
        return list.length();
    }   

    @Override
    public PriorityQueue<PrintJob> copy() {
        return list.copy();
    }

    @Override
    public Iterator<PrintJob> iterator() {
        return list.iterator();
    }

    @Override
    public PriorityQueue<PrintJob> tail() {
        return list.tail();
    } 

    @Override
    public PrintJob poll() {
       return list.poll();
    }

    @Override
    public int compareTo(PrintQueue other) {        
        return -1 * ((Integer) this.length()).compareTo((Integer) other.length()) ;
    }      
}