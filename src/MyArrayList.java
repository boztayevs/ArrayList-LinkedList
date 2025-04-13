import java.util.Iterator;
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
    }
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
    }
    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }
    @Override
    public void addFirst(T item) {
        add(0, item);
    }
    @Override
    public void addLast(T item) {
        add(item);
    }
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }
    @Override
    public T getFirst() {
        return get(0);
    }
    @Override
    public T getLast() {
        return get(size - 1);
    }
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }
    @Override
    public void removeFirst() {
        remove(0);
    }
    @Override
    public void removeLast() {
        remove(size - 1);
    }
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                T b = (T) elements[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elements[i];
        }
        return result;
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            public boolean hasNext() {
                return current < size;
            }
            public T next() {
                return (T) elements[current++];
            }
        };
    }
} 
