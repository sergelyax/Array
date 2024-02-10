package org.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Расширяемый список с быстрой сортировкой на основе массива.
 *
 * @param <T> Тип элементов в этом списке
 */
public class ArrayList<T> implements ListManager.MyList<T> {
    private T[] array;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int MULTIPLIER = 2;
    private int lastPosition = 0;

    /**
     * Создает пустой список с начальной вместимостью DEFAULT_CAPACITY.
     */
    public ArrayList() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Создает пустой список с указанной начальной вместимостью.
     *
     * @param capacity начальная вместимость списка
     * @throws IllegalArgumentException если указанная начальная емкость меньше или равна нулю
     */
    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Неверная емкость: " + capacity);
        }
        this.array = (T[]) new Object[capacity];
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element добавляемый элемент
     */
    public void add(T element) {
        if (lastPosition >= array.length) {
            growArray();
        }
        array[lastPosition] = element;
        lastPosition++;
    }

    /**
     * Вставляет элемент в указанную позицию в списке.
     *
     * @param index   позиция для вставки
     * @param element вставляемый элемент
     */
    public void insert(int index, T element) {
        if (index == lastPosition) {
            add(element);
            return;
        }
        checkBounds(index);
        if (lastPosition + 1 >= array.length) {
            growArray();
        }
        System.arraycopy(array, index, array, index + 1, lastPosition - index);
        array[index] = element;
        lastPosition++;
    }

    /**
     * Заменяет элемент в позиции в списке новым элементом.
     *
     * @param index   позиция элемента
     * @param element новый элемент
     * @return элемент, который был на позиции index до замены
     */
    public T set(int index, T element) {
        checkBounds(index);
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    /**
     * Удаляет элемент на указанной позиции в списке.
     *
     * @param index позиция удаляемого элемента
     * @return удаленный элемент
     */
    public T remove(int index) {
        checkBounds(index);
        T element = array[index];
        System.arraycopy(array, index + 1, array, index, lastPosition - index - 1);
        lastPosition--;
        array[lastPosition] = null;
        return element;
    }

    /**
     * Удаляет первое вхождение элемента из списка, если он присутствует.
     *
     * @param removedElement элемент, который нужно удалить из списка
     * @return true, если элемент был удален из списка, иначе false
     */
    public boolean remove(T removedElement) {
        boolean result = false;
        if (removedElement == null) {
            for (int i = 0; i < lastPosition; i++) {
                if (array[i] == null) {
                    remove(i);
                    result = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < lastPosition; i++) {
                if (removedElement.equals(array[i])) {
                    remove(i);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Возвращает элемент на указанной позиции в списке.
     *
     * @param index позиция элемента
     * @return элемент на указанной позиции
     */
    public T get(int index) {
        checkBounds(index);
        return array[index];
    }

    /**
     * Очищает список, удаляя все его элементы.
     */
    public void clear() {
        Arrays.fill(array, null);
        lastPosition = 0;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return lastPosition;
    }

    /**
     * Сортирует список в соответствии с заданным компаратором.
     *
     * @param comparator компаратор для сортировки элементов
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort(0, lastPosition - 1, comparator);
    }

    private void quickSort(int low, int high, Comparator comparator) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        T pivot = array[middle];

        int leftBound = low;
        int rightBound = high;
        while (leftBound <= rightBound) {
            while (comparator.compare(array[leftBound], pivot) < 0) {
                leftBound++;
            }
            while (comparator.compare(array[rightBound], pivot) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                T temp = array[leftBound];
                array[leftBound] = array[rightBound];
                array[rightBound] = temp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, comparator);
        }
        if (high > leftBound) {
            quickSort(leftBound, high, comparator);
        }
    }

    private void growArray() {
        long newCapacity = array.length * MULTIPLIER;
        if (newCapacity > Integer.MAX_VALUE) {
            newCapacity = Integer.MAX_VALUE;
        }

        T[] newArray = (T[]) new Object[(int) newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, array.length);
        this.array = newArray;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= lastPosition) {
            throw new IndexOutOfBoundsException(String.format("Индекс: %d, Размер: %d", index, lastPosition));
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, lastPosition));
    }
}
