    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;
    public class recursion_factorial {

        public static void main(String [] args) {

            Scanner scanner = new Scanner(System.in);
            int resultado=0;

            // Pedir al usuario que ingrese un número
            System.out.print("Ingresa un número para calcular su factorial: ");
            int numero = scanner.nextInt();
            System.out.print("Seleccione un metodo: 1.recursivo 2.iteractivp ");
            int metodo=scanner.nextInt();
            if (metodo==1) {
                 resultado = fact(numero);
            } else{
                 resultado = fact_iteractivo(numero);
            }
            
            System.out.println("El factorial de " + numero + " es: " + resultado);
        }
        static int fact(int n) {
            if (n == 0 || n == 1) {
                return 1;
            } else {
                // Caso recursivo: factorial de n = n * factorial de (n-1)
                return n * fact(n - 1);
            }
        }
        static int fact_iteractivo(int n) {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial; 
        }
    }
