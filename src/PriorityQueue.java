import java.util.Comparator;

public class PriorityQueue<K, V> {
	
	Queue<PQEntry<K,V>> queue;
	Comparator<K> comparator;
	
	public PriorityQueue(Comparator<K> aComparator) {
		queue = new Queue<PQEntry<K,V>>();
		comparator = aComparator;
	}
	
	public void insert(PQEntry<K,V> anEntry) {
		if(queue.size() == 0) {
			queue.enqueue(anEntry);
		}
		else {
			boolean isAdded = false;
			for(int i = queue.size(); i > 0; i--) {
				PQEntry<K,V> tempEntry = queue.dequeue();
				//If tempEntry key > anEntry key --> evaluates to true
				if(comparator.compare(tempEntry.getKey(), anEntry.getKey()) > 0 && isAdded == false) {
					queue.enqueue(anEntry);
					queue.enqueue(tempEntry);
					isAdded = true;
				}
				else {
					queue.enqueue(tempEntry);
				}				
			}
			if(isAdded == false) {
				queue.enqueue(anEntry);
			}
		}

		
	}

	public PQEntry<K,V> remove(){
		return queue.dequeue();
	}
	
	public PQEntry<K,V> min(){
		return queue.first();
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public String toString() {
		return queue.toString();
	}
}