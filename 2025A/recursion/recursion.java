    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Scanner;
    public class recursion {

        public static void main(String [] args) {
            func_recursiva(0);
        
        }
        static void func_recursiva(int i){
        System.out.println("llamdado "+i);
        try{
            Thread.sleep(1000);

        }
        catch(InterruptedException exception){}
        func_recursiva(i+1);
        }  
    }
