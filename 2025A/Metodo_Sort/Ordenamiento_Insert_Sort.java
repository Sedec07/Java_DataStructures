import java.util.Scanner;

public class Ordenamiento_Insert_Sort {
    public static void main(String[] args) {
        Ordenamiento_Insert_Sort pruebaOrdenamiento = new Ordenamiento_Insert_Sort();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public void probarOrdenamientos() {
        Scanner scanner = new Scanner(System.in);
        Producto[] productos = {
            new Producto(3, "Manzana", 2.5),
            new Producto(1, "Banana", 1.2),
            new Producto(2, "Naranja", 1.8)
        };
        
        System.out.println("Seleccione el criterio de ordenamiento:");
        System.out.println("1. Código");
        System.out.println("2. Nombre");
        System.out.println("3. Precio");
        int opcion = scanner.nextInt();
        
        ordenarInsertionSort(productos, opcion);
        imprimirArray(productos);
        
        scanner.close();
    }
    
    public void imprimirArray(Producto[] productos) {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void ordenarInsertionSort(Producto[] productos, int criterio) {
        int n = productos.length;
        for (int i = 1; i < n; i++) {
            Producto key = productos[i];
            int j = i - 1;
            while (j >= 0 && debeIntercambiar(productos[j], key, criterio)) {
                productos[j + 1] = productos[j];
                j--;
            }
            productos[j + 1] = key;
        }
    }
    
    private boolean debeIntercambiar(Producto p1, Producto p2, int criterio) {
        switch (criterio) {
            case 1: return p1.codigo > p2.codigo;
            case 2: return p1.nombre.compareToIgnoreCase(p2.nombre) > 0;
            case 3: return p1.precio > p2.precio;
            default: return false;
        }
    }

    static class Producto {
        int codigo;
        String nombre;
        double precio;
        
        public Producto(int codigo, String nombre, double precio) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
        }
        
        @Override
        public String toString() {
            return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio;
        }
    }
}
