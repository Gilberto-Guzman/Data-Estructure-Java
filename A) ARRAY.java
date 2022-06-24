import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ARRAY {
	//variables utilizadas
    static int OPC=0,i,j,CONTADATO=0;
    static float aux;
    static String TipoDeDato,Op = " ";
    
	public static void main(String[] ar) {
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
	
		//El usuario determina el numero de datos a ingresar
		System.out.print("Delimita la cantidad de datos a ingresar: ");
		int N = teclado.nextInt();
		System.out.println("");
		CONTADATO = N;
		
		float numeros[] = new float[N];
		float mayormenor[] = new float[N];
		String FECHAHORA [] = new String[N];
		
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
					
			if(i<N) {	
					//Guarda el dato y lo asigna en el arreglo
					System.out.print("Dato"+"["+(i+1)+"]"+" = ");
					numeros[i] = teclado.nextFloat();
					mayormenor[i] = numeros[i];
					
					//Convierte la hora y fecha en un string para poder almacenarla en un arreglo
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");	
					String strDateAndHour = sdf.format(date);					
					FECHAHORA[i] = strDateAndHour;					
					i++;
					CONTADATO--;
					
					//Mecanismo para ordenar los datos de mayor a menor
					for(i=0;i<N-CONTADATO;i++) {
						for(j=i+1;j<N-CONTADATO;j++) {
							if(mayormenor[i]<mayormenor[j])
							{
								aux=mayormenor[i];
								mayormenor[i]=mayormenor[j];
								mayormenor[j]=aux;
							}
						}
					}
			}
			else
				System.out.println("Ya no se pueden agregar mas datos.");
				break;
			
			case 2:
				//Imprime los valores en su orden original
				System.out.println("los valores de " + TipoDeDato + " contenidos en su orden original son: ");
				for(int i=0;i<N-CONTADATO;i++) {
					System.out.println(numeros[i]+" ");	
				}
				break;
			
			case 3:
				//Imprime los valores en su orden inverso
				System.out.println("los valores de " + TipoDeDato + " contenidos en su orden inverso son: ");
				for(int i=N-1-CONTADATO;i>=0;i--) {
					System.out.println(numeros[i]+" ");
				}	
				break;
			
			case 4:

				//Imprime los valores de mayor a menor
				System.out.println("los valores "  + TipoDeDato + " contenidos de mayor a menor son: ");
				for(int i=0;i<N-CONTADATO;i++) {
					System.out.println(mayormenor[i]+" ");
				}
				break;
			
			case 5:
				//Imprime los valores de menor a mayor
				System.out.println("los valores "  + TipoDeDato + " contenidos de menor a mayor son: ");
				for(int i=N-1-CONTADATO;i>=0;i--) {
					System.out.println(mayormenor[i]+" ");
				}	
				break;
			case 6:
				for(int i=0;i<N-CONTADATO;i++) {
					System.out.println("Dato "+ "["+ (i+1) +"]" +" = "+ numeros[i] +" Se agrego en esta fecha y hora --> " +FECHAHORA[i]);
				}
				break;
			}
		}	
	}
}