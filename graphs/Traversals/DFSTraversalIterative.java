package Traversals;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;


class Solution{

    ArrayList<Integer> getDFSTraversalIterative(int V, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> dfsOrder = new ArrayList<>();    
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V+1];
        
        stack.push(1);
        while(!stack.isEmpty()){
            
            int currNode = stack.pop();
            if(!visited[currNode]){  
                visited[currNode] = true;                   //marking the node visited
                dfsOrder.add(currNode);                     //adding the node to the result
                
                ArrayList<Integer> neighbours = graph.get(currNode);
                for(int i=neighbours.size()-1;i>=0;i--){ 
                        stack.push(neighbours.get(i));
                }
            }
        }

        return dfsOrder;
    }
}

public class DFSTraversalIterative {

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
        ArrayList<Integer> dfsTraversaOrder = s.getDFSTraversalIterative(V, graph);
        for(int node: dfsTraversaOrder){
            System.out.print(node+" ");
        }
        System.out.println();
    }
}

