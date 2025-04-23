import java.util.*;

public class DiccionarioBinario {

    // Clase Palabra para representar cada entrada en el diccionario
    public static class Palabra implements Comparable<Palabra> {
        private String palabra;
        private String definicion;

        public Palabra(String palabra, String definicion) {
            this.palabra = palabra;
            this.definicion = definicion;
        }

        public String getPalabra() {
            return palabra;
        }

        public String getDefinicion() {
            return definicion;
        }

        @Override
        public int compareTo(Palabra otraPalabra) {
            // Ordenar por palabra (lexicográficamente)
            return this.palabra.compareTo(otraPalabra.palabra);
        }

        @Override
        public String toString() {
            return palabra + ": " + definicion;
        }
    }

    // Nodo del árbol binario
    public static class Nodo {
        Palabra palabra;
        Nodo izquierda, derecha;

        public Nodo(Palabra palabra) {
            this.palabra = palabra;
            this.izquierda = this.derecha = null;
        }
    }

    // Clase que representa el árbol binario de búsqueda
    public static class ArbolBinario {
        private Nodo raiz;

        public ArbolBinario() {
            this.raiz = null;
        }

        // Método para agregar una palabra al árbol
        public void agregar(Palabra palabra) {
            raiz = agregarRecursivo(raiz, palabra);
        }

        // Función recursiva para agregar una palabra
        private Nodo agregarRecursivo(Nodo nodo, Palabra palabra) {
            if (nodo == null) {
                return new Nodo(palabra);
            }

            if (palabra.compareTo(nodo.palabra) < 0) {
                nodo.izquierda = agregarRecursivo(nodo.izquierda, palabra);
            } else if (palabra.compareTo(nodo.palabra) > 0) {
                nodo.derecha = agregarRecursivo(nodo.derecha, palabra);
            }
            return nodo;
        }

        // Método para buscar una palabra en el árbol
        public Palabra buscar(String palabraBuscada) {
            return buscarRecursivo(raiz, palabraBuscada);
        }

        // Función recursiva para buscar una palabra
        private Palabra buscarRecursivo(Nodo nodo, String palabraBuscada) {
            if (nodo == null) {
                return null; // No encontrada
            }

            int comparacion = palabraBuscada.compareTo(nodo.palabra.palabra);
            if (comparacion == 0) {
                return nodo.palabra; // Palabra encontrada
            } else if (comparacion < 0) {
                return buscarRecursivo(nodo.izquierda, palabraBuscada);
            } else {
                return buscarRecursivo(nodo.derecha, palabraBuscada);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el árbol binario de búsqueda
        ArbolBinario diccionario = new ArbolBinario();

        // Poblamos el diccionario con algunas palabras
        diccionario.agregar(new Palabra("Java", "Lenguaje de programación."));
        diccionario.agregar(new Palabra("Recursión", "Proceso en el que una función se llama a sí misma."));
        diccionario.agregar(new Palabra("Algoritmo", "Conjunto de instrucciones para resolver un problema."));
        diccionario.agregar(new Palabra("Array", "Estructura de datos que almacena una colección de elementos."));

        // Pedir al usuario una palabra a buscar
        System.out.println("Ingresa la palabra que deseas buscar:");
        String palabraBuscada = scanner.nextLine();

        // Buscar la palabra en el diccionario
        Palabra resultado = diccionario.buscar(palabraBuscada);

        if (resultado != null) {
            System.out.println("Palabra encontrada: " + resultado);
        } else {
            System.out.println("Palabra no encontrada.");
        }

        scanner.close();
    }
}
// RESPONDER PUNTO 2 PARCIAL