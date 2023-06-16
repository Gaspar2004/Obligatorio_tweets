package Hash;
import linked_list.Linked_list;

public interface hash_interface<K,V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean contains(K key);
    int size();
    boolean isEmpty();
    Linked_list<K> keys();
    Linked_list<V> values();
}