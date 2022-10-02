import java.util.Scanner;
import java.util.ArrayList;

class Solution{

    public void fill(ArrayList<Integer> arr, int n, int key){
        for(int i=0;i<n;i++)    arr.add(i,key);
    }

    public ArrayList<ArrayList<Integer>> buildAdjMatrix(int V, int U, ArrayList<ArrayList<Integer>> edges){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        //Adding the empty lists to graph
        for(int i=0;i<V+1;i++){
            ArrayList<Integer> singleRow = new ArrayList<>(V+1);
            fill(singleRow, V+1, 0);           //To initialize the arraylist with key:0
            graph.add(singleRow);
        }

        //marking the edges in the adjMatrix 
        for(int i=0;i<U;i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            graph.get(u).set(v,1);
            graph.get(v).set(u,1);
        }

        return graph;
    }
}


public class AdjMatrix{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();     //No of Vertices
        int U = scan.nextInt();     //No of edges

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i=0;i<U;i++){
            ArrayList<Integer> singleEdge = new ArrayList<>();
            int u = scan.nextInt();
            int v = scan.nextInt();
            singleEdge.add(u);
            singleEdge.add(v);
            edges.add(singleEdge);
        }

        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph = s.buildAdjMatrix(V,U,edges);

        for(int row=1; row<=V; row++){
            for(int col=1; col<=V; col++){
                System.out.print(graph.get(row).get(col)+" ");
            }
            System.out.println();
        }
    }
}