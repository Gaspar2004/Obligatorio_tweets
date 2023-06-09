package linked_list;

public interface linked_list_interface<T> {
        void add(T value);

        T get(int posicion);

        boolean contains(T value);

        void remove(T value);

        int size();

    }

