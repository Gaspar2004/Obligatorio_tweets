package Heap;

import linked_list.Linked_list;

public class heap<T extends Comparable<T>> implements heap_interfaz<T>{
    private static final int cap = 2;

	private int size; 
	private T[] heap; 
    private boolean esMin = true;

	public heap() {
	    this(true);
	}

    public heap(boolean esMin) {
        size = 0;
        heap = (T[]) new Comparable[cap];
        this.esMin = esMin;
    }

	public heap(int cap) {
	    this(cap, true);
	}

    public heap(int cap, boolean esMin) {
        size = 0;
        heap = (T[]) new Comparable[cap + 1];
        this.esMin = esMin;
	}


	public heap(T[] array) {
	    this(array, true);
	}

  
    public heap(T[] array, boolean esMin) {
        this.esMin = esMin;
        size = array.length;
        heap = (T[]) new Comparable[array.length + 1];

        System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0
        // index

        crearHeap();
    }


	
	private void crearHeap() {
		for (int k = size / 2; k > 0; k--) {
			ordenarHeap(k);
		}
	}

	private void ordenarHeap(int k) {
		T aux = heap[k];
		int min;
		for (; 2 * k <= size; k = min) {
			min = 2 * k;
			if (min != size && (esMin ? heap[min].compareTo(heap[min + 1]) > 0 : !(heap[min].compareTo(heap[min + 1]) > 0)))
				min++;
			if (esMin ? aux.compareTo(heap[min]) > 0 : !(aux.compareTo(heap[min]) > 0))
				heap[k] = heap[min];
			else
				break;
		}
		heap[k] = aux;
	}

	

	public T delete() throws RuntimeException {
		if (size == 0)
			throw new RuntimeException();
		T min = heap[1];
		heap[1] = heap[size--];
		ordenarHeap(1);
		return min;
	}

	public T get() {
		if (size == 0)
			throw new RuntimeException();
		T min = heap[1];
		return min;
	}
	
	/*@Override
	public T get() {
		if (size == 0)
			throw new RuntimeException();
		T min = heap[1];
		return min;
	}*/



	public void insert(T x) {
		if (size == heap.length - 1)
			reajustar();

		int pos = ++size;

		for (; pos > 1 && (esMin ? x.compareTo(heap[pos / 2]) < 0 : !(x.compareTo(heap[pos / 2]) < 0)); pos = pos / 2)
			heap[pos] = heap[pos / 2];

		heap[pos] = x;
	}

	private void reajustar() {
		T[] old = heap;
		heap = (T[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public String toString() {
		String ret = "";
		for (int k = 1; k <= size; k++)
			ret += heap[k] + " ";
		return ret;
	}

	public int size() {
		return size;
	}

	@Override
	public Linked_list<T> toList() {
		Linked_list<T> list = new Linked_list<T>();
		for (int i = 1; i <= size; i++) {
			list.add(heap[i]);
		}
		return list;
	}


}
