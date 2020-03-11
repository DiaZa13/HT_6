import java.util.*;

public class Tree_Map<K,V> implements InterMap<K,V>{
	
	protected TreeMap<K, V> cards;
	
	public Tree_Map() {
		cards = new TreeMap<K,V>();
	}

	/**
	 * pushCards
	 * pre:
	 * post: adds new items to the map
	 */
	@Override
	public void pushCards(K key, V value) {
		// TODO Auto-generated method stub
		cards.put(key, value);
		
	}

	/**
	 * getCard
	 * pre: the map is full
	 * post: returns the value of the key
	 * @return value: the value of the key that the user gave
	 */
	@Override
	public V getCard(K key) {
		// TODO Auto-generated method stub
		V value;
		value = cards.get(key);
		return value;
	}

	/**
	 * getCards
	 * pre: the map is full
	 * post: returns an arraylist with all the cards on the map
	 * @return cardsArray: array with all the cards
	 */
	@Override
	public ArrayList<String> getCards() {
		// TODO Auto-generated method stub
		ArrayList<String> cardsArray = new ArrayList<String>(); 
		Iterator iterador = cards.entrySet().iterator();
    	//Iterator<Map.Entry<String, Float>> iterador = listaProductos.entrySet().iterator();
		Map.Entry producto;
		while (iterador.hasNext()) {
			producto = (Map.Entry) iterador.next();
			//producto = iterador.next(); Si se usase tambien la otra linea comentada.
			cardsArray.add(producto.getKey() + "|" + producto.getValue());
			}
		
		return cardsArray;

	}

	/**
	 * searchCards
	 * pre: the map is full
	 * post: returns the key if this is on the map
	 * @return vKey: the key that the user gave
	 */
	@Override
	public K searchCards(K key) {
		K vkey = null;
		// TODO Auto-generated method stub
		   if (cards.containsKey(key)) {
			   vkey = key;
		   }

		return vkey;
	}

	/**
	 * getOrderCards
	 * pre: the map is full and disorded
	 * post: returns an arraylist with all the cards order by type
	 * @returns hechizo: array with the order cards
	 */
	@Override
	public ArrayList getOrdercards() {
		// TODO Auto-generated method stub
		ArrayList<String> hechizo = new ArrayList<String>(); 
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Hechizo")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Trampa")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Monstruo")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		return hechizo;
	}

	/**
	 * Empty
	 * pre:
	 * post: returns if the map is empty
	 * @return 
	 */
	@Override
	public boolean Empty() {
		// TODO Auto-generated method stub
		return cards.isEmpty();
	}

	/**
	 * cantCards
	 * pre: the map is full
	 * post: returns the quantity of each type of the cards on the map
	 * @return cant
	 */
	@Override
	public int cantCards(int type) {
		// TODO Auto-generated method stub
		int contMonster = 0;
		int contHechizo = 0;
		int contTrampa = 0;
		int cant = 0;
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Hechizo")) {
				contHechizo += 1;
				}
		}
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Trampa")) {
				contTrampa +=1;
				}
		}
		
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Monstruo")) {
				contMonster +=1;
				}
		}

		if(type == 0)
			cant = contHechizo;
		else if(type == 1)
			cant = contTrampa;
		else
			cant = contMonster;
		return cant;
	}

	
}
