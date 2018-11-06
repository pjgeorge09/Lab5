
public class Node<G> {
	//Instance Variables
			private G element;
			private Node<G> next;
			//Parameterized Constructor
			public Node(G anElement, Node<G> nextNode) {
				element = anElement;
				next = nextNode;
			}
			//Getters and setters
			public G getElement() {
				return element;
			}
			
			public void setElement(G anElement) {
				element = anElement;
			}
			
			public Node<G> getNextNode(){
				return next;
			}
			
			public void setNextNode(Node<G> nextNode) {
				next = nextNode;
			}
			
			public String toString() {
				return element.toString();
			}
		}
		
