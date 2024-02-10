package org.ArrayList;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        // Добавление целочисленных элементов
        integerArrayList.add(5);
        integerArrayList.add(3);
        integerArrayList.add(8);
        integerArrayList.add(2);
        integerArrayList.add(7);
        System.out.println("1-й список:\n" + integerArrayList);

        // Добавление элементов типа String
        stringArrayList.add("g");
        stringArrayList.add("d");
        stringArrayList.add("a");
        stringArrayList.add("b");
        System.out.println("2-й список:\n" + stringArrayList);




        // Вставка элемента по индексу
        integerArrayList.insert(2, 6);
        stringArrayList.insert(2, "s");
        System.out.println("списки после вставки элементов по индексу 2:\n" + integerArrayList + "\n" + stringArrayList);


        // Замена элемента по индексу
        integerArrayList.set(4, 10);
        stringArrayList.set(2, "abc");
        System.out.println("замена элементов по индексу 1 и 2:\n" + integerArrayList + "\n" + stringArrayList);

        // Удаление элемента по индексу
        integerArrayList.remove(1);
        stringArrayList.remove(2);
        System.out.println("удаление элементов по индексу 1 и 2\n" + integerArrayList + "\n" + stringArrayList);
        // Удаление первого вхождения элемента
        integerArrayList.remove(Integer.valueOf(8));

        // Получение элемента по индексу
        System.out.println("элемент 1-го списка по индексу 2: " + integerArrayList.get(2));
        System.out.println("элемент 2-го списка по индексу 2: " + stringArrayList.get(2));

        // Очистка списка
        integerArrayList.clear();
        stringArrayList.clear();
        System.out.println("списки после очистки\n" + integerArrayList + "\n" + stringArrayList);

        // Добавление элементов после очистки
        integerArrayList.add(3);
        integerArrayList.add(56);
        integerArrayList.add(3);
        integerArrayList.add(12);


        stringArrayList.add("f");
        stringArrayList.add("h");
        stringArrayList.add("v");
        stringArrayList.add("s");
        stringArrayList.add("k");

        System.out.println("создание новых списков:\n" + integerArrayList + "\n" + stringArrayList);

        // Сортировка списка
        integerArrayList.sort(Comparator.naturalOrder());
        stringArrayList.sort(Comparator.naturalOrder());

        // Вывод списка
        System.out.println("Список после сортировки:");
        for (int i = 0; i < integerArrayList.size(); i++) {
            System.out.print(integerArrayList.get(i) + " ");
        }
        System.out.println("Список 2 после сортировки:");
        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.print(stringArrayList.get(i) + " ");
        }
    }
}
