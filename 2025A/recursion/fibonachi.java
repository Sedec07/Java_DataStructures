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
                 resultado = fibo_iteractivo(numero);
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
        static int fibo_iteractivo(int n) {

            int[] fibo = new int[n];
            fibo[0]=1;
            fibo[1]=1;
            for (int i = 2; i < n; i++) {
                fibo[i]=fibo[i-1]+fibo[i-2];
            }
            return fibo[n-1]; 
        }
    }
