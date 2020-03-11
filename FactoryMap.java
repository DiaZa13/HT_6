
public class FactoryMap<K,V>  {

	//Should implement the case code
	
	public AbstractMap<K,V> getInitialization(String num){
		
		switch(num) {
			case "1":
				return new Hash_Map();
			case "2":
				return new Tree_Map();
			case "3": 
				return new LinkedHash_Map();				
		}
		return null;
	}
}
