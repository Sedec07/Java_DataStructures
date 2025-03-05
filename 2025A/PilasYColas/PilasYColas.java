import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
 
public class PilasYColas {
 
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        Stack<String> pilaTexto = new Stack<String>();
        String textoActual= "", nuevoTexto;
        int opcion;
 
        //ciclo infinito del mini-editor
        while(true){
            System.out.println("texto actual en el editor: "+textoActual);
            System.out.println("seleccione una opcion :(1) Ingresar (2) Deshacer (3) Salir ");
            System.out.println("(4) Imprimir texto completo ");
            System.out.println("(5) Imprimir texto desde la pila ");
            opcion =lector.nextInt();
            //leer texto desde el editor:
            lector.nextLine();
            switch (opcion) {
                //agregar texto
                case 1:
                    System.out.println("Escribe tu texto: ");
                    nuevoTexto= lector.nextLine();
                    //agregar elemento a la pila
                    pilaTexto.push(nuevoTexto);
                    textoActual +=nuevoTexto;
                    break;
                //eliminar texto de la pila
                case 2:
                    if (!pilaTexto.isEmpty()) {
                        //sacar texto de la pila
                        textoActual = pilaTexto.pop();
                    }
                    else{
                        System.out.println("No hay texto para eliminar");
                    }
                    break;
                case 3:
                    System.out.println("Cerrando... ");
                    lector.close();
                    return;
                case 4:
                    System.out.println("Texto actual en el editor: "+textoActual);
                    break;
                
                case 5:
                    //sacar elementos de la pila con op e irlo imprimiendo en pantalla
                    //¿como hacer para que imprima el texto en orden?
                    // Crear una copia temporal de la pila para imprimir en orden
                    Stack<String> pilaTemporal = new Stack<String>();
                    
                    // Copiar todos los elementos de la pila original a la pila temporal
                    while (!pilaTexto.isEmpty()) {
                        pilaTemporal.push(pilaTexto.pop());
                    }

                    // Imprimir los elementos en el orden original
                    //System.out.println("Texto desde la pila (en orden original):");
                    while (!pilaTemporal.isEmpty()) {
                        System.out.println(pilaTemporal.pop());
                    }

                break;

                default:
                System.out.println("Opción no valida ");
                    break;
            }
        }
    }
   
}
 