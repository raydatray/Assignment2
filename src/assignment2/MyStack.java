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

    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<Integer>();
        System.out.println("Is your a stack using a DLL?: " + (stack.stack instanceof MyDoublyLinkedList<Integer>));
        System.out.println("Pushing 1,2,3 onto stack. 3 should be the at the head, 1 at the tail");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.stack.printList();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Checking for .getSize() and .isEmpty(). 3, false");
        System.out.println(".getSize(): " + stack.getSize());
        System.out.println(".isEmpty(): " + stack.isEmpty());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        System.out.println("Popping 3 off the stack");
        System.out.println("Element removed: " + stack.pop());
        stack.stack.printList();
        System.out.println("Peeking at 2");
        System.out.println("Peek:" + stack.peek());
        System.out.println("Clearing the stack");
        stack.clear();
        System.out.println("Cleared");
        stack.stack.printList();
        System.out.println("Trying to peek an empty stack");
        try{
            stack.peek();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Checking for .getSize() and .isEmpty(). 0, true");
        System.out.println(".getSize(): " + stack.getSize());
        System.out.println(".isEmpty(): " + stack.isEmpty());
    }
}
