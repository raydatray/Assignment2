package assignment2;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
	private DNode head;
	private DNode tail;
	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;
		public DNode(E element) { this.element = element; }
	}
	public MyDoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	//Create a new node and stick it at the end of the list
	//Set new node's next as null
	//Set new node's prev as the current tail
	//Set current tail's next as the new node
	//Set tail to new node
	public boolean add(E element) {
		DNode newNode = new DNode(element);
		newNode.next = null;
		newNode.prev = this.tail;
		this.tail.next = newNode;
		this.tail = newNode;
		size++;
		return true;
	}

	//Remove the last node
	//Grab last node in a temp node
	//Update node before it's next field to null
	//Update LL's tail field to new last node
	public E remove() {
		if (this.isEmpty()){
			throw new NoSuchElementException("The list is empty");
		} else {
			DNode returnElement = this.tail;
			this.tail.prev.next = null;
			this.tail = this.tail.prev;
			size--;
			return returnElement.element;
		}
	}

	public boolean addFirst(E element) {
		DNode newNode = new DNode(element);
		newNode.next = this.head;
		this.head.prev = newNode;
		this.head = newNode;
		size++;
		return true;
	}
	public E removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The list is empty");
		} else {
			DNode returnElement = this.head;
			this.head.next.prev = null;
			this.head = this.head.next;
			size--;
			return returnElement.element;
		}
	}
	//??? is this not just add?
	public boolean addLast(E element) { return add(element); }
	///??? is this not just remove?
	public E removeLast() { return remove(); }
	public E peekFirst(){
		if(this.isEmpty()) {
			throw new NoSuchElementException("The list is empty");
		} else {
			return this.head.element;
		}
	}
	public E peekLast(){
		if(this.isEmpty()) {
			throw new NoSuchElementException("The list is empty");
		} else {
			return this.tail.element;
		}
	}
	//Lazy way: Just void head and tail
	//Real way: iterate thru the entire list and break the links
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		} else if (!(o instanceof MyDoublyLinkedList)) {
			return false;
		} else {
			MyDoublyLinkedList<E> that = (MyDoublyLinkedList<E>) o;

			if (!(that.getSize() == this.getSize())) { return false; }

			Iterator<E> thisitr = this.iterator();
			Iterator<E> thatitr = that.iterator();

			while(thisitr.hasNext() && thatitr.hasNext()) {
				if(thisitr.next() != thatitr.next()){
					return false;
				}
			}
			return true;
		}
	}
	public Iterator<E> iterator() {
		return new DLLIterator();
	}
	private class DLLIterator implements Iterator<E> {
		DNode curr;
		public DLLIterator() {
			this.curr = head;
		}
		public boolean hasNext() {
			return this.curr != null;
		}
		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();
			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
	private void printList(){
		DNode curr = this.head;
		System.out.println("Length: " + this.getSize() + ", Head pointer: " + this.head + ", Tail pointer: "+ this.tail);

		while(curr.next != null) {
			System.out.println("Element: " + curr.element + ", Back pointer: " + curr.prev + ", Forward Pointer: " + curr.next);
			curr = curr.next;
		}
	}

	public void main(String[] args){
		MyDoublyLinkedList<Integer> list1 = new MyDoublyLinkedList<Integer>();
		MyDoublyLinkedList<Integer> list2 = new MyDoublyLinkedList<Integer>();
		MyDoublyLinkedList<String> list3 = new MyDoublyLinkedList<String>();

		list1.add(1);
		list1.addFirst(2);

		list1.printList();
	}
}
