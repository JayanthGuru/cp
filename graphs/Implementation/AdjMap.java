//Adjacent List is a list of elements of with which the indexed node is added 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Solution{

    public HashMap<Integer,ArrayList<Integer>> buildAdjMap(int V, int U, ArrayList<ArrayList<Integer>> edges){
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        //Adding the empty lists to graph
        for(int i=0;i<V+1;i++){
            ArrayList<Integer> singleRow = new ArrayList<>();
            graph.put(i,singleRow);
        }

        //marking the edges in the adjMatrix 
        for(int i=0;i<U;i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}


public class AdjMap{

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
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph = s.buildAdjMap(V,U,edges);

        for(int row=1; row<=V; row++){
            System.out.print(row+" -> ");
            for(int ele: graph.get(row)){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
