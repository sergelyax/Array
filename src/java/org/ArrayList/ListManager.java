package org.ArrayList;
import java.util.Comparator;

public interface ListManager {
    public interface MyList<T> {
        void add(T element);
        void insert(int index, T element);
        T set(int index, T element);
        T remove(int index);
        boolean remove(T element);
        T get(int index);
        void clear();
        int size();
        void sort(Comparator<? super T> comparator);
    }

}
