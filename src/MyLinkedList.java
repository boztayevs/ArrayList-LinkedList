import java.util.Iterator;
public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
    }
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index out of bounds");
    }
    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }
    @Override
    public void add(T item) {
        addLast(item);
    }
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == 0) addFirst(item);
        else if (index == size) addLast(item);
        else {
            MyNode nextNode = getNode(index);
            MyNode prevNode = nextNode.prev;
            MyNode newNode = new MyNode(item);
            newNode.next = nextNode;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
    }
    @Override
    public void set(int index, T item) {
        getNode(index).data = item;
    }
    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        head = newNode;
        if (tail == null) tail = head;
        size++;
    }
    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        newNode.prev = tail;
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = tail;
        size++;
    }
    @Override
    public T get(int index) {
        return getNode(index).data;
    }
    @Override
    public T getFirst() {
        return head.data;
    }
    @Override
    public T getLast() {
        return tail.data;
    }
    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode nodeToRemove = getNode(index);
        MyNode prevNode = nodeToRemove.prev;
        MyNode nextNode = nodeToRemove.next;
        if (prevNode != null) prevNode.next = nextNode;
        else head = nextNode;
        if (nextNode != null) nextNode.prev = prevNode;
        else tail = prevNode;
        size--;
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
        if (size < 2) return;
        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) current.data;
                T b = current.next.data;
                if (a.compareTo(b) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }
    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(object)) return i;
            current = current.next;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(object)) return i;
            current = current.prev;
        }
        return -1;
    }
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
} 
