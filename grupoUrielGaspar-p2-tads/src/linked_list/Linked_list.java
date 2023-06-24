package linked_list;
import queue.EmptyQueueException;
import stack.EmptyStackException;

public class Linked_list<T> implements linked_list_interface<T>, queue.queue_interfaz<T>, stack.stack_interfaz<T> {
    private Nodo<T> first;
    private Nodo<T> last;

    public Linked_list(){
        this.first = null;
        this.last = null;
    }
    public void addToTheEnd(T value) {
        if (value != null) {
            Nodo<T> elementToAdd = new Nodo<>(value);
            if (this.first == null) {
                this.first = elementToAdd;
                this.last = elementToAdd;
            } else {
                this.last.setNext(elementToAdd);
                this.last = elementToAdd;
            }
        } else {}
    }
    public void addToBeginning(T value) {
        if (value != null) {
            Nodo<T> elementToAdd = new Nodo<>(value);
            if (this.first == null) {
                this.first = elementToAdd;
                this.last = elementToAdd;
            } else {
                elementToAdd.setNext(this.first);
                this.first = elementToAdd;
            }
        } else {}
    }
    @Override
    public void add(T value) {
        addToTheEnd(value);
    }

    @Override
    public T get(int posicion) {
        T valor_a_devolver= null;
        int posicion_actual = 0;
        Nodo<T> nodo_actual = this.first;
        while (nodo_actual != null && posicion_actual != posicion) {
            nodo_actual = nodo_actual.getNext();
            posicion_actual++;
        }
        if(posicion_actual == posicion){
            valor_a_devolver = nodo_actual.getValue();
        }
        return valor_a_devolver;
    }

    @Override
    public boolean contains(T value) {
        boolean contiene= false;
        Nodo<T> nodo_actual = this.first;
        while (nodo_actual != null && !nodo_actual.getValue().equals(value)) {
            nodo_actual = nodo_actual.getNext();
        }
        if(nodo_actual!=null){
            contiene = true;
        }
        return contiene;
    }

    @Override
    public void remove(T value) {
        Nodo<T> nodo_anterior = null;
        Nodo<T> nodo_actual = this.first;
        while (nodo_actual != null && !nodo_actual.getValue().equals(value)) {
            nodo_anterior = nodo_actual;
            nodo_actual = nodo_actual.getNext();
        }
        if(nodo_actual!=null){
            if (nodo_actual == this.first && nodo_actual != this.last) {

                Nodo<T> temp = this.first;
                this.first = this.first.getNext();

                temp.setNext(null);

            } else if (nodo_actual == this.last && nodo_actual != this.first) {

                nodo_anterior.setNext(null);
                this.last = nodo_anterior;
            } else if (nodo_actual == this.last && nodo_actual == this.first) {

                this.first = null;
                this.last = null;

            } else {

                nodo_anterior.setNext(nodo_actual.getNext());
                nodo_actual.setNext(null);

            }

        } else {

        }
        }


    @Override
    public void enqueue(T value) {
        addToTheEnd(value);

    }
    private T removeLast() { // esta operación remueve el último elemento y retorna el elemento eliminado
        T valueToRemove = null;

        if (this.last != null) {
            valueToRemove = this.last.getValue();

            remove(valueToRemove);
        }

        return valueToRemove;}

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.first == null) {
            throw new EmptyQueueException();
        }
        return removeLast();
    }


    @Override
    public void push(T value) {
        addToTheEnd(value);
    }

    @Override
    public T pop() throws EmptyStackException {
        if (this.last == null) {
            throw new EmptyStackException();
        }
        //es removeLast porque el último elemento es el que se agrega al final?
        return removeLast();

    }

    @Override
    public T peek() {
    T valueToPeek = null;
    if (this.last != null) {
        valueToPeek = this.last.getValue();

    }
        return valueToPeek;
    }

    @Override
    public int size() {
        int size= 0;
        Nodo<T> nodo_actual = this.first;
        while (nodo_actual != null) {
            nodo_actual = nodo_actual.getNext();
            size++;
        }
        return size;
    }
    @Override
    public boolean isEmpty() {
        boolean empty= false;
        if(this.first==null){
            empty=true;
        }
        return empty;
    }
    @Override
    public T top() throws EmptyStackException {
        if (this.last == null) {
            throw new EmptyStackException();
        }
        return this.last.getValue();
    }

}
