import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) throws IOException {
		
		Scanner read = new Scanner(System.in);
		//Attributes
		String[] cards = null;
		String card, value, key = null, userKey = null,menu;//Key
		boolean tmenu;

		//Class Ambassador (Factory Pattern)
		FactoryMap FM = new FactoryMap();
		
		//Creating the main map
		//Change to variable or can be initialized using any Map
		InterMap map = FM.getInitialization("1");
		//Creating user's map
		InterMap user = FM.getInitialization("1");
		
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
		System.out.println("----------------------- MAP -----------------------");
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
				System.out.println("La carta no se encuentra en la coleccion");
		break;
		
		case("2"):
			break;
		case("3"):
			break;
		case("4"):
			break;
		case("5"):
			break;
		case("6"):
			break;
				
		}
			
		
			
		
	}
	
	public static boolean MenuInvalido(String me) {
		 boolean incorrecto = false;
		 if (!me.equals("1") && !me.equals("2") && !me.equals("3") && !me.equals("4") && !me.equals("5") && !me.equals("6") ) 
			 incorrecto = true;
		else 
			incorrecto = false;
		 
		 return incorrecto;
	 }
	
}

