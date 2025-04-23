import java.util.*;

public class DiccionarioBinario3 {

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
            // Ordenar  palabras
            return this.palabra.compareTo(otraPalabra.palabra);
        }

        @Override
        public String toString() {
            return palabra + ": " + definicion;
        }
    }

    // Nodo del arbol binario
    public static class Nodo {
        Palabra palabra;
        Nodo izquierda, derecha;

        public Nodo(Palabra palabra) {
            this.palabra = palabra;
            this.izquierda = this.derecha = null;
        }
    }

    // Clase que representa el arbol binario donde vamos a buscar
    public static class ArbolBinario {
        private Nodo raiz;

        public ArbolBinario() {
            this.raiz = null;
        }

        // metodo para agregar una palabra al arbol
        public void agregar(Palabra palabra) {
            raiz = agregarRecursivo(raiz, palabra);
        }

        // funcion para agregar una palabra
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

        // metodo para buscar una palabra en el arbol
        public Palabra buscar(String palabraBuscada) {
            return buscarRecursivo(raiz, palabraBuscada);
        }

        // funcion  para buscar una palabra
        private Palabra buscarRecursivo(Nodo nodo, String palabraBuscada) {
            if (nodo == null) {
                return null; // Si no es encontrada
            }

            int comparacion = palabraBuscada.compareTo(nodo.palabra.palabra);
            if (comparacion == 0) {
                return nodo.palabra; // si la palabra es encontrada
            } else if (comparacion < 0) {
                return buscarRecursivo(nodo.izquierda, palabraBuscada);
            } else {
                return buscarRecursivo(nodo.derecha, palabraBuscada);
            }
        }

        // metodo para recorrer el arbol en orden y mostrar las palabras
        public void recorrerEnOrden() {
            recorrerEnOrdenRecursivo(raiz);
        }

        // funcion  para recorrer el arbol en orden (inorden)
        private void recorrerEnOrdenRecursivo(Nodo nodo) {
            if (nodo != null) {
                recorrerEnOrdenRecursivo(nodo.izquierda); // recorrer el subarbol izquierdo
                System.out.println(nodo.palabra); // mostrar la palabra
                recorrerEnOrdenRecursivo(nodo.derecha); // Recorrer subarbol derecho
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // se crea el arbol de busqueda
        ArbolBinario diccionario = new ArbolBinario();
        diccionario.agregar(new Palabra("Gol", "Acción de meter el balón en la portería del equipo contrario."));
        diccionario.agregar(new Palabra("Futbolista", "Persona que juega al fútbol de forma profesional o amateur."));
        diccionario.agregar(new Palabra("Portero", "Jugador cuya función principal es evitar que el equipo contrario marque goles."));
        diccionario.agregar(new Palabra("Arbitro", "Persona encargada de impartir justicia durante el partido de fútbol."));
        diccionario.agregar(new Palabra("Tarjeta amarilla", "Advertencia oficial que recibe un jugador por cometer una infracción."));
        diccionario.agregar(new Palabra("Tarjeta roja", "Expulsión de un jugador del partido debido a una infracción grave."));
        diccionario.agregar(new Palabra("Penalti", "Tiro directo desde el punto de penalti, otorgado cuando se comete una infracción dentro del área."));
        diccionario.agregar(new Palabra("Córner", "Tiro desde la esquina del campo otorgado cuando el balón cruza completamente la línea de meta, tocado por un jugador del equipo defensor."));
        diccionario.agregar(new Palabra("Fuera de juego", "Situación en la que un jugador está en una posición ilegal en el campo al recibir un pase."));
        diccionario.agregar(new Palabra("Equipo", "Conjunto de jugadores que compiten juntos en un partido de fútbol."));

        // Se pide al usuario que ingrese una palabra a buscar
        System.out.println("Ingrese la palabra a buscar:");
        String palabraBuscada = scanner.nextLine();

        // Buscar la palabra en el diccionario
        Palabra resultado = diccionario.buscar(palabraBuscada);

        if (resultado != null) {
            System.out.println("Se encontró la plabra: " + resultado);
        } else {
            System.out.println("Palabra no encontrada.");
        }

        // Mostrar todas las palabras en orden ascendente
        System.out.println("\nRecorrido en orden (todas las palabras):");
        diccionario.recorrerEnOrden();

        scanner.close();
    }
}
