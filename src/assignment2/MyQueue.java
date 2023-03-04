package assignment2;

public class MyQueue<E> {
    //Queue using DLL
    //Enqueue from the back, Dequeue from the front
    private MyDoublyLinkedList<E> queue;
    public MyQueue() {
        this.queue = new MyDoublyLinkedList<E>();
    }
    public boolean enqueue(E element) {
        return this.queue.addLast(element);
    }
    public E dequeue() {
        return this.queue.removeFirst();
    }
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
    public void clear() { this.queue.clear(); }
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof MyQueue)){
            return false;
        } else {
            return this.equals(o);
        }
    }
}
