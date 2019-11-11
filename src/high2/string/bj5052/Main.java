package high2.string.bj5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static ArrayList<Node>trie;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            trie = new ArrayList<>();
            int root = init();
            for(int n=0; n<N; n++){
                add(root, br.readLine(), 0, n);
            }
            boolean r = check(root);
            if(r){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

        br.close();
    }
    static int init(){
        Node n = new Node();
        trie.add(n);
        return trie.size()-1;
    }
    static void add(int node, String s, int idx, int s_num){
        if(idx==s.length()){
            trie.get(node).valid=s_num;
            return;
        }
        int c = s.charAt(idx)-'0';
        if(trie.get(node).child[c]==-1){
            int next = init();
            trie.get(node).child[c]=next;
        }
        add(trie.get(node).child[c], s, idx+1, s_num);
    }
    static boolean check(int node){
        for(int i=0; i<10; i++){
            int next = trie.get(node).child[i];
            if(next==-1){
                continue;
            }

            if(next!=-1){
                if(trie.get(node).valid!=-1){
                    return false;
                }else if(!check(next)){

                        return false;

                }

            }

        }

        return true;
    }
}
class Node{
    int valid;
    int [] child;

    Node(){
        valid = -1;
        child = new int[10];
        for(int i=0; i<10; i++){
            child[i]=-1;
        }
    }
}