
public class SinglyLinkedList<E> {
	//Instance Variables
			private Node<E> head;
			private Node<E> tail;
			private int size;
			//Default Constructor
			public SinglyLinkedList() {
				size = 0;
			}
			//Getter methods
			public int getSize() {
				return size;
			}
			public boolean isEmpty() {
				boolean toReturn = false;
				if(size == 0) {
					toReturn = true;
				}
				return toReturn;
			}
			public E getFirst() {
				if(isEmpty() == true) {
					return null;
				}
				else {
					return head.getElement();
				}
			}
			public E getLast() {
				if(isEmpty() == true) {
					return null;
				}
				else {
					return tail.getElement();
				}
			}
			
			public String toString() {
				String result = "";
				Node<E> aNode = head;
				if(aNode != null) {
					result = aNode.toString() + " , " + result;
					while(aNode.getNextNode() != null) {
						aNode = aNode.getNextNode();
						result = aNode.toString() + " , " + result;
			
					}
				}
				result = "[" + result + "]";
				return result;
			}
			
			//Setter methods	
			public void addLast(E anElement) {
				//Create a new node with the given element. Because this is the last node in the linked list, we set the value of the new nodes next node 
				//to null, as there is no next node
				Node<E> newNode = new Node<E>(anElement,null);
				//If the linked list is empty we make the new node the head node because it will be both the head and the tail node. 
				if(isEmpty() == true) {
					head = newNode;
				}
				else {
					//If the linked list has nodes in it already, we link the new node to the current tail of our linked list
					tail.setNextNode(newNode);
				}
				//We update the tail and size instance variables 
				tail = newNode;
				size++;
			}

			public E removeFirst() {
				if(isEmpty() == true) {
					return null;
				}
				else {
					E toReturn = head.getElement();
					head = head.getNextNode();
					size--;
					if(size == 0) {
						tail = head;
					}
					return toReturn;
				}
			}
			
		
}
