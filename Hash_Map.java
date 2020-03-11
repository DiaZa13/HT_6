import java.util.*;

public class Hash_Map<K,V> extends AbstractMap<K,V>{
	
	protected Map<K,V> cards;
	protected int contMonster = 0;
	protected int contHechizo = 0;
	protected int contTrampa = 0;
	
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
	public ArrayList<String> getCards() {
		// TODO Auto-generated method stub
		ArrayList<String> cardsSet = new ArrayList<String>(); 
		Iterator iterador = cards.entrySet().iterator();
    	//Iterator<Map.Entry<String, Float>> iterador = listaProductos.entrySet().iterator();
		Map.Entry producto;
		while (iterador.hasNext()) {
			producto = (Map.Entry) iterador.next();
			//producto = iterador.next(); Si se usase tambien la otra linea comentada.
			cardsSet.add(producto.getKey() + "|" + producto.getValue());
			}
		
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
	public ArrayList getOrdercards() {
		// TODO Auto-generated method stub
		ArrayList<String> hechizo = new ArrayList<String>(); 
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Hechizo")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				contHechizo += 1;
				}
		}
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Trampa")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				contTrampa += 1;
				}
		}
		
		for(Map.Entry m:cards.entrySet()) {
			if (m.getValue().equals("Monstruo")) {
				contMonster += 1;
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				}
		}
		return hechizo;
	}


	@Override
	public boolean Empty() {
		// TODO Auto-generated method stub
		return cards.isEmpty();
	}


	@Override
	public int cantCards(int type) {
		// TODO Auto-generated method stub
		int cant = 0;
		if(type == 0)
			cant = contHechizo;
		else if(type == 1)
			cant = contTrampa;
		else
			cant = contMonster;
		return cant;
	}
	
}
