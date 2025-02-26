import java.util.*;

public class Ordenamiento_Insert_Sort {
    public static void main(String[] args) {
        Ordenamiento_Insert_Sort pruebaOrdenamiento = new Ordenamiento_Insert_Sort();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public void probarOrdenamientos() {
        Scanner scanner = new Scanner(System.in);

        // Lista de productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(3, "Manzana", 2.5, 10));
        productos.add(new Producto(1, "Banana", 1.2, 5));
        productos.add(new Producto(4, "Naranja", 1.8, 8));
        productos.add(new Producto(2, "Pera", 1, 12));
        productos.add(new Producto(6, "Sandia", 3.5, 4));
        productos.add(new Producto(5, "Melon", 4.0, 3));

        System.out.println("Seleccione el criterio de ordenamiento:");
        System.out.println("1. Código");
        System.out.println("2. Nombre");
        System.out.println("3. Precio");
        System.out.println("4. Cantidad");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 3: 
                // Ordenar por precio usando el Comparator
                productos.sort(Comparator.comparingDouble(Producto::getPrecio));
                break;
            case 4:
                // Ordenar por cantidad usando el Comparator
                productos.sort(Comparator.comparingInt(Producto::getCantidad));
                break;
        }

        imprimirArray(productos);

        // Buscar un producto por código
        System.out.println("Ingrese el código del producto a buscar:");
        int codigoBuscar = scanner.nextInt();
        buscarProductoPorCodigo(productos, codigoBuscar);

        scanner.close();
    }

    public void imprimirArray(List<Producto> productos) {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    private void buscarProductoPorCodigo(List<Producto> productos, int codigo) {
        for (Producto p : productos) {
            if (p.codigo == codigo) {
                System.out.println("Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado.");
    }

    static class Producto {
        int codigo;
        String nombre;
        double precio;
        int cantidad;

        public Producto(int codigo, String nombre, double precio, int cantidad) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        @Override
        public String toString() {
            return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad;
        }
    }
}
