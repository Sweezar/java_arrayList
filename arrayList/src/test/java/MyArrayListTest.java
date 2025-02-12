import org.berneick.arrayList.MyArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    public void testAddAndSize() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Проверяем, что список изначально пуст
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        // Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(30);

        // Проверяем размер после добавления
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddAndCapacity() {
        MyArrayList<Double> list = new MyArrayList<>();

        // Проверяем, что список изначально пуст
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        // Добавляем элементы
        for (int i = 0; i < 6; i++) {
            list.add(10.0);
            list.add(20.0);
            list.add(30.2);
        }

        // Проверяем размер после добавления
        assertEquals(18, list.size());
        assertEquals(25, list.capacity());
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAddWithIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Проверяем, что список изначально пуст
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        // Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(1,30);
        list.add(3, 40);

        // Проверяем размер после добавления
        assertEquals(4, list.size());
        assertFalse(list.isEmpty());

        // Проверяем позиции вставленных элементов
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(40, list.get(3));
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавляем элементы
        list.add(10);

        // Проверяем размер после добавления
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());

        list.clear();

        // Проверяем размер после очистки
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testClone() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("Hello");

        MyArrayList<String> copyOfList = (MyArrayList<String>) list.clone();
        list.clear();

        assertTrue(copyOfList.get(0).equals("Hello"));
        assertFalse(copyOfList.isEmpty());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContains() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertTrue(list.contains(30));
        assertFalse(list.contains(15));
    }

    @Test
    public void testIndexOf() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(list.indexOf(20), 1);
        assertEquals(list.indexOf(10), 0);
        assertEquals(list.indexOf(15), -1);
    }

    @Test
    public void testRemoveWithIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        // Удаляем элемент
        list.remove(1);

        assertEquals(list.get(1), 30);
        assertEquals(list.size(), 5);

        // Удаляем элемент с начала
        list.remove(0);

        assertEquals(list.get(0), 30);
        assertEquals(list.size(), 4);

        // Удаляем элемент с конца
        list.remove(3) ;

        assertEquals(list.size(), 3);

        // Проверка не существующего индекса
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
    }

    @Test
    public void testRemoveWithObject() {
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        // Удаляем элемент
        assertTrue(list.remove(Integer.valueOf(20)));
        assertFalse(list.remove(Integer.valueOf(15)));

        assertEquals(list.get(1), 30);
        assertEquals(list.size(), 5);

    }

}
