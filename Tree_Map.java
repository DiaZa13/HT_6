import java.util.Set;
import java.util.TreeMap;

public class Tree_Map<K,V> extends AbstractMap<K,V>{
	
	protected TreeMap<K, V> data;
	
	public Tree_Map() {
		data = new TreeMap<K,V>();
	}

	@Override
	public void pushCards(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V getCard(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K searchCards(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getOrdercards() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
