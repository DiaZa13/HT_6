import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main (String [] args) throws IOException {
		
		Scanner read = new Scanner(System.in);
		//Attributes
		String[] cards = null;
		String card, value, key = null, userKey = null,menu;//Key
		boolean tmenu;
		int last;

		//Class Ambassador (Factory Pattern)
		FactoryMap FM = new FactoryMap();
		
//-------------------------MENU PARA QUE EL USUARIO ELIGA LA IMPLEMENTACION QUE QUIERA------------------------
		System.out.println("------- JUEGO DE CARTAS ---------");
		System.out.println("Ingrese la opcion de la implementacion que desee");
		System.out.println("1. Implementacion de Map por medio de HashMap");
		System.out.println("2. Implementacion de Map por medio de TreeMap");
		System.out.println("3. Implementacion de Map por medio de LinkedHashMap");
		System.out.print("Ingrese el numero de la opcion que desee probar: ");
		menu = read.nextLine();
		tmenu = MenuInvalidoF(menu);
		while (tmenu != false) {
			System.out.print("Ingrese nuevamente el numero de la opcion que desee: ");	
			menu = read.nextLine();
			tmenu = MenuInvalidoF(menu);
		}
		//Creating the main map
		//Change to variable or can be initialized using any Map
		InterMap map = FM.getInitialization(menu);
		//Creating user's map
		InterMap user = FM.getInitialization(menu);
		
		
//Leyendo y almacenando las cartas en un map
		 //Change to variable
		BufferedReader in = new BufferedReader(new FileReader("cards_desc.txt"));

		//While the txt isn't ended
		while((card = in.readLine()) != null)
		{
			//Due to | and \| are used for control, we use \\|
			cards = card.split("\\|");
			
			//Data is submitted in the map
			for (int i = 0; i < cards.length; i++) {
				if (i%2 == 0) {
					key = cards[i];
				}else if (i%2 == 1) {
					value = cards[i];
					map.pushCards(key, value);
				}			
			}
		}
		
//-------------------------------MENU--------------------------------------------------------------------
		do {
			System.out.println("----------------------- JUEGO DE CARTAS -----------------------");
			System.out.println("1. Agregar una carta a mi coleccion");
			System.out.println("2. Buscar tipo de una carta");
			System.out.println("3. Informacion de mi coleccion (nombre,tipo y cantidad de cartas)");
			System.out.println("4. Informacion de mi coleccion (nombre,tipo y cantidad de cartas) ordenada por tipo");
			System.out.println("5. Informacion de todas las cartas existentes (nombre,tipo y cantidad de cartas)");
			System.out.println("6. Informacion de todas las cartas existentes (nombre,tipo y cantidad de cartas) ordenadas por tipo");
			System.out.print("Ingrese el numero de la opcion que desee: ");
			menu = read.nextLine();
			tmenu = MenuInvalido(menu);
			while (tmenu != false) {
				System.out.print("Ingrese nuevamente el numero de la opcion que desee: ");	
				menu = read.nextLine();
				tmenu = MenuInvalido(menu);
			}
		
			switch (menu) {
		
			case("1"):
				System.out.println("Ingrese el nombre de la carta que desea agregar: ");
				userKey = read.nextLine();
				if(map.searchCards(userKey) != (null)) {
					user.pushCards(userKey, map.getCard(userKey));
					System.out.println("La carta se ha agregado exitosamente a su coleccion");
				}else
					System.out.println("La carta no se encuentra en la coleccion general");
				break;
		
			case("2"):
				System.out.println("Ingrese el nombre de la carta de la cual desea conocer su tipo: ");
				userKey = read.nextLine();
				System.out.println("El tipo de la carta " + userKey + " es: " + map.getCard(userKey));
				break;
		
			case("3"):
				if(user.Empty()){
					System.out.println("No hay elementos en la coleccion del usuario");
				}else {
					last = user.getCards().size();
					System.out.println("La cantidad de cartas en la coleccion del usuario son: "+last);
					System.out.println("Las cartas en la coleccion del usuario son: ");
					for(int a = 0; a < last;a++)
						System.out.println("-"+user.getCards().get(a));
				}

			break; 
			case("4"):
				if(user.Empty()) {
					System.out.println("No hay elementos en la coleccion usuario");
				}
				else {
					last = user.getOrdercards().size();
					System.out.println("La cantidad de cartas existentes por tipo son: ");
					System.out.println("-Hechizo: "+ user.cantCards(0)+" cartas");
					System.out.println("-Trampa: "+ user.cantCards(1)+" cartas");
					System.out.println("-Monstruo: "+ user.cantCards(2)+" cartas");
					System.out.println("Las cartas en la coleccion del usuario ordenadas por tipo son: ");
					for(int a = 0; a < last ;a++)
						System.out.println("-"+user.getOrdercards().get(a));
				}
			break;
		
			case("5"):
				last = map.getCards().size();
				System.out.println("La cantidad de cartas en la coleccion general son: "+last);
				System.out.println("Las cartas en la coleccion general son: ");
				for(int a = 0; a < last;a++)
					System.out.println(map.getCards().get(a));
		
			break;
		
			case("6"):
				last = map.getOrdercards().size();
				System.out.println();
				System.out.println("La cantidad de cartas existentes por tipo son: ");
				System.out.println("-Hechizo: "+ map.cantCards(0)+" cartas");
				System.out.println("-Trampa: "+ map.cantCards(1)+" cartas");
				System.out.println("-Monstruo: "+ map.cantCards(2)+" cartas");
				System.out.println();
				for(int a = 0; a < last;a++)
					System.out.println(map.getOrdercards().get(a));
			break;	
			}
		}while(!menu.equals("7"));
			
	}
	
	//Metodos de programacion defensiva
	
	public static boolean MenuInvalido(String me) {
		 boolean incorrecto = false;
		 if (!me.equals("1") && !me.equals("2") && !me.equals("3") && !me.equals("4") && !me.equals("5") && !me.equals("6") && !me.equals("7") ) 
			 incorrecto = true;
		else 
			incorrecto = false;
		 
		 return incorrecto;
	 }
	
	 public static boolean MenuInvalidoF(String me) {
		 boolean incorrecto = false;
		 if (!me.equals("1") && !me.equals("2") && !me.equals("3")) 
			 incorrecto = true;
		else 
			incorrecto = false;
		 
		 return incorrecto;
	 }
	
}

