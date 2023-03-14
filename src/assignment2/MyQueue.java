package assignment2;

public class MyQueue<E> {
    //Queue using DLL
    //Enqueue from the back, Dequeue from the front
    public MyDoublyLinkedList<E> queue; //MAKE THIS PRIVATE AGAIN
    public MyQueue() {
        this.queue = new MyDoublyLinkedList<E>();
    }
    public boolean enqueue(E element) {
        return this.queue.addLast(element);
    }
    public E dequeue() { return this.queue.removeFirst(); }
    public boolean isEmpty() { return this.queue.isEmpty(); }
    public void clear() { this.queue.clear(); }
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof MyQueue)){
            return false;
        } else {
            return this.queue.equals(((MyQueue) o).queue);
        }
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue1 = new MyQueue<Integer>();
        MyQueue<String> queue2 = new MyQueue<String>();
        MyQueue<Integer> queue3 = new MyQueue<Integer>();

        System.out.println("Is your a queue using a DLL?: " + (queue1.queue instanceof MyDoublyLinkedList<Integer>));
        System.out.println("Enqueuing 1,2,3 to queue1 and a,b,c to queue2. 1/a at head, 3/c at tail");
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue2.enqueue("a");
        queue2.enqueue("b");
        queue2.enqueue("c");
        System.out.println("queue1");
        queue1.queue.printList();
        System.out.println("queue2");
        queue2.queue.printList();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Dequeueing from list1, Expected: 1");
        System.out.println("Element Dequeued: " + queue1.dequeue());
        queue1.queue.printList();
        System.out.println("Is queue1 empty? (obviously not.)");
        System.out.println(".isEmpty() queue1: " + queue1.isEmpty());
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Checking for equality queue1 to queue2. Expected: False");
        System.out.println("queue1.equals(queue2)?: " + queue1.equals(queue2));
        System.out.println("Creating identical queue3 to queue1. Expected: True");
        queue3.enqueue(2);
        queue3.enqueue(3);
        System.out.println("queue1.equals(queue3)?: " + queue1.equals(queue3));
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Clearing queue2");
        queue2.clear();
        System.out.println("Cleared");
        queue2.queue.printList();
        System.out.println("Trying to dequeue from queue2");
        try{
            queue2.dequeue();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
