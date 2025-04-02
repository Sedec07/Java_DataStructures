import java.util.*;

public class BinarySearch_Estudent {

    // Clase Estudiante que implementa Comparable
    public static class Estudiante implements Comparable<Estudiante> {
        private String nombre;
        private double promedioAcumulado;

        public Estudiante(String nombre, double promedioAcumulado) {
            this.nombre = nombre;
            this.promedioAcumulado = promedioAcumulado;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPromedioAcumulado() {
            return promedioAcumulado;
        }

        @Override
        public int compareTo(Estudiante otroEstudiante) {
            // Ordenar por promedio acumulado (de menor a mayor)
            return Double.compare(this.promedioAcumulado, otroEstudiante.promedioAcumulado);
        }

        // Comparator para buscar por promedio acumulado
        public static Comparator<Estudiante> PorPromedio = new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante e1, Estudiante e2) {
                return Double.compare(e1.getPromedioAcumulado(), e2.getPromedioAcumulado());
            }
        };

        @Override
        public String toString() {
            return "Estudiante: " + nombre + " - Promedio: " + promedioAcumulado;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arreglo de estudiantes de ejemplo
        Estudiante[] estudiantes = new Estudiante[100];
        // Poblamos el arreglo con estudiantes (usando nombres simples y promedios aleatorios entre 1.0 y 7.0)
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = new Estudiante("Estudiante " + (i + 1), Math.random() * 6 + 1);  // Promedio entre 1.0 y 7.0
        }

        // Ordenar estudiantes por promedio acumulado
        Arrays.sort(estudiantes);

        // Imprimir los estudiantes (solo los primeros 10 para no sobrecargar la salida)
        System.out.println("Primeros 10 estudiantes (ordenados por promedio):");
        for (int i = 0; i < 10; i++) {
            System.out.println(estudiantes[i]);
        }

        // Buscar un estudiante por su promedio acumulado usando búsqueda binaria
        System.out.println("Ingresa el promedio que deseas buscar:");
        double objetivo = scanner.nextDouble();

        int resultadoIterativo = busquedaBinariaIterativa(estudiantes, objetivo);
        int resultadoRecursivo = busquedaBinariaRecursiva(estudiantes, objetivo, 0, estudiantes.length - 1);

        if (resultadoIterativo >= 0) {
            System.out.println("Encontrado (Iterativo): " + estudiantes[resultadoIterativo]);
        } else {
            System.out.println("Estudiante no encontrado (Iterativo).");
        }

        if (resultadoRecursivo >= 0) {
            System.out.println("Encontrado (Recursivo): " + estudiantes[resultadoRecursivo]);
        } else {
            System.out.println("Estudiante no encontrado (Recursivo).");
        }

        // Contar cuántos estudiantes tienen un promedio mayor que 4.7
        int contarMayoresQue4_7 = contarEstudiantesMayoresQue(estudiantes, 4.7);
        System.out.println("Estudiantes con promedio > 4.7: " + contarMayoresQue4_7);

        scanner.close();
    }

    // Búsqueda binaria iterativa
    public static int busquedaBinariaIterativa(Estudiante[] arr, double objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arr[medio].getPromedioAcumulado() == objetivo) {
                return medio;
            } else if (arr[medio].getPromedioAcumulado() < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1; // No encontrado
    }

    // Búsqueda binaria recursiva
    public static int busquedaBinariaRecursiva(Estudiante[] arr, double objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1; // No encontrado
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        if (arr[medio].getPromedioAcumulado() == objetivo) {
            return medio;
        } else if (arr[medio].getPromedioAcumulado() < objetivo) {
            return busquedaBinariaRecursiva(arr, objetivo, medio + 1, derecha);
        } else {
            return busquedaBinariaRecursiva(arr, objetivo, izquierda, medio - 1);
        }
    }

    // Contar estudiantes con promedio mayor a una nota específica
    public static int contarEstudiantesMayoresQue(Estudiante[] estudiantes, double nota) {
        int count = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getPromedioAcumulado() > nota) {
                count++;
            }
        }
        return count;
    }
}
