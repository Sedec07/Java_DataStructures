    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;
    public class recursion {

        public static void main(String [] args) {
            func_recursiva(0);
            String texto= "Heidy e Isabella Una Amistad Inseparable";
            int contador= contar_vocales(texto);
            System.out.println("Total de vocales: "+contador);
        }
        static void func_recursiva(int i){
        System.out.println("llamdado "+i);
        try{
            Thread.sleep(1000);

        }
        catch(InterruptedException exception){}
        func_recursiva(i+1);
        }  
        static int contar_vocales( String cadena ){
            int vocales=0;
            try{
                Thread.sleep(1000);
                for (int i = 0; i < cadena.length(); i++) {
                    char c = cadena.charAt(i);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vocales++;
                        System.out.println("Se ha encontrado vocales: "+vocales);
                    }
                }
            }
            catch(InterruptedException exception){
                System.err.println("No hay mas vocales");
            }
            return vocales;
        }
    }
