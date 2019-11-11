package high2.string.bj9202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    static LinkedList<TrieNode> trie;
    static boolean check[][];
    static char map [][];
    static ArrayList<String> words;
    static int dx[] ={0,0,1,-1,1,1,-1,-1};
    static int dy[] ={1,-1,0,0,1,-1,1,-1};
    static int score[] = {0,0,0,1,1,2,3,5,11};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        trie = new LinkedList<>();
        int root = init();
        for(int i=0; i<N; i++){
            String input = br.readLine();
            add(root, input, 0);
        }
        br.readLine();
        int M = Integer.parseInt(br.readLine());

        for(int m =0; m<M; m++){

            check = new boolean[4][4];
            map = new char [4][4];
            words = new ArrayList<>();
            for(int i=0;i<4;i++){
                String bo = br.readLine();
                map[i] = bo.toCharArray();

            }
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    search(i,j,"", root);
                }
            }
            ArrayList<String> b = new ArrayList<>();
            for(String s : words){
                if(!b.contains(s)){
                    b.add(s);
                }
            }
            String longest="";
            int sum=0;
            int cnt=0;
            for(String s : b){

                sum = sum + score[s.length()];
                cnt++;
                if(longest.length()<s.length()){
                    longest=s;
                }else if(longest.length()==s.length() && longest.compareTo(s)>0){
                    longest=s;
                }

            }
            System.out.println(sum+ " " + longest + " " + cnt);
            if(m==M-1){

            }else{
                br.readLine();
            }
        }

        br.close();
    }
    static int init(){
        TrieNode node = new TrieNode();
        trie.add(node);
        return trie.size()-1;

    }
    static void add(int node, String s, int idx){
        if(idx==s.length()){
            trie.get(node).valid=true;
            return;
        }
        int c = s.charAt(idx)-'A';
        if(trie.get(node).children[c]==-1){
            int next = init();
            trie.get(node).children[c]=next;
        }
        add(trie.get(node).children[c], s, idx+1);
    }
    static void search(int x, int y, String s, int node ){
        if(x<0 || x>=4 || y<0 || y>=4){
            return;
        }
        if(s.length()==8){
            return;
        }
        if(check[x][y]){
            return;
        }
        check[x][y]=true;
        int c = map[x][y]-'A';
        int next = trie.get(node).children[c];
        if(next==-1){
            check[x][y]=false;
            return;
        }
        s+=map[x][y];
        if(trie.get(next).valid){
            words.add(s);
        }
        for(int i=0; i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            search(nx, ny, s, next);
        }

        check[x][y]=false;


    }

}
class TrieNode{
    boolean valid;
    int [] children;

    public TrieNode() {
        this.valid = false;
        this.children = new int [26];
        for(int i=0; i<26; i++){
            children[i]=-1;
        }
    }
}