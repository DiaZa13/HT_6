import java.util.*;

public interface InterMap<K,V> {
	
	public void pushCards(K key, V value);
	public V getCard(K key);
	public ArrayList getCards();
	public K searchCards(K key);
	public ArrayList getOrdercards();
	public int cantCards(int type);
	public boolean Empty();

}
