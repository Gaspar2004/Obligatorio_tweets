import org.junit.jupiter.api.*;

import Heap.heap;

import static org.junit.Assert.assertEquals;

public class HeapTests {
    @Test
    void insert() {
        heap <Integer> heap_prueba = new heap <> (10);
        assertEquals(0, heap_prueba.size());
        heap_prueba.insert(1);
        heap_prueba.insert(5);
        heap_prueba.insert(3);
        heap_prueba.insert(5);
        assertEquals(4, heap_prueba.size());
        //assertEquals(1, heap_prueba.get());

    }
    @Test
    void delete() {
        heap <Integer> heap = new heap <> (10);
        heap.insert(7);
        heap.insert(5);
        heap.insert(3);
        assertEquals ( 3, heap.size() );

        //assertEquals(3, heap.delete());
        assertEquals(2, heap.size());
        //assertEquals(5, heap.delete());
        assertEquals(1, heap.size());
        //assertEquals(7, heap.delete());
    }
    @Test
    void get() {
        heap <Integer> heap = new heap <> (10);
        heap.insert(7);
        heap.insert(5);
        heap.insert(3);
        //assertEquals(3, heap.get());

        heap.delete();
        //assertEquals(5, heap.get());
        heap.delete();
        //assertEquals(7, heap.get());
    }
    @Test
    void size() {
        heap <Integer> heap = new heap <> (10);
        assertEquals(0, heap.size());
        heap.insert(7);
        assertEquals(1, heap.size());
        heap.insert(5);
        assertEquals(2, heap.size());
        heap.insert(3);
        assertEquals(3, heap.size());
        heap.delete();
        assertEquals(2, heap.size());
        heap.delete();
        assertEquals(1, heap.size());
        heap.delete();
        assertEquals(0, heap.size());
    }

}
