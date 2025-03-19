    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;
    public class fibonachi {

        public static void main(String [] args) {

            Scanner scanner = new Scanner(System.in);
            int resultado=0;

            // Pedir al usuario que ingrese un número
            System.out.print("Ingresa una posición de finacci: ");
            int numero = scanner.nextInt();
            System.out.print("Seleccione un metodo: ");
            System.out.print("1.recursivo ");
            System.out.print("2.iteractivo ");
            int metodo=scanner.nextInt();
            if (metodo==1) {
                 resultado = fibo(numero);
            } else{
                 resultado = fact_iteractivo(numero);
            }
            
            System.out.println("El valor de la posición fibonacci " + numero + " es: " + resultado);
        }
        static int fibo(int n) {
            // Caso base: los primeros dos valores de Fibonacci son 0 y 1
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                // Caso recursivo: fibo(n) = fibo(n-1) + fibo(n-2)
                return fibo(n - 1) + fibo(n - 2);
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
