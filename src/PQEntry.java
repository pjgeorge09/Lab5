
public class PQEntry<K, V> implements Entry<K,V>{

	
	private K key;
	private V value;
	
	public PQEntry(K aKey, V aValue) {
		key = aKey;
		value = aValue;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "K: " + key.toString() + " V: " + value.toString();
	}

}
