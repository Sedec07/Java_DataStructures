import java.util.Scanner;

public class OrdenamientosObjetos {
    public static void main(String[] args) {
        OrdenamientosObjetos pruebaOrdenamiento = new OrdenamientosObjetos();
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
        
        ordenarBurbuja(productos, opcion);
        imprimirArray(productos);
        
        scanner.close();
    }
    
    public void imprimirArray(Producto[] productos) {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public void ordenarBurbuja(Producto[] productos, int criterio) {
        int n = productos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (debeIntercambiar(productos[j], productos[j + 1], criterio)) {
                    Producto temp = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = temp;
                }
            }
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