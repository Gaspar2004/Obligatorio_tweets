package Heap;

import linked_list.Linked_list;

public interface heap_interfaz<T extends Comparable<T>>{
    T delete();
    T get(int i);
	void insert(T element);
	int size();

    Linked_list<T> toList();
}
