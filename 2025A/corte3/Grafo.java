public class Grafo {
    private int[][] matrizAdyacencia;
    private String[] nodos = {"A", "B", "C", "D", "E"};

    public Grafo() {
        // Matriz basada en la imagen (5x5)
        matrizAdyacencia = new int[][] {
            // A  B  C  D  E
            { 0, 1, 1, 0, 0 }, // A
            { 1, 0, 0, 1, 0 }, // B
            { 1, 0, 0, 1, 0 }, // C
            { 0, 1, 1, 0, 1 }, // D
            { 0, 0, 0, 1, 0 }  // E
        };
    }

    public boolean sonVecinos(String nodo1, String nodo2) {
        int i = indiceDe(nodo1);
        int j = indiceDe(nodo2);
        if (i == -1 || j == -1) {
            System.out.println("Nodo no válido.");
            return false;
        }
        return matrizAdyacencia[i][j] == 1;
    }

    private int indiceDe(String nodo) {
        for (int i = 0; i < nodos.length; i++) {
            if (nodos[i].equalsIgnoreCase(nodo)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Ejemplo de uso
        System.out.println("¿A y B son vecinos? " + grafo.sonVecinos("A", "B"));
        System.out.println("¿A y C son vecinos? " + grafo.sonVecinos("A", "C"));
        System.out.println("¿B y D son vecinos? " + grafo.sonVecinos("B", "D"));
    }
}