package BST;
import linked_list.Linked_list;
import linked_list.linked_list_interface;
public class Nodo_arbol <K extends Comparable <K>, V> {
    private K key;
    private V value;
    private Nodo_arbol<K, V> left;
    private Nodo_arbol<K, V> right;

    public Nodo_arbol(K key, V value) {
        this.key = key;
        this.value = value;
    }

 
    public Nodo_arbol<K, V> remove(){
            this.key=null;
            return this;
          
        }

    public void inOrder(linked_list_interface<K> lista) {
        if (left != null) {
            left.inOrder(lista);
        }
        lista.add(key);
        if (right != null) {
            right.inOrder(lista);
        }
    }
    public K getKey() {
        return this.key;
    }


    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Nodo_arbol<K, V> getLeft() {
        return this.left;
    }

    public void setLeft(Nodo_arbol<K, V> left) {
        this.left = left;
    }

    public Nodo_arbol<K, V> getRight() {
        return this.right;
    }

    public void setRight(Nodo_arbol<K, V> right) {
        this.right = right;
    }
    

}
