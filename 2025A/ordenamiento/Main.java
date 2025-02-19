import java.util.Arrays;

public class Main {
    
    // Método de ordenamiento Merge Sort para enteros
    public static void mergeSortEnteros(int[] arr) {
        if (arr.length <= 1) return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSortEnteros(left);
        mergeSortEnteros(right);

        mergeEnteros(arr, left, right);
    }

    // Método para combinar las mitades ordenadas de enteros
    public static void mergeEnteros(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Método de ordenamiento Burbuja para objetos
    static class Persona implements Comparable<Persona> {
        String nombre;
        int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad); // Ordenamos por edad
        }

        @Override
        public String toString() {
            return "Persona{" + "nombre='" + nombre + '\'' + ", edad=" + edad + '}';
        }

        public static void ordenarBurbuja(Persona[] personas) {
            for (int i = 0; i < personas.length - 1; i++) {
                for (int j = 0; j < personas.length - 1 - i; j++) {
                    if (personas[j].compareTo(personas[j + 1]) > 0) {
                        Persona temp = personas[j];
                        personas[j] = personas[j + 1];
                        personas[j + 1] = temp;
                    }
                }
            }
        }
    }

    // Método de ordenamiento Merge Sort para objetos
    public static void mergeSortObjetos(Persona[] personas) {
        if (personas.length <= 1) return;

        int mid = personas.length / 2;
        Persona[] left = new Persona[mid];
        Persona[] right = new Persona[personas.length - mid];

        System.arraycopy(personas, 0, left, 0, mid);
        System.arraycopy(personas, mid, right, 0, personas.length - mid);

        mergeSortObjetos(left);
        mergeSortObjetos(right);

        mergeObjetos(personas, left, right);
    }

    // Método para combinar las mitades ordenadas de objetos
    public static void mergeObjetos(Persona[] personas, Persona[] left, Persona[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                personas[k++] = left[i++];
            } else {
                personas[k++] = right[j++];
            }
        }

        while (i < left.length) {
            personas[k++] = left[i++];
        }

        while (j < right.length) {
            personas[k++] = right[j++];
        }
    }

    // Método para imprimir arrays de enteros
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método para imprimir arrays de objetos Persona
    public static void printArray(Persona[] arr) {
        for (Persona p : arr) {
            System.out.println(p);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // Ejercicio (a) - Ordenamiento Merge Sort de enteros
        int[] arrEnteros = {12, 11, 13, 5, 6, 7};
        System.out.println("Antes de Merge Sort de enteros:");
        printArray(arrEnteros);
        mergeSortEnteros(arrEnteros);
        System.out.println("Después de Merge Sort de enteros:");
        printArray(arrEnteros);

        // Ejercicio (b) - Ordenamiento Burbuja de objetos
        Persona[] personas = {
            new Persona("Juan", 25),
            new Persona("Maria", 20),
            new Persona("Carlos", 30),
            new Persona("Ana", 22)
        };

        System.out.println("Antes de ordenar con Burbuja:");
        printArray(personas);
        Persona.ordenarBurbuja(personas);
        System.out.println("Después de ordenar con Burbuja:");
        printArray(personas);

        // Ejercicio (c) - Ordenamiento Merge Sort de objetos
        Persona[] personasMergeSort = {
            new Persona("Juan", 25),
            new Persona("Maria", 20),
            new Persona("Carlos", 30),
            new Persona("Ana", 22)
        };

        System.out.println("Antes de Merge Sort de objetos:");
        printArray(personasMergeSort);
        mergeSortObjetos(personasMergeSort);
        System.out.println("Después de Merge Sort de objetos:");
        printArray(personasMergeSort);
    }
}
