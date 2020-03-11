import java.util.*;

public interface InterMap<K,V> {
	
	public void pushCards(K key, V value);//adds a new element to the map
	public V getCard(K key);//get the value of the key
	public ArrayList getCards();//show the cards in the map
	public K searchCards(K key);//look if a key is on the map
	public ArrayList getOrdercards();//show the cards in the map ordered by the type
	public int cantCards(int type);//returns the quantity of each type of the cards in the map
	public boolean Empty();//returns true is the map is empty

}
