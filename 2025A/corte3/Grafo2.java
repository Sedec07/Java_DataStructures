/** 
 * @author vini7
 */
import java.util.*;
public class Grafo2 {
    //lista de nodos
    private ArrayList<Nodo> nodos= new ArrayList<>();
    // lista de adyacencia
    private ArrayList<ArrayList<int[]>> adyacencias= new ArrayList<>();

    public ArrayList<Nodo> DFS_Recursivo(int indiceNodoActual,boolean[] visitados, ArrayList<Nodo> recorridos)
    {
        //marca como visitado para no visitarlo nuevamente:
        visitados [indiceNodoActual] = true;
        //agregar el nodo al camino:
        recorridos.add(nodos.get(indiceNodoActual));
        //aplica nuevamente el algortimo, de forma recursiva, a cada nodo vecino:
        for(int [] vecino: adyacencias.get(indiceNodoActual))
        {
            int destino=vecino[0];
            if (!visitados[destino]) 
            {
                DFS_Recursivo(destino, visitados, recorridos)
            }
        }
        /*
         * para cada nodo adyacente n_a de nodos.get(indiceNodoActual):
         *  si n_a no ha sido visitado:
         *      dfs_recursivo(n_a.indice, visiados, recorridos)
         * 
         *///return ArrayList<list> ;
    }

    public ArrayList<Nodo> BFS (int indiceNodo)
    {
        boolean[] visitados=new boolean[nodos.size()];
        Queue<Integer> pendientes = new LinkedList<>();
        ArrayList<Nodo> recorrido = new ArrayList<>();

        pendientes.add(indiceNodo);
        visitados[indiceNodo]= true;
        /*
         * mientras aun haya nodos por visitar (cola de nodos pendiente no sea vacia), (condición del ciclo):
         *      nodo_actual = obtener nodo de la cola de pendientes
         *      adicionar nodo_actual al recorrido
         *      para cada nodo vecino del nodo_actual:
         *          visitar vecino
         *          marcar como visitado
         */
    }
}
