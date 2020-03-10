import java.util.Map;
import java.util.Set;

public interface InterMap<K,V> {
	
	public void pushCards(K key, V value);
	public V getCard(K key);
	public Set getCards();
	public K searchCards(K key);
	public Set getOrdercards();


}
