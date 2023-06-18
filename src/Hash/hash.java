package Hash;
import java.util.Arrays;
import linked_list.Linked_list;

import static java.lang.Math.abs;

public class hash<K,V> implements hash_interface<K,V> {
    V[] elems = null;
    
    public hash(int tamaño){
        elems = (V[]) new Object [tamaño];
    }

    
    public int hashVal(K key){
        //crear una funcion hash para insertar en el arreglo varios valores
        int hash = 0;
        hash = abs(key.hashCode());
        hash = hash % elems.length;
        return hash;
        
    }
    public int hashVal(String key){
        //crear una funcion hash para insertar en el arreglo varios valores
        int hash = 0;
        hash = key.hashCode();
        hash = hash % elems.length;
        return hash;

    }

    @Override
    public void put(K key, V value) {
        elems[hashVal(key)] = value;
    }

    @Override
    public V get(K key) {
        V value = null;
        value = elems[hashVal(key)];
        return value;
    }

    @Override
    public void remove(K key) {
        elems[hashVal(key)] = null;
    }

    @Override
    public boolean contains(K key) {
        boolean contains = false;
        if(elems[hashVal(key)] != null){
            contains = true;
        }
        return contains;
    }

    @Override
    public int size() {
        return elems.length;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for(int i=0; i<elems.length; i++){
            if(elems[i] != null){
                empty = false;
            }
        }
        return empty;
    }


    @Override
    public Linked_list<V> values() {
        Linked_list<V> values = new Linked_list<V>();
        for(int i=0; i<elems.length; i++){
            values.add((V) elems[i]);
        }
        return values;
        
    }

    @Override
    public Linked_list<K> keys() {
        Linked_list<K> keys = new Linked_list<K>();
        for(int i=0; i<elems.length; i++){
            keys.add((K) elems[i]);
        }
        return keys;
    }

    
}
