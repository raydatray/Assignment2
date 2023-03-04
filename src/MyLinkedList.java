public abstract class MyLinkedList<E> implements myList<E> {
    protected int size;
    public MyLinkedList(){ this.size = 0; }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

}
