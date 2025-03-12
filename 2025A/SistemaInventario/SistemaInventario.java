import java.util.*;
import java.util.Scanner;

class Producto implements Comparable<Producto> {
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio;

    // Constructor
    public Producto(String codigo, String descripcion, int cantidad, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    // Método para comparar productos por código (para Comparable)
    @Override
    public int compareTo(Producto otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    // Método para comparar productos por precio (Comparator)
    public static Comparator<Producto> PrecioComparator = new Comparator<Producto>() {
        @Override
        public int compare(Producto p1, Producto p2) {
            return Double.compare(p1.precio, p2.precio);
        }
    };

    // Método para comparar productos por descripción (Comparator)
    public static Comparator<Producto> DescripcionComparator = new Comparator<Producto>() {
        @Override
        public int compare(Producto p1, Producto p2) {
            return p1.descripcion.compareTo(p2.descripcion);
        }
    };

    @Override
    public String toString() {
        return "Producto{" + "codigo='" + codigo + "', descripcion='" + descripcion + "', cantidad=" + cantidad + ", precio=" + precio + '}';
    }
}

class ListaEnlazada {
    private LinkedList<Producto> lista;

    // Constructor
    public ListaEnlazada() {
        lista = new LinkedList<>();
    }

    // Agregar producto
    public void agregarProducto(Producto producto) {
        lista.add(producto);
    }

    // Eliminar producto por código
    public boolean eliminarProducto(String codigo) {
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                lista.remove(p);
                return true;
            }
        }
        return false;
    }

    // Buscar producto por código
    public Producto buscarProducto(String codigo) {
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null; // Si no lo encuentra
    }

    // Ordenar lista por código (Comparable)
    public void ordenarPorCodigo() {
        Collections.sort(lista);
    }

    // Ordenar lista por precio (Comparator)
    public void ordenarPorPrecio() {
        Collections.sort(lista, Producto.PrecioComparator);
    }

    // Ordenar lista por descripción (Comparator)
    public void ordenarPorDescripcion() {
        Collections.sort(lista, Producto.DescripcionComparator);
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}

class Inventario {
    private ListaEnlazada inventario;
    private Stack<Producto> devoluciones;
    private Queue<Producto> reposicion;

    // Constructor
    public Inventario() {
        inventario = new ListaEnlazada();
        devoluciones = new Stack<>();
        reposicion = new LinkedList<>();
    }

    // Agregar producto al inventario
    public void agregarProducto(Producto producto) {
        inventario.agregarProducto(producto);
    }

    // Eliminar producto del inventario por código
    public boolean eliminarProducto(String codigo) {
        return inventario.eliminarProducto(codigo);
    }

    // Buscar producto en el inventario por código
    public Producto buscarProducto(String codigo) {
        return inventario.buscarProducto(codigo);
    }

    // Ordenar inventario por código
    public void ordenarPorCodigo() {
        inventario.ordenarPorCodigo();
    }

    // Ordenar inventario por precio
    public void ordenarPorPrecio() {
        inventario.ordenarPorPrecio();
    }

    // Ordenar inventario por descripción
    public void ordenarPorDescripcion() {
        inventario.ordenarPorDescripcion();
    }

    // Procesar devoluciones (Pila)
    public void devolverProducto(Producto producto) {
        devoluciones.push(producto);
    }

    // Procesar reposición (Cola)
    public void reposicionarProducto(Producto producto) {
        reposicion.add(producto);
    }

    // Mostrar inventario
    public void mostrarInventario() {
        System.out.println("Inventario: " + inventario);
    }

    // Mostrar devoluciones
    public void mostrarDevoluciones() {
        System.out.println("Devoluciones: " + devoluciones);
    }

    // Mostrar reposiciones
    public void mostrarReposiciones() {
        System.out.println("Reposiciones: " + reposicion);
    }
}

public class SistemaInventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        while (true) {
            System.out.println("\n--- Sistema de Inventario CatTronics ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Buscar producto");
            System.out.println("4. Ordenar inventario");
            System.out.println("5. Realizar devolución");
            System.out.println("6. Reposición de producto");
            System.out.println("7. Mostrar inventario");
            System.out.println("8. Mostrar devoluciones");
            System.out.println("9. Mostrar reposiciones");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de la línea

            switch (opcion) {
                case 1: // Agregar producto
                    System.out.print("Ingrese el código del producto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Ingrese la descripción del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingrese la cantidad en stock: ");
                    int cantidad = scanner.nextInt();
                    System.out.print("Ingrese el precio unitario: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer

                    Producto producto = new Producto(codigo, descripcion, cantidad, precio);
                    inventario.agregarProducto(producto);
                    System.out.println("Producto agregado con éxito.");
                    break;

                case 2: // Eliminar producto
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    if (inventario.eliminarProducto(codigoEliminar)) {
                        System.out.println("Producto eliminado con éxito.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3: // Buscar producto
                    System.out.print("Ingrese el código del producto a buscar: ");
                    String codigoBuscar = scanner.nextLine();
                    Producto productoBuscado = inventario.buscarProducto(codigoBuscar);
                    if (productoBuscado != null) {
                        System.out.println("Producto encontrado: " + productoBuscado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4: // Ordenar inventario
                    System.out.println("¿Cómo desea ordenar el inventario?");
                    System.out.println("1. Por código");
                    System.out.println("2. Por precio");
                    System.out.println("3. Por descripción");
                    System.out.print("Selecciona una opción: ");
                    int opcionOrdenar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (opcionOrdenar) {
                        case 1:
                            inventario.ordenarPorCodigo();
                            System.out.println("Inventario ordenado por código.");
                            break;
                        case 2:
                            inventario.ordenarPorPrecio();
                            System.out.println("Inventario ordenado por precio.");
                            break;
                        case 3:
                            inventario.ordenarPorDescripcion();
                            System.out.println("Inventario ordenado por descripción.");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;

                case 5: // Realizar devolución
                    System.out.print("Ingrese el código del producto a devolver: ");
                    String codigoDevolucion = scanner.nextLine();
                    Producto productoDevolucion = inventario.buscarProducto(codigoDevolucion);
                    if (productoDevolucion != null) {
                        inventario.devolverProducto(productoDevolucion);
                        System.out.println("Producto devuelto.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 6: // Reposición de producto
                    System.out.print("Ingrese el código del producto a reponer: ");
                    String codigoReposicion = scanner.nextLine();
                    Producto productoReposicion = inventario.buscarProducto(codigoReposicion);
                    if (productoReposicion != null) {
                        inventario.reposicionarProducto(productoReposicion);
                        System.out.println("Producto en espera de reposición.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 7: // Mostrar inventario
                    inventario.mostrarInventario();
                    break;

                case 8: // Mostrar devoluciones
                    inventario.mostrarDevoluciones();
                    break;

                case 9: // Mostrar reposiciones
                    inventario.mostrarReposiciones();
                    break;

                case 0: // Salir
                    System.out.println("¡Gracias por usar el sistema!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
