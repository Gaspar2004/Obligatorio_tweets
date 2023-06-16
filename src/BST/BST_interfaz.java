package BST;
import java.util.List;

import linked_list.Linked_list;

public interface BST_interfaz <K,T>{
    void add(K key, T value);
    T find(K key);
    boolean contains(K key);
    void remove(K key);
    K findMin();
    K findMax();
    public Linked_list inOrder();
    public Linked_list preOrder();
    public Linked_list postOrder();
    int size();
}
