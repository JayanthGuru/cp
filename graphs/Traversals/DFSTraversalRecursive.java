package Traversals;

import java.util.Scanner;
import java.util.ArrayList;


class Solution{

    void getDFSTraversalRecursive(int s,ArrayList<ArrayList<Integer>> graph, boolean[] visited, ArrayList<Integer> dfsOrder){
        if(visited[s])  return;

        visited[s] = true;
        dfsOrder.add(s);
        for(int neighbour: graph.get(s)){
            if(!visited[neighbour]){
                getDFSTraversalRecursive(neighbour, graph, visited, dfsOrder);
            }   
        }
    }

    ArrayList<Integer> getDFSTraversal(int V, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> dfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        
        getDFSTraversalRecursive(1, graph, visited, dfsOrder);
        return dfsOrder;
    }
}

public class DFSTraversalRecursive{

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int V = scan.nextInt();
        int U = scan.nextInt();
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=V;i++)   graph.add(new ArrayList<>());

        for(int i=0;i<U;i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        Solution s = new Solution();
        ArrayList<Integer> dfsTraversaOrder = s.getDFSTraversal(V, graph);
        for(int node: dfsTraversaOrder){
            System.out.print(node+" ");
        }
        System.out.println();
    }
}


