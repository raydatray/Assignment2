package assignment2;
interface myList<E> extends Iterable<E> {
    public int getSize();
    public boolean isEmpty();
    public boolean add(E e);
    public E remove();
    public void clear();
}
