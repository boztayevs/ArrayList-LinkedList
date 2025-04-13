public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }
    public void insert(T item) {
        heap.addLast(item);
        heapifyUp(heap.size() - 1);
    }
    public T extractMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        T min = heap.get(0);
        T last = heap.getLast();
        heap.set(0, last);
        heap.removeLast();
        heapifyDown(0);
        return min;
    }
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }
    public boolean isEmpty() {
        return heap.size() == 0;
    }
    public int size() {
        return heap.size();
    }
    public void clear() {
        heap.clear();
    }
    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = heap.get(index);
            T parent = heap.get(parentIndex);
            if (current.compareTo(parent) < 0) {
                heap.set(index, parent);
                heap.set(parentIndex, current);
                index = parentIndex;
            } else break;
        }
    }
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;
            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                T temp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, temp);
                index = smallest;
            } else break;
        }
    }
    public Object[] toArray() {
        return heap.toArray();
    }
} 
