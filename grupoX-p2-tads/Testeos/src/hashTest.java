import linked_list.Linked_list;
import org.junit.jupiter.api.Test;
import Hash.hash;
import static org.junit.jupiter.api.Assertions.*;
public class hashTest {

    @Test
    void add() {
        hash<Integer, String> hash = new hash<>(10);
        assertEquals(true,hash.isEmpty());
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        assertEquals("a", hash.get (1));
        assertEquals("b", hash.get (5));
        assertEquals("c", hash.get (3));
        assertEquals(null, hash.get (2));
    }
    @Test
    void get(){
        hash<Integer, String> hash = new hash<>(10);
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        assertEquals("a", hash.get (1));
        assertEquals("b", hash.get (5));
        assertEquals("c", hash.get (3));
        assertEquals(null, hash.get (2));
    }
    @Test
    void remove(){
        hash<Integer, String> hash = new hash<>(10);
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        hash.remove(1);
        assertEquals(null, hash.get (1));
        assertEquals("b", hash.get (5));
        assertEquals("c", hash.get (3));
        assertEquals(null, hash.get (2));
    }

    @Test
    void contains(){
        hash<Integer, String> hash = new hash<>(10);
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        assertEquals(true, hash.contains(1));
        assertEquals(true, hash.contains(5));
        assertEquals(true, hash.contains(3));
        assertEquals(false, hash.contains(2));
    }

    @Test
    void size(){
        hash<Integer, String> hash = new hash<>(10);
        assertEquals(10, hash.size());
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        assertEquals(10, hash.size());
    }

    @Test
    void isEmpty(){
        hash<Integer, String> hash = new hash<>(10);
        assertEquals(true, hash.isEmpty());
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        assertEquals(false, hash.isEmpty());
        hash.remove (1 );
        hash.remove (5 );
        hash.remove (3 );
        assertEquals(true, hash.isEmpty());
    }
    @Test
    void keys(){
        hash<Integer, String> hash = new hash<>(10);
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        Linked_list<Integer> keys = new Linked_list<>();
        keys.add(1);
        keys.add(5);
        keys.add(3);
        //assertEquals(keys, hash.keys());
    }
    @Test
    void values(){
        hash<Integer, String> hash = new hash<>(10);
        hash.put (1, "a");
        hash.put (5, "b");
        hash.put (3, "c");
        Linked_list<String> values = new Linked_list<>();
        values.add("a");
        values.add("b");
        values.add("c");
        //assertEquals(values, hash.values());
    }
}
