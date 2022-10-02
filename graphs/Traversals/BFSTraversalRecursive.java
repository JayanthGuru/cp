package Traversals;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution{

    void getBFSTraversalRecursive(ArrayList<ArrayList<Integer>> graph, Queue<Integer> q, boolean[] visited, ArrayList<Integer> bfsOrder){
        if(q.isEmpty())     return;

        int currNode = q.poll();
        bfsOrder.add(currNode);

        for(int neighbour: graph.get(currNode)){
            if(visited[neighbour] == false){
                q.add(neighbour);
                visited[neighbour] = true;
            }
        }
        getBFSTraversalRecursive(graph, q, visited, bfsOrder);
    }

    ArrayList<Integer> getBFSTraversal(int V, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        getBFSTraversalRecursive(graph, q, visited, result);
        return result;
    }
}

public class BFSTraversalRecursive{

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
        ArrayList<Integer> bfsTraversaOrder = s.getBFSTraversal(V, graph);
        for(int node: bfsTraversaOrder){
            System.out.print(node+" ");
        }
        System.out.println();
    }
}

