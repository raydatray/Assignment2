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
		public DNode(E element) { this.element = element; this.prev = null; this.next = null; }
	}
	public MyDoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	public boolean add(E element) {
		DNode newNode = new DNode(element);
		if (this.getSize() == 0 ){
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		size++;
		return true;
	}

	public E remove() {
		if (this.isEmpty()){
			throw new NoSuchElementException("The list is empty");
		} else {
			DNode returnElement = this.tail;
			if(this.getSize() == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail.prev.next = null;
				this.tail = this.tail.prev;
			}
			size--;
			return returnElement.element;
		}
	}

	public boolean addFirst(E element) {
		DNode newNode = new DNode(element);
		if (this.getSize() == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		size++;
		return true;

	}
	public E removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("The list is empty");
		} else {
			DNode returnElement = this.head;
			if(this.getSize() == 1){
				this.head = null;
				this.tail = null;
			} else {
				this.head.next.prev = null;
				this.head = this.head.next;
			}
			size--;
			return returnElement.element;
		}
	}
	public boolean addLast(E element) { return add(element); }
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
	public void printList(){
		DNode curr = this.head;
		System.out.println("Length: " + this.getSize() + ", Head pointer: " + this.head + ", Tail pointer: "+ this.tail);

		for(int i = 0; i < this.getSize(); i++) {
			System.out.println("Element: " + curr.element + ", Back pointer: " + curr.prev + ", Forward Pointer: " + curr.next);
			curr = curr.next;
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	public static void main(String[] args){
		MyDoublyLinkedList<Integer> list1 = new MyDoublyLinkedList<Integer>();
		MyDoublyLinkedList<Integer> list2 = new MyDoublyLinkedList<Integer>();
		MyDoublyLinkedList<String> list3 = new MyDoublyLinkedList<String>();

		System.out.println("check your pointer addresses. carefully.");

		System.out.println("Initializing list1, testing add, remove");
		System.out.println("Adding element 1 using .add()");
		list1.add(1);
		System.out.println("Adding element 2 using .addFirst()");
		list1.addFirst(2);
		System.out.println("Adding element 3 using .addLast()");
		list1.addLast(3);
		list1.printList();
		System.out.println("List: 2 > 1 > 3");
		System.out.println("Removing element 2 using .removeFirst()");
		System.out.println(list1.removeFirst());
		list1.printList();
		System.out.println("Removing element 3 using .removeLast()");
		System.out.println(list1.removeLast());
		list1.printList();
		System.out.println("Removing element 1 using .remove()");
		System.out.println(list1.remove());
		list1.printList();

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		System.out.println("Playing peekaboo (Testing peeks). List1: Empty. List2: 1,2. List3: hi,bye.");
		list2.add(1);
		list2.add(2);
		list3.add("hi");
		list3.add("bye");
		list2.printList();
		list3.printList();
		System.out.println("Peeking first on list2: " + list2.peekFirst());
		System.out.println("Peeking last on list3: " + list2.peekLast());
		System.out.println("Trying to peek on empty list1");
		System.out.println(".peekFirst()");
		try{
			list1.peekFirst();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(".peekLast()");
		try{
			list1.peekLast();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Clearing list 2");
		list2.clear();
		list2.printList();

		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		System.out.println("Checking for parity with .equals");
		System.out.println("Creating list1&2: 1,2,3,4,5,6. Expected output: True");
		System.out.println("If you've gotten to here your thing probably works, will not print the addresses");
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		System.out.println("Calling equals on list2 from list 1: " + list1.equals(list2));
		System.out.println("Calling equals on list1 from list 2: " + list2.equals(list1));
		System.out.println("Removing 6 from list 2. Expected output: False");
		list2.remove();
		System.out.println("Calling equals on list2 from list 1: " + list1.equals(list2));
		System.out.println("Calling equals on list1 from list 2: " + list2.equals(list1));
		System.out.println("Checking across two different element types (list 1: int, list 3: string) Expected: False");
		System.out.println("Calling equals on list3 from list 1: " + list1.equals(list3));
		System.out.println("Calling equals on list1 from list 3: " + list3.equals(list1));
	}
}
