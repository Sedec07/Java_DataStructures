import java.util.*;


public class GrafoTransporte {
    static final int N = 5; // A, B, C, D, E
    static String[] estaciones = {"A", "B", "C", "D", "E"};
    static boolean[][] adyacencia = new boolean[N][N];

    public static void main(String[] args) {
        agregarConexion("A", "B");
        agregarConexion("A", "C");
        agregarConexion("B", "D");
        agregarConexion("C", "D");
        agregarConexion("D", "E");

        sonVecinos("A", "B"); // vecinos
        sonVecinos("A", "E"); // no vecinos
        System.out.println("¿Hay camino entre A y E?: " + hayCamino("A", "E"));  // true
    }

    static void agregarConexion(String a, String b) {
        int i = indice(a);
        int j = indice(b);
        adyacencia[i][j] = true;
        adyacencia[j][i] = true; // grafo no dirigido
    }

    // Método modificado para indicar si son vecinos
    static boolean sonVecinos(String a, String b) {
        int i = indice(a);
        int j = indice(b);
        boolean vecinos = adyacencia[i][j];
        if (vecinos) {
            System.out.println(a + " y " + b + " son vecinos.");
        } else {
            System.out.println(a + " y " + b + " no son vecinos.");
        }
        return vecinos;
    }

    static boolean hayCamino(String origen, String destino) {
        boolean[] visitado = new boolean[N];
        return dfs(indice(origen), indice(destino), visitado);
    }

    static boolean dfs(int actual, int destino, boolean[] visitado) {
        if (actual == destino) return true;
        visitado[actual] = true;
        for (int i = 0; i < N; i++) {
            if (adyacencia[actual][i] && !visitado[i]) {
                if (dfs(i, destino, visitado)) return true;
            }
        }
        return false;
    }

    static int indice(String estacion) {
        for (int i = 0; i < estaciones.length; i++) {
            if (estaciones[i].equals(estacion)) return i;
        }
        throw new IllegalArgumentException("Estación no válida: " + estacion);
    }
}