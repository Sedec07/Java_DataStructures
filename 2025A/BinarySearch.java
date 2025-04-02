import java.util.Scanner;
public class BinarySearch
{

public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    //ARREGLO DE PRUEBA:
    int [] testarray={ 1,5,8,9,12,24,50,54,88,120,200, 201, 1128 };
    int izquierdo = 0; 
    int derecho = testarray.length - 1; 
    
    //PROBAR LAS DOS VERSIONES DEL ALGORITMO CON UN ELEMENTO QUE INDIQUE EL USUARIOS:
    //CON BUSQUEA BINARIA ITERACTIVA:
    int busqueda= menu();
    int Objetivo= objetivo();
    // CON BUSQUEDA BINARIA RECURSIVA
    switch (busqueda) {
    case 1:
        int encontrado= busquedaBinariaIterativa(testarray, Objetivo);
        if (encontrado>0) {
            System.err.println("Valor encontrado: "+Objetivo);
            
        } else{
            System.out.println("El valor no existe");
        }
        break;
    case 2:
        int buscar=busquedaBinariaRecursiva(testarray, Objetivo, izquierdo, derecho);
        if (buscar>0) {
            System.err.println("Valor encontrado: "+Objetivo);
            
        } else{
            System.out.println("El valor no existe");
        }

        break;
    default:
        System.out.println("Opción no valida");
        break;
}
    scanner.close();

  }
  public static int objetivo () {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa el valor a buscar");
    System.out.println("");
    int objetive= scanner.nextInt();
    scanner.close();
    return objetive;
}

    public static int menu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("seleccione un metodo ");
        System.out.println("1. Busqueda binaria iteractiva");
        System.out.println("2. Busqueda binaria recursiva");
        int buscar= scanner.nextInt();
        
        return buscar;
    }
    public static int busquedaBinariaIterativa(int[] arr, int objetivo) {
    int izquierda = 0;
    int derecha = arr.length - 1;
    
    //el limite izquierdo siempre debe ser menor que el limite derecho: es decir,
    //hasta donde se puede partir el espacio de búsqueda.
    while (izquierda <= derecha) {
        int medio = izquierda + (derecha - izquierda) / 2;
        
        if (arr[medio] == objetivo) {
            return medio;
        }
        // decide si buscar por la izquierda o la derecha, en cadad iteracción:
        if (arr[medio] < objetivo) {
            izquierda = medio + 1;
        } else {
            derecha = medio - 1;
        }
    }
    
    return Integer.MIN_VALUE;
}

  public static int busquedaBinariaRecursiva(int[] arr, int objetivo, int izquierda, int derecha) {
    // PARTE 1: CASO BASE
    if (izquierda > derecha) {
        return -1;
    }
    //PARTE 2: DIVISIÓN DEL PROBLEMA    |   
    int medio = izquierda + (derecha - izquierda) / 2;
    
    if (arr[medio] == objetivo) {
        return medio;
    }
    
    if (arr[medio] > objetivo) {
        return busquedaBinariaRecursiva(arr, objetivo, izquierda, medio - 1);
    }
    
    return busquedaBinariaRecursiva(arr, objetivo, medio + 1, derecha);
}

  @Override
  public String toString() {
    return "BinarySearch []";
  }

  

}