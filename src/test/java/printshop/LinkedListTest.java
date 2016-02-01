package printshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testEnqueue() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.length());
        assertEquals(new Integer(1), queue.head());
    }

    @Test
    public void testHead() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        queue.enqueue(2);
        queue.enqueue(1);
        assertEquals(new Integer(1), queue.head());
    }

    @Test
    public void testDequeue() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        queue.enqueue(2);
        queue.enqueue(99);
        queue.dequeue();
        queue.dequeue();
        assertEquals(null, queue.head());
        queue.enqueue(1);
        assertEquals(1, queue.length());
    }

    @Test
    public void testIsEmpty() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testLength() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        assertEquals(0, queue.length());
        queue.enqueue(1);
        assertEquals(1, queue.length());
    }

    @Test
    public void testTail() {
        Integer[] elements = {1, 2, 3, 4, 5};
        PriorityQueue<Integer> queue = new LinkedList<>();
        for (Integer value : elements) {
            queue.enqueue(value);
        }
        PriorityQueue<Integer> tail = queue.tail();
        assertEquals(4, tail.length());
    }

    @Test
    public void test1Iterator() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        queue.enqueue(104);
        queue.enqueue(103);      
        int i = 0;
        for (Integer value : queue) {
            i++;
        }
        assertEquals(2, i);
    }

    @Test
    public void testPoll() {
        PriorityQueue<Integer> queue = new LinkedList<>();
        queue.enqueue(1);
        assertEquals(new Integer(1), queue.poll());
        assertEquals(0, queue.length());
        queue.enqueue(1);
        assertEquals(1, queue.length());
    }
}