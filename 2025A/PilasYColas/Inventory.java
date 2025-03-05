    import java.util.LinkedList;
    import java. util.Queue;
    import java.util.Scanner;

    public class Inventory
{
        //ejercicio preparación del parcial
        //1. usar la clase producto de la primera tarea para agregar prudcto y no string a la cola
        //2. no permitir hacer poll de un objeto si tiene cantidad ==0
        // crear un porta papeles

        public static void main (String[] args)
        {
        Queue<String> inventario = new LinkedList<>();
        // con el add se agrega a la cola 
            inventario.add("Nuevo producto 1");
            inventario.add("Nuevo producto 2");
            inventario.add("Nuevo producto 3");
            System.out.println("Inventario actual: "+inventario);
            //se vende un producto y sale un producto del inventario
            //con el poll se despacha o se elimina de la cola:
            System.out.println("Producto vendido: "+inventario.poll());
            System.out.println("Se vendió otro producto: "+inventario.poll());
            System.out.println(" ");

            System.out.println("Invnetario final: "+inventario);
            inventario.add("Nuevo producto 4");
            System.out.println("Invnetario final: "+inventario);
    }

}