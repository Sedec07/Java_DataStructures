import java.util.*;

public class OrdenamientoProductos {
    public static void main(String[] args) {
        OrdenamientoProductos app = new OrdenamientoProductos();
        app.ejecutar();
    }

    private void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto(3, "Manzana", 2.5, 10),
            new Producto(1, "Banana", 1.2, 5),
            new Producto(4, "Naranja", 1.8, 8),
            new Producto(2, "Pera", 1.0, 12),
            new Producto(6, "Sandia", 3.5, 4),
            new Producto(5, "Melon", 4.0, 3)
        ));

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Ordenar productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarProducto(scanner, productos);
                    break;
                case 2:
                    ordenarProductos(scanner, productos);
                    break;
                case 3:
                    buscarProductoPorCodigo(scanner, productos);
                    break;
                case 4:
                    imprimirProductos(productos);
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void agregarProducto(Scanner scanner, List<Producto> productos) {
        System.out.println("Ingrese el código del producto:");
        int codigo = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = scanner.nextInt();
        
        productos.add(new Producto(codigo, nombre, precio, cantidad));
        System.out.println("Producto agregado con éxito.");
    }

    private void ordenarProductos(Scanner scanner, List<Producto> productos) {
        System.out.println("Seleccione el criterio de ordenamiento:");
        System.out.println("1. Precio");
        System.out.println("2. Cantidad");
        int criterio = scanner.nextInt();
        
        if (criterio == 1) {
            insertionSort(productos, Comparator.comparingDouble(Producto::getPrecio));
            System.out.println("Productos ordenados por precio.");
        } else if (criterio == 2) {
            insertionSort(productos, Comparator.comparingInt(Producto::getCantidad));
            System.out.println("Productos ordenados por cantidad.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void buscarProductoPorCodigo(Scanner scanner, List<Producto> productos) {
        System.out.println("Ingrese el código del producto a buscar:");
        int codigo = scanner.nextInt();
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                System.out.println("Producto encontrado: " + p);
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado.");
    }

    private void imprimirProductos(List<Producto> productos) {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    private void insertionSort(List<Producto> productos, Comparator<Producto> comparator) {
        for (int i = 1; i < productos.size(); i++) {
            Producto key = productos.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(productos.get(j), key) > 0) {
                productos.set(j + 1, productos.get(j));
                j--;
            }
            productos.set(j + 1, key);
        }
    }

    static class Producto {
        private final int codigo;
        private final String nombre;
        private final double precio;
        private final int cantidad;

        public Producto(int codigo, String nombre, double precio, int cantidad) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public int getCodigo() { return codigo; }
        public String getNombre() { return nombre; }
        public double getPrecio() { return precio; }
        public int getCantidad() { return cantidad; }

        @Override
        public String toString() {
            return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad;
        }
    }
}
