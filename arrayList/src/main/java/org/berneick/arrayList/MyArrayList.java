package org.berneick.arrayList;

import java.util.Arrays;

public class MyArrayList<E> implements Cloneable {
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
        if(index >= size_ || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
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

    public void clear() {
        for(Object element : elements) {
            element = null;
        }
        size_ = 0;
    }

    @Override
    public Object clone() {
        try {
            MyArrayList cloned = (MyArrayList) super.clone();
            cloned.elements = Arrays.copyOf(this.elements, this.elements.length);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size_; i++) {
            if(elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    private void reallocate() {
        capacity_ = (int)(capacity_ * 1.5) + 1;
        Object[] newPlace = new Object[capacity_];
        System.arraycopy(elements, 0, newPlace, 0, size_);
        elements = newPlace;
    }
}
