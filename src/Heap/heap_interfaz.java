package Heap;

public interface heap_interfaz<T extends Comparable<T>>{
    T delete();
    T get();
	void insert(T element);
	int size();
    
}
