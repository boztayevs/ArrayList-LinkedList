public class MyQueue<T> {
    private MyLinkedList<T> list;
    public MyQueue() {
        list = new MyLinkedList<>();
    }
    public void enqueue(T item) {
        list.addLast(item);
    }
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
    public void clear() {
        list.clear();
    }
    public Object[] toArray() {
        return list.toArray();
    }
} 
