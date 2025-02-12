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
}
