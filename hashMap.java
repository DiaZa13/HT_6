import java.util.*;

public class hashMap {
	
	HashMap<String,Float> totalCards = new HashMap<String,Float>();
	HashMap<String,Float> userCards = new HashMap<String,Float>();
	
	public void saveCards(String codigo, float precio, HashMap <String,Float> listaProductos){
	        totalCards.put(codigo, precio);               
	}
	
	public void saveUsercards(String codigo, float precio, HashMap <String,Float> listaProductos){
	        userCards.put(codigo, precio);               
	}
	
	public void showCards(HashMap<String, Float> listaProductos) {
	    String clave;
	    Iterator<String> cards = totalCards.keySet().iterator();
	    System.out.println("Las cartas existentes son:");
	    while(cards.hasNext()){
	        clave = cards.next();
	        System.out.println(clave + " - " + listaProductos.get(clave));
	    }        
	}
	
	public void showUsercards(HashMap<String, Float> listaProductos) {
	    String clave;
	    Iterator<String> uCards = userCards.keySet().iterator();
	    System.out.println("Las cartas del usuario son:");
	    while(uCards.hasNext()){
	        clave = uCards.next();
	        System.out.println(clave + " - " + listaProductos.get(clave));
	    }        
	}
	
	/*public void searchTotalcards(String valor, HashMap<String,Float> listaProductos) {
	    while(listaProductos.containsValue(valor)) {
	    	
	        
	    } else {
	        System.out.println("No hay ningun producto con ese código.");  
	    }       
	}*/ 
	
	

}
