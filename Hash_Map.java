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
	public Set getCards() {
		// TODO Auto-generated method stub
		Set<String> cardsSet = new HashSet<String>(); 
		
		Iterator iterador = cards.entrySet().iterator();
    	//Iterator<Map.Entry<String, Float>> iterador = listaProductos.entrySet().iterator();
		Map.Entry producto;
		while (iterador.hasNext()) {
			producto = (Map.Entry) iterador.next();
			//producto = iterador.next(); Si se usase tambien la otra linea comentada.
			cardsSet.add(producto.getKey() + " - " + producto.getValue());
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
	public Set getOrdercards() {
		// TODO Auto-generated method stub
		Set<String> order = new HashSet<String>(); 
		Map<K,V> sorted = new TreeMap();
		sorted.putAll(cards);
		for(Map.Entry m:sorted.entrySet())
			order.add(m.getKey()+"|"+m.getValue()); 
		return order;
	}


	@Override
	public Set getMonstruo() {
		// TODO Auto-generated method stub
		Set<String> monstruo = new HashSet<String>(); 
		for(Map.Entry m:cards.entrySet()) {
			if (cards.containsValue("Monstruo")) {
				monstruo.add(m.getKey()+"|"+m.getValue()); 
				contMonster += 1;
			}else
				monstruo.add("No hay ninguna carta de tipo monstruo en la coleccion");
		}
		
		return monstruo;
	}


	@Override
	public Set getHechizo() {
		// TODO Auto-generated method stub
		Set<String> hechizo = new HashSet<String>(); 
		for(Map.Entry m:cards.entrySet()) {
			if (cards.containsValue("Hechizo")) {
				hechizo.add(m.getKey()+"|"+m.getValue()); 
				contHechizo += 1;
			}else
				hechizo.add("No hay ninguna carta de tipo hechizo en la coleccion");
		}
		
		return hechizo;
	}


	@Override
	public Set getTrampa() {
		// TODO Auto-generated method stub
		Set<String> trampa = new HashSet<String>(); 
		for(Map.Entry m:cards.entrySet()) {
			if (cards.containsValue("Trampa")) {
				trampa.add(m.getKey()+"|"+m.getValue()); 
				contTrampa += 1;
			}else
				trampa.add("No hay ninguna carta de tipo trampa en la coleccion");
		}
		
		return trampa;
	}


	@Override
	public boolean Empty() {
		// TODO Auto-generated method stub
		return cards.isEmpty();
	}


	@Override
	public int cantCards(int type) {
		// TODO Auto-generated method stub
		int [] cant = new int[3];
		int cantidad = 0;
		cant[0] = contMonster;
		cant[1] = contHechizo;
		cant[2] = contTrampa;
		if(type == 0)
			cantidad = cant[0];
		else if(type == 1)
			cantidad = cant[1];
		else
			cantidad = cant[2];
		return cantidad;
	}




	
}
