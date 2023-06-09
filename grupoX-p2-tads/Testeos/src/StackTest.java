import linked_list.Linked_list;
import org.junit.jupiter.api.Test;
import stack.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class StackTest {
    @Test
    void push() throws EmptyStackException {
        Linked_list <Integer> stack = new Linked_list<>();
        assertFalse(stack.contains(2));
        stack.push(2);
        assertTrue(stack.contains(2));

        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertTrue(stack.contains(3));
        assertTrue(stack.contains(4));
        assertTrue(stack.contains(5));

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void pop() throws EmptyStackException {

        Linked_list<Integer> stack = new Linked_list<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());

        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void peek() throws EmptyStackException {
        Linked_list<Integer> stack = new Linked_list<>();

        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.peek());
        stack.pop();
        assertEquals(3, stack.peek());
        stack.pop();
        stack.pop();
        assertEquals (null,stack.peek()  );    }

    @Test
    void size() throws EmptyStackException {
        Linked_list<Integer> stack = new Linked_list<>();
        assertEquals(0, stack.size());
        stack.push(2);
        assertEquals(1, stack.size());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        assertEquals(5, stack.size());
        stack.pop();
        assertEquals(4, stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }



}
