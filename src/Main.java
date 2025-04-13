public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(1, 15);
        System.out.println("MyArrayList: " + java.util.Arrays.toString(arrayList.toArray()));

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.addFirst("Start");
        linkedList.addLast("End");
        linkedList.remove(1);
        System.out.println("MyLinkedList: " + java.util.Arrays.toString(linkedList.toArray()));

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack top: " + stack.peek());
        stack.pop();
        System.out.println("Stack after pop: " + java.util.Arrays.toString(stack.toArray()));

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        System.out.println("Queue front: " + queue.peek());
        queue.dequeue();
        System.out.println("Queue after dequeue: " + java.util.Arrays.toString(queue.toArray()));

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(50);
        heap.insert(20);
        heap.insert(30);
        heap.insert(10);
        heap.insert(40);
        System.out.println("MinHeap peek: " + heap.peek());
        heap.extractMin();
        System.out.println("MinHeap after extractMin: " + java.util.Arrays.toString(heap.toArray()));
    }
}
