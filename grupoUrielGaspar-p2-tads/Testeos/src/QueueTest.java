import linked_list.Linked_list;
import org.junit.jupiter.api.Test;
import queue.EmptyQueueException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class QueueTest {

    @Test
    void enqueue() {
        Linked_list <Integer> queue = new Linked_list<>();
        assertEquals(0,queue.size());
        queue.enqueue(2);
        assertEquals(1,queue.size());

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        assertEquals(2,queue.get(0));
        assertEquals(3,queue.get(1));
        assertEquals(4,queue.get(2));
        assertEquals(5,queue.get(3));
        assertEquals(6,queue.get(4));
    }
    @Test
    void dequeue() throws EmptyQueueException {
        Linked_list<Integer> queue = new Linked_list<>();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.dequeue());
        assertEquals(4,queue.dequeue());
        assertEquals(5,queue.dequeue());
        assertEquals(6,queue.dequeue());
        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
    }
    @Test
    void contains() throws EmptyQueueException {
        Linked_list<Integer> queue = new Linked_list<>();

        assertFalse(queue.contains(2));
        queue.enqueue(2);
        assertTrue(queue.contains(2));

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertTrue(queue.contains(3));
        assertTrue(queue.contains(4));
        assertTrue(queue.contains(5));

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertFalse(queue.contains(2));
        assertFalse(queue.contains(7));

    }
    @Test
    void size() throws EmptyQueueException {
        Linked_list<Integer> queue = new Linked_list<>();
        assertEquals(0,queue.size());
        queue.enqueue(2);
        assertEquals(1,queue.size());

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(4,queue.size());
        queue.dequeue();
        assertEquals(3,queue.size());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals(0,queue.size());
    }


}
