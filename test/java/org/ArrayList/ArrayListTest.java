package org.ArrayList;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.*;

/**
 * JUnit тесты для класса ArrayList.
 */
public class ArrayListTest {
    private ArrayList<Integer> integerArrayList;
    private ArrayList<String> stringArrayList;

    /**
     * Настройка перед каждым тестом.
     */
    @Before
    public void setUp() {
        integerArrayList = new ArrayList<>();
        stringArrayList = new ArrayList<>();
    }

    /**
     * Тест для метода add.
     */
    @Test
    public void testAdd() {
        // Проверка добавления целочисленных элементов
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        assertEquals(3, integerArrayList.size());
        assertEquals(Integer.valueOf(5), integerArrayList.get(0));
        assertEquals(Integer.valueOf(3), integerArrayList.get(1));
        assertEquals(Integer.valueOf(8), integerArrayList.get(2));

        // Проверка добавления элементов типа String
        stringArrayList.add("a");
        stringArrayList.add("b");
        assertEquals(2, stringArrayList.size());
        assertEquals("a", stringArrayList.get(0));
        assertEquals("b", stringArrayList.get(1));
    }

    /**
     * Тест для метода insert.
     */
    @Test
    public void testInsert() {
        // Проверка вставки элементов по индексу
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.insert(1, 10);
        assertEquals(3, integerArrayList.size());
        assertEquals(Integer.valueOf(10), integerArrayList.get(1));

        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList.insert(1, "c");
        assertEquals(3, stringArrayList.size());
        assertEquals("c", stringArrayList.get(1));
    }

    /**
     * Тест для метода set.
     */
    @Test
    public void testSet() {
        // Проверка замены элементов по индексу
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        integerArrayList.set(1, 10);
        assertEquals(3, integerArrayList.size());
        assertEquals(Integer.valueOf(10), integerArrayList.get(1));

        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList.set(1, "c");
        assertEquals(2, stringArrayList.size());
        assertEquals("c", stringArrayList.get(1));
    }

    /**
     * Тест для метода remove (по индексу).
     */
    @Test
    public void testRemoveByIndex() {
        // Проверка удаления элементов по индексу
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        assertEquals(Integer.valueOf(3), integerArrayList.remove(1));
        assertEquals(2, integerArrayList.size());

        stringArrayList.add("a");
        stringArrayList.add("b");
        assertEquals("a", stringArrayList.remove(0));
        assertEquals(1, stringArrayList.size());
    }

    /**
     * Тест для метода remove (по значению).
     */
    @Test
    public void testRemoveByValue() {
        // Проверка удаления элементов по значению
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        assertTrue(integerArrayList.remove(Integer.valueOf(3)));
        assertFalse(integerArrayList.remove(Integer.valueOf(10)));

        stringArrayList.add("a");
        stringArrayList.add("b");
        assertTrue(stringArrayList.remove("a"));
        assertFalse(stringArrayList.remove("c"));
    }

    /**
     * Тест для метода get.
     */
    @Test
    public void testGet() {
        // Проверка получения элементов по индексу
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        assertEquals(Integer.valueOf(5), integerArrayList.get(0));
        assertEquals(Integer.valueOf(3), integerArrayList.get(1));
        assertEquals(Integer.valueOf(8), integerArrayList.get(2));

        stringArrayList.add("a");
        stringArrayList.add("b");
        assertEquals("a", stringArrayList.get(0));
        assertEquals("b", stringArrayList.get(1));
    }

    /**
     * Тест для метода clear.
     */
    @Test
    public void testClear() {
        // Проверка очистки списка
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        integerArrayList.clear();
        assertEquals(0, integerArrayList.size());

        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList.clear();
        assertEquals(0, stringArrayList.size());
    }

    /**
     * Тест для метода size.
     */
    @Test
    public void testSize() {
        // Проверка получения размера списка
        assertEquals(0, integerArrayList.size());
        integerArrayList.add(5);
        integerArrayList.add(3);
        assertEquals(2, integerArrayList.size());

        assertEquals(0, stringArrayList.size());
        stringArrayList.add("a");
        stringArrayList.add("b");
        assertEquals(2, stringArrayList.size());
    }

    /**
     * Тест для метода sort.
     */
    @Test
    public void testSort() {
        // Проверка сортировки списка
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        integerArrayList.sort(Comparator.naturalOrder());
        assertEquals(Integer.valueOf(3), integerArrayList.get(0));
        assertEquals(Integer.valueOf(5), integerArrayList.get(1));
        assertEquals(Integer.valueOf(8), integerArrayList.get(2));

        stringArrayList.add("b");
        stringArrayList.add("c");
        stringArrayList.add("a");
        stringArrayList.sort(Comparator.naturalOrder());
        assertEquals("a", stringArrayList.get(0));
        assertEquals("b", stringArrayList.get(1));
        assertEquals("c", stringArrayList.get(2));
    }
}
