import linked_list.Linked_list;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Linked_listTest {

        @Test
        void add() {
            Linked_list <Integer> list = new Linked_list<>();
            assertEquals(0,list.size());
            list.add(1);
            assertEquals(1,list.size());
            assertEquals(1,list.get(0));
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            assertEquals(5,list.size());
            assertEquals(2,list.get(1));
            assertEquals(3,list.get(2));
            assertEquals(4,list.get(3));
            assertEquals(5,list.get(4));

        }
        @Test
        void get() {
            Linked_list<Integer> list = new Linked_list<>();

            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);


            assertEquals(2,list.get(0));
            assertEquals(3,list.get(1));
            assertEquals(4,list.get(2));
            assertEquals(5,list.get(3));
            assertEquals(6,list.get(4));
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        }
        @Test
        void contains() {
            Linked_list<Integer> list = new Linked_list<>();
            assertFalse(list.contains(2));
            list.add(2);
            assertTrue(list.contains(2));

            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);

            assertTrue(list.contains(3));
            assertTrue(list.contains(4));
            assertTrue(list.contains(5));
            assertTrue(list.contains(6));

            list.remove(2);
            assertFalse(list.contains(2));
            assertFalse(list.contains(7));

        }
        @Test
        void remove() {
            Linked_list<Integer> list = new Linked_list<>();
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);

            list.remove(2);
            assertFalse(list.contains(2));
            list.remove(3);
            list.remove(4);
            list.remove(5);
            list.remove(6);
            assertEquals(0,list.size());
        }
        @Test
        void size() {
            Linked_list<Integer> list = new Linked_list<>();
            assertEquals(0,list.size());
            list.add(2);
            assertEquals(1,list.size());
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);

            assertEquals(5,list.size());

        }

    }