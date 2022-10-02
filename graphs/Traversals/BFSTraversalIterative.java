package Traversals;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution{

    ArrayList<Integer> getBFSTraversalIterative(int V, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[V+1];
        
        q.add(1);
        while(q.peek() != null){
            int currNode = q.poll();
            if(visited[currNode] == false)    result.add(currNode); 
            visited[currNode] = true;   
            for(int neighbour: graph.get(currNode)){
                if(visited[neighbour] == false)   q.add(neighbour);
            }
        }
        return result;
    }
}

public class BFSTraversalIterative {

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
        ArrayList<Integer> bfsTraversaOrder = s.getBFSTraversalIterative(V, graph);
        for(int node: bfsTraversaOrder){
            System.out.print(node+" ");
        }
        System.out.println();
    }
}

