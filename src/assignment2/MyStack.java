package assignment2;

public class MyStack<E> {
    //Stack using DLL
    //Put everything in/out thru the first
    private MyDoublyLinkedList<E> stack;
    public MyStack(){
        this.stack = new MyDoublyLinkedList<E>();
    }
    public boolean push(E element) {
        return this.stack.addFirst(element);
    }
    public E pop(){
        return this.stack.removeFirst();
    }
    public E peek(){
        return this.stack.peekFirst();
    }
    public boolean isEmpty() { return this.stack.isEmpty(); }
    public void clear() {
        this.stack.clear();
    }
    public int getSize() {
        return this.stack.getSize();
    }
}
