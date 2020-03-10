import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Hash_Map<K,V> extends AbstractMap<K,V>{
	
	protected Map<K,V> cards;

	
	public Hash_Map() {
		cards = new HashMap<K,V>();
	}


	@Override
	public void pushCards(K key, V value) {
		// TODO Auto-generated method stub
		cards.put(key, value);
		
	}


	@Override
	public V getCard(K key) {
		// TODO Auto-generated method stub
		V value;
		value = cards.get(key);
		return value;
	}


	@Override
	public Set getCards() {
		// TODO Auto-generated method stub
		Set<String> cardsSet = new HashSet<String>(); 
		for(Map.Entry m:cards.entrySet())
			cardsSet.add(m.getKey()+"|"+m.getValue()); 
		
		return cardsSet;
	}


	@Override
	public K searchCards(K key) {
		K vkey = null;
		// TODO Auto-generated method stub
		   if (cards.containsKey(key)) {
			   vkey = key;
		   }

		return vkey;
	}


	@Override
	public Set getOrdercards() {
		// TODO Auto-generated method stub
		return null;
	}




	
}
