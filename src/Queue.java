
public class Queue<E> {

	private SinglyLinkedList<E> linkedList;
	
	public Queue() {
		linkedList = new SinglyLinkedList<E>();
	}
	
	public int size() {
		return linkedList.getSize();
	}
	
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	public E first() {
		if(isEmpty() == true) {
			return null;
		}
		else {
			return linkedList.getFirst();
		}
	}
	
	public E dequeue() {
		if(isEmpty() == true) {
			return null;
		}
		else {
			return linkedList.removeFirst();
		}
	}
	
	public void enqueue(E anElement) {
		linkedList.addLast(anElement);
	}
	
	public String toString() {
		return linkedList.toString();

	}
}
