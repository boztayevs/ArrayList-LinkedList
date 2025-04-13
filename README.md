# Custom Data Structures in Java

This project demonstrates custom implementations of key data structures in Java without using `java.util.*` (except for `Iterator`). It includes both physical (low-level) and logical (abstract) data structures, all thoroughly tested in the `Main` class.

## Project Structure

### Interfaces
- **MyList<T>** – A custom interface representing a basic list API.

### Physical Data Structures
- **MyArrayList<T>** – Array-based list implementation.
- **MyLinkedList<T>** – Doubly linked list implementation.

### Logical Data Structures
- **MyStack<T>** – LIFO stack using `MyArrayList`.
- **MyQueue<T>** – FIFO queue using `MyLinkedList`.
- **MyMinHeap<T extends Comparable<T>>** – Minimum heap using `MyArrayList`.

## Usage
Run the `Main` class to test all implemented data structures. Each structure has full functionality: add, remove, get, size, clear, etc.

## GitHub Usage Guidelines
- **Version control** should be used actively.
- **Commit messages** should be meaningful, descriptive, and done in small steps (at least 5 commits).
- Example commits:
  - `feat: implement MyArrayList with basic operations`
  - `test: add Main test cases for MyLinkedList`
  - `fix: correct index logic in MyArrayList add method`
  - `feat: add MyMinHeap and heapify operations`
  - `docs: create README and add code comments`

## Documentation Standards
- Code is commented for clarity.
- This README explains structure, usage, and purpose.

## Author Notes
This implementation is educational and demonstrates how foundational data structures work under the hood. Great care has been taken to avoid infinite loops, handle edge cases, and ensure performance and correctness.

---

Happy coding! 🚀

