package org.berneick.arrayList;

public class MyArrayList<E> {
    private Object[] elements;
    private int size_;
    private int capacity_;

    public int size() {
        return size_;
    }

    public int capacity() {
        return capacity_;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Недопустимая начальная емкость " + capacity);
        }
        this.elements = new Object[capacity];
        this.capacity_ = capacity;
        this.size_ = 0;
    }

    public boolean isEmpty() {
        return size_ == 0;
    }

    public E get(int index) {
        return (E)elements[index];
    }

    public void add(E element) {
        if(size_ == capacity_) {
            reallocate();
        }
        elements[size_] = element;
        size_++;
    }

    public void add(int index, E element) {
        if(size_ == capacity_) {
            reallocate();
        }
        if(index > size_) {
            throw new IllegalArgumentException("Недопустимый индекс массива " + capacity_);
        }
        if(index == size_) {
            add(element);
            return;
        }
        for (int i = size_ - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size_++;
    }

    private void reallocate() {
        capacity_ = (int)(capacity_ * 1.5) + 1;
        Object[] newPlace = new Object[capacity_];
        System.arraycopy(elements, 0, newPlace, 0, size_);
        elements = newPlace;
    }
}
