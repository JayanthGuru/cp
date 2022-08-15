/*
 * This program provides the implementation of Trie's basic features like insert, search if exists and search if string starts with prefix. 
 */
import java.util.Scanner;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;
    int count = 0;

    public Node(){

    }

    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    Node get(char ch){
        return links[ch-'a'];
    }
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return flag;
    }
};

class Trie {
    private static Node root;

    Trie(){
        root = new Node();
    }

    //TC -> O(len of word)
    void insert(String word){
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch)){
                temp.put(ch, new Node());                
            }
            temp = temp.get(ch);
            temp.count++;
        }
        temp.setEnd();
    }

    //TC -> O(len of word)
    boolean search(String word){
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch))   return false;
            
            temp = temp.get(ch);
        }  
        if(temp.isEnd())    return true; 
        return false; 
    }

    boolean startsWith(String prefix){
        Node temp = root;
        for(int i=0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(!temp.containsKey(ch))       return false;
            
            temp = temp.get(ch);
        }
        return true;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch))    return 0;
            temp = temp.get(ch);
        }
        if(temp.isEnd())    return temp.count;
        return 0;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!temp.containsKey(ch))    return 0;
            temp = temp.get(ch);
        }
        return temp.count;        
    }

    void erase(String word){
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(temp.containsKey(ch)){
                temp = temp.get(ch);
                temp.count--;
                if(temp.count==0){
                    temp.put(ch,null);
                    return;
                }
            }
            
        }
    }

    void delete(String word){
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(temp.containsKey(ch))    temp.put(ch,null);
        }
    }
};

public class BasicOperations{

    public static void main(String[] args){
        Trie root = new Trie();
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        while(t-- > 0){
            int n = Integer.parseInt(scan.nextLine());
            for(int i=0;i<n;i++){
                String[] inpt = scan.nextLine().split(" ");
                String q = inpt[0];
                String s = inpt[1];
                if(q.equals("insert"))                      root.insert(s);
                else if(q.equals("search"))                 System.out.println(root.search(s));
                else if(q.equals("startsWith"))             System.out.println(root.startsWith(s));
                else if(q.equals("countWordsEqualTo"))      System.out.println(root.countWordsEqualTo(s));
                else if(q.equals("countWordsStartingWith")) System.out.println(root.countWordsStartingWith(s));
                else if(q.equals("erase"))                  root.erase(s);
            }
            scan.close();
        }
    } 
}

