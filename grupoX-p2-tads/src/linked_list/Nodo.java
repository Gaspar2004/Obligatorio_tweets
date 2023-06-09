package linked_list;

public class Nodo <T> {
    private T value;

        private Nodo<T> next;

        public Nodo(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Nodo<T> getNext() {
            return next;
        }

        public void setNext(Nodo<T> next) {
            this.next = next;
        }
}
