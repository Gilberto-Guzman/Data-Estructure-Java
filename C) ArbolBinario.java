// Programa para el uso de un arbol binario ordenado en java 
// Opciones para agregar y eliminar datos (numeros enteros)
// Reealizar el Recorrido de los datos del arbol en PreOrden, InOrden, PosOrden

import java.util.Scanner;    // Utilería para recibir valores del teclado

// Se define la clase NodoArbol
class NodoArbol {

	// Se definen nodos izquierdo y derecho
	NodoArbol nodoizquierdo;
	int datos;
	NodoArbol nododerecho;

	// Se inicializa un nuevo nodo como nodo hoja
	public NodoArbol(int datosNodo)
	{
		datos = datosNodo;
		nodoizquierdo = nododerecho = null; // Nodo sin hijos
	}

	// Se localiza el punto para insertar el nuevo nodo ordenado, luego se inserta
	public synchronized void insertar(int valorInsertar)
	{
		// Se inserta el nodo en subarbol izquierdo
		if (valorInsertar < datos){

			// Se inserta nuevo nodoarbol
			if (nodoizquierdo == null)
				nodoizquierdo = new NodoArbol(valorInsertar);
			else // Se continua recorriendo el subarbol izquierdo
				nodoizquierdo.insertar(valorInsertar);
		}

		// Se inserta el nodo en subarbol derecho
		else if(valorInsertar > datos){

		// Se inserta el nuevo nodoarbol
		if (nododerecho == null)
			nododerecho = new NodoArbol(valorInsertar);
		else // Se continua recorriendo el subarbol derecho
			nododerecho.insertar(valorInsertar);
		}


		// Se valida que no exista un valor en un nodo del arbol
		else if(valorInsertar == datos){

		// Al encontrarse el valor en un nodo NO se inserta el nuevo nodoarbol, pues ya existe
           System.out.println (" No se puede insertar el valor " + valorInsertar + ", ya esta incluido en uno de los nodos del arbol");		
        }

	}       //Termina el metodo insertar


}  // Termina la clase nodoarbol


// Se define la clase arbol
 class Arbol{
	private NodoArbol raiz;

	// Se inicializa el arbol vacio
	public Arbol()
	{
		raiz = null;
	}

	// Procedimiento para insertar un nuevo nodo en el arbol de busqueda binaria
	public synchronized void insertarNodo(int valorInsertar)
	{
		if(raiz == null)
			raiz = new NodoArbol(valorInsertar); // Se crea el nodo raiz

		else
			raiz.insertar(valorInsertar); // Llamado al metodo para insertar
	}


	// Procedimiento para el recorrido del arbol en PreOrden
	public synchronized void recorridoPreorden()
	{
		ayudantePreorden(raiz);
	}

	// Metodo recursivo para el recorrido en PreOrden
	private void ayudantePreorden(NodoArbol nodo)
	{
		if (nodo == null)
			return;

		System.out.print(nodo.datos + " ");   // Despliega dato del nodo
		ayudantePreorden(nodo.nodoizquierdo); // Recorre subarbol izquierdo
		ayudantePreorden(nodo.nododerecho);   // Recorre subarbol derecho
	}

	// Procedimiento para el recorrido del arbol en InOrden
	public synchronized void recorridoInorden()
	{
		ayudanteInorden(raiz);
	}

	// Metodo recursivo para el recorrido en InOrden
	private void ayudanteInorden(NodoArbol nodo)
	{
		if (nodo == null)
			return;

		ayudanteInorden(nodo.nodoizquierdo);
		System.out.print(nodo.datos + " ");
		ayudanteInorden(nodo.nododerecho);
	}

	// Procedimiento para el recorrido del arbol en PosOrden
	public synchronized void recorridoPosorden()
	{
		ayudantePosorden(raiz);
	}

	// Metodo recursivo para el recorrido en PosOrden
	private void ayudantePosorden(NodoArbol nodo)
	{
		if (nodo == null)
			return;

		ayudantePosorden(nodo.nodoizquierdo);
		ayudantePosorden(nodo.nododerecho);
		System.out.print(nodo.datos + " ");
	}
	
	//Metodo para buscar un dato
	public boolean NADA() {
		return raiz==null;
	}
	
	public NodoArbol buscarNodo(int datito) {
		NodoArbol K = raiz; //utilizamos a K como variable auxiliar
		while(K.datos != datito) {
			if(datito < K.datos) {
				K = K.nodoizquierdo;
			}
			else {
				K = K.nododerecho;
			}
			if(K == null) {
				return null;
			}
		}
		return K;
	}
	
	
	//Metodo para eliminar un dato
	public boolean QUITAR(int datito) {

		NodoArbol J=raiz; //usamos a J como auxiliar
		NodoArbol Papa=raiz;
		boolean Izq=true;
		
		while(J.datos!=datito) {
			if(datito<J.datos) {
				Izq = true;
				J = J.nodoizquierdo;
				
			}
			else {
				Izq = false;
				J = J.nododerecho;				
			}
			if(J == null) {
				return false;
				
			}
		}//Fin del while
		
		if(J.nodoizquierdo == null && J.nododerecho == null) {
			if(J==raiz) {
				raiz = null;
			}
			else if(Izq) {
				Papa.nodoizquierdo = null;
			}
			else {
				Papa.nododerecho = null;
			}
		}
		else if(J.nododerecho == null) {
			if(J == raiz) {
				raiz = J.nodoizquierdo;
			}
			else if(Izq) {
				Papa.nodoizquierdo = J.nodoizquierdo;
			}
			else {
				Papa.nododerecho = J.nodoizquierdo;
			}
		}
		else if(J.nodoizquierdo==null) {
			if(J == raiz) {
				raiz = J.nododerecho;
			}
			else if(Izq) {
				Papa.nodoizquierdo = J.nododerecho;
			}
			else {
				//padre.nododerecho = auxiliar.nodoizquierdo;
				Papa.nododerecho = J.nododerecho;
			}
		}	
		else {
			NodoArbol reemplazo = obtenerReemplazo(J);
			if(J == raiz) {
				raiz = reemplazo;
			}
			else if(Izq) {
				Papa.nodoizquierdo = reemplazo;
			}
			else{
				Papa.nododerecho = reemplazo;
			}
			reemplazo.nodoizquierdo = J.nodoizquierdo;
		}
		return true;
		}
	
		//Metodo encargado de devolvernos el nodo reemplazo
		public NodoArbol obtenerReemplazo(NodoArbol nodoReemp) {
			NodoArbol reemplazarPadre = nodoReemp;
			NodoArbol reemplazo = nodoReemp;
			NodoArbol L = nodoReemp.nododerecho;//utilizamos a L como auxiliar
			while(L != null) {
				reemplazarPadre	= reemplazo;
				reemplazo = L;
				L = L.nodoizquierdo;
			}
			if(reemplazo != nodoReemp.nododerecho) {
				reemplazarPadre.nodoizquierdo = reemplazo.nododerecho;
				reemplazo.nododerecho = nodoReemp.nododerecho;
			}
			return reemplazo;
		}
		
} // Termina la clase arbol


	
	
// Programa para usar la clase arbol, árbol binario

public class ArbolBinario {

	public static void main(String args[])
	{
	   Arbol arbol = new Arbol();
	   int opcion, dato;
         Scanner teclado=new Scanner(System.in);

         System.out.println(" ");
         System.out.println("-- Ejemplo de manejo de un ARBOL BINARIO ORDENADO --");

       do
         {
           System.out.println(" ");
           System.out.println ("ARBOL BINARIO ORDENADO - ENTEROS - OPCIONES");
           System.out.println ("1.Insertar un dato - nodo al arbol");
    		System.out.println ("2.Eliminar un dato - nodo del arbol");
    		System.out.println ("3.Recorrer en Pre orden");
    		System.out.println ("4.Recorrer en In  orden");
    		System.out.println ("5.Recorrer en Pos orden");
    		System.out.println ("6.Buscar   un dato - nodo del arbol");
    		System.out.println ("7.Salir del programa");
           System.out.println (" ");
           System.out.println ("Seleccione la accion a realizar, Indique el Numero: ");
           opcion=teclado.nextInt();
           System.out.println (" ");

           switch(opcion)     // Se realiza la opcion seleccionada

          {
           case 1:
                 System.out.println("Escriba el numero para agregar      - Entero: ");
                 dato=teclado.nextInt();
   			arbol.insertarNodo(dato);
        		break;
           case 2:
        	   	
        	   if(!arbol.NADA()) {
        		   System.out.println("Escriba el numero a eliminar      - Entero: ");
        		   dato=teclado.nextInt();
        		   
        		   if(arbol.QUITAR(dato) == false) {
        			   System.out.println("No se encuentra el nodo");
        		   }else {
        			   System.out.println("El nodo ha sido eliminado");
        		   }
        	   }else {
        		   System.out.println("Se encuentra vacio el nodo");
        	   } 
        		break;

           case 3:
                 System.out.print("El recorrido del arbol en PreOrden es: ");
                 arbol.recorridoPreorden();
                 System.out.println();
                 break;
           case 4:
                 System.out.print("El recorrido del arbol en  InOrden es: ");
                 arbol.recorridoInorden();
                 System.out.println();
                 break;
           case 5:
                 System.out.print("El recorrido del arbol en PosOrden es: ");
                 arbol.recorridoPosorden();
                 System.out.println();
                 break;
           case 6:    	   
        	   if(!arbol.NADA()) {
        		   System.out.println("Escriba el numero para buscar      - Entero: ");
        		   dato=teclado.nextInt();
        		   
        		   if(arbol.buscarNodo(dato) == null) {
        			   System.out.println("No se encuentra el nodo");
        		   }else {
        			   System.out.println("Se encontro el nodo");
        		   }
        	   }else {
        		   System.out.println("Se encuentra vacio el nodo");
        	   } 
        		break;

           }   // Termina el case	
       } 
        while (opcion!=7);      // Termina el do

	}
  }