package Heap;
import linked_list.Linked_list;
import linked_list.linked_list_interface;
public class Nodo_arbol <K extends Comparable <K>, V> {
    private K k;
    private V v;
    private Nodo_arbol<K, V> izq;
    private Nodo_arbol<K, V> der;

    public Nodo_arbol(K k, V v) {
        this.k = k;
        this.v = v;
    }

 
    public Nodo_arbol<K, V> remove(){
            this.k=null;
            return this;
        }

    public K getk() {
        return this.k;
    }


    public V getv() {
        return this.v;
    }

    public void setv(V v) {
        this.v = v;
    }

    public Nodo_arbol<K, V> getizq() {
        return this.izq;
    }

    public void setizq(Nodo_arbol<K, V> izq) {
        this.izq = izq;
    }

    public Nodo_arbol<K, V> getder() {
        return this.der;
    }

    public void setder(Nodo_arbol<K, V> der) {
        this.der = der;
    }
    public void inOrder(linked_list_interface<K> lista) {
        if (izq != null) {
            izq.inOrder(lista);
        }
        lista.add(k);
        if (der != null) {
            der.inOrder(lista);
        }
    }

}
