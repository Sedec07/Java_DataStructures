public class OrdenamientosObjetos {

    public static void main(String[] args) {
        OrdenamientosObjetos pruebaOrdenamiento = new OrdenamientosObjetos();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public OrdenamientosObjetos() {}

    public void probarOrdenamientos() {
        // Crear dos personas para comparar
        Persona persona1 = new Persona(62, "Diego");
        Persona persona2 = new Persona(63, "Fabiola");

        // Comparar las dos personas usando compareTo
        if (persona1.compareTo(persona2) > 0) {
            System.out.println("La persona 1 (" + persona1 + ") es mayor que la persona 2 (" + persona2 + ") (por edad)");
        } else if (persona1.compareTo(persona2) < 0) {
            System.out.println("La persona 1 (" + persona1 + ") es menor que la persona 2 (" + persona2 + ") (por edad)");
        } else {
            System.out.println("La persona 1 (" + persona1 + ") es igual a la persona 2 (" + persona2 + ") (por edad)");
        }

        // Crear un arreglo desordenado de 10 objetos Persona
        Persona[] personas = new Persona[10];
        personas[0] = new Persona(28, "Juan");
        personas[1] = new Persona(35, "Maria");
        personas[2] = new Persona(22, "Carlos");
        personas[3] = new Persona(30, "Ana");
        personas[4] = new Persona(40, "Luis");
        personas[5] = new Persona(18, "Sofia");
        personas[6] = new Persona(25, "Miguel");
        personas[7] = new Persona(19, "Laura");
        personas[8] = new Persona(50, "Pedro");
        personas[9] = new Persona(29, "Fabiola");

        // Imprimir antes de ordenar
        System.out.println("\nAntes de ordenar:");
        imprimirArray(personas);

        // Ordenar usando el algoritmo de burbuja
        ordenarBurbuja(personas);

        // Imprimir después de ordenar
        System.out.println("\nDespués de ordenar:");
        imprimirArray(personas);
    }

    // Método para imprimir el arreglo de personas
    public void imprimirArray(Persona[] personas) {
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

    // Método de ordenamiento Burbuja para el arreglo de personas
    public void ordenarBurbuja(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = 0; j < personas.length - 1 - i; j++) {
                if (personas[j].compareTo(personas[j + 1]) > 0) {
                    // Intercambiar las personas si están en el orden incorrecto
                    Persona temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    // Clase Persona implementando Comparable para ordenar por edad
    static class Persona implements Comparable<Persona> {
        int edad;
        String nombre;

        // Constructor de la clase Persona
        public Persona(int edad, String nombre) {
            this.edad = edad;
            this.nombre = nombre;
        }

        // Implementación del método compareTo para comparar por edad
        @Override
        public int compareTo(Persona otra) {
            return Integer.compare(this.edad, otra.edad);  // Compara por edad
        }

        // Sobrescribir el método toString para mostrar la persona
        @Override
        public String toString() {
            return nombre + " (" + edad + " años)";
        }
    }
}
