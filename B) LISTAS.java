import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class LISTAS {
	//Variables utilizadas
    static LinkedList<Float> ListaNumeros = new LinkedList<Float>();
    static LinkedList<String> FechaHora = new LinkedList<String>();
    
    static int OPC=0;
    static float DATO;
    static String TipoDeDato,Op = " ";
    
    public static void main(String arg[]) {
	
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("Delimita el tipo de dato a ingresar: \n");
		
		//Datos obtenibles de un oximetro
		System.out.println("A) Frecuencia de pulso cardiaco ---> PR.");
		System.out.println("B) Saturacion de oxigeno por pulsiometria ---> SpO2.");
		
		//Datos obtenibles de un termometro 
		System.out.println("C) Temperatura corporal. ---> TP.");
		
		//Datos obtenibles de un tensiometro
		System.out.println("D) Presion sistolica. ---> SYS.");
		System.out.println("E) Presion diastolica. ---> DIA.");
		
		System.out.print("\nSelecciona una opcion: ");
		Op = teclado.nextLine();
		Op = Op.toUpperCase();
		
		switch(Op) {
		case "A":
			TipoDeDato = "PR";
			break;
		
		case "B":
			TipoDeDato = "SpO2";
			break;	
		
		case "C":
			TipoDeDato = "TP";
			break;
			
		case "D":
			TipoDeDato = "SYS";
			break;

		case "E":
			TipoDeDato = "DIA";
			break;
		}
		
		while(OPC!=7) {
			
			//Menu
			System.out.println("-----MENU-----");
			System.out.println("1.-Agregar un valor para " + TipoDeDato + ".");
			System.out.println("2.-Mostrar los valores de " + TipoDeDato + " en su orden original.");
			System.out.println("3.-Mostrar los valores de " + TipoDeDato + " en su orden inverso.");
			System.out.println("4.-Mostrar los valores de " + TipoDeDato + " de mayor a menor.");
			System.out.println("5.-Mostrar los valores de " + TipoDeDato + " de menor a mayor.");		
			System.out.println("6.-Mostrar fecha y hora de cada valor " + TipoDeDato + " agregado.");		
			System.out.println("7.-Salir del programa.");
			
			System.out.print("\nSelecciona una opcion: ");
			OPC=teclado.nextInt();
			System.out.print("\n");
			switch(OPC) {
			
			case 1:
				//Guarda un dato y lo asigna en la lista
				System.out.print("Agrega el dato: ");
				DATO = teclado.nextFloat();			
				ListaNumeros.add(DATO);
				
				//Convierte la hora y fecha en un string para poder almacenarla en una lista
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");	
				String strDateAndHour = sdf.format(date);
				FechaHora.add(strDateAndHour);
				
			    break;
				
			case 2:
				//imprime los datos en su orden original
				System.out.println("los valores de " + TipoDeDato + " contenidos en su orden original son: "+ListaNumeros);
				break;
				
			case 3:
				//imprime los datos en su orden inverso
				Collections.reverse(ListaNumeros);
				System.out.println("los valores de " + TipoDeDato + " contenidos en su orden inverso son: "+ListaNumeros);
				Collections.reverse(ListaNumeros);
				break;
				
			case 4:
				//imprime los datos de mayor a menor
				Collections.sort(ListaNumeros);
				Collections.reverse(ListaNumeros);
				System.out.println("los valores "  + TipoDeDato + " contenidos de mayor a menor son: "+ListaNumeros);
				Collections.sort(ListaNumeros);
				Collections.reverse(ListaNumeros);
				break;
			
			case 5:
				//imprime los datos de menor a mayor
				Collections.sort(ListaNumeros);
				System.out.println("los valores "  + TipoDeDato + " contenidos de menor a mayor son: "+ListaNumeros);
				Collections.sort(ListaNumeros);
				break;
			case 6:
				//Imprime la fecha y hora en la cual fueron ingresados los valores
			    for(int i=0; i<ListaNumeros.size(); i++) {
		            System.out.println("Dato "+ "["+ (i+1) +"]" +" = "+ ListaNumeros.get(i) +" Se agrego en esta fecha y hora --> " +FechaHora.get(i));
		   }
				break;
			}
			
		}
	}
}