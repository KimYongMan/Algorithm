package basic.tree.bj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [][]  a = new int [26][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = st.nextToken().charAt(0)-'A';
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if(l=='.'){
                a[x][0]=-1;
            }else{
                a[x][0] = l-'A';
            }
            if(r=='.'){
                a[x][1] = -1;
            }else{
                a[x][1] = r-'A';
            }

        }
        preOrder(a, 0);
        System.out.println();
        inOrder(a, 0);
        System.out.println();
        postOrder(a, 0);
    }
    public static void preOrder(int [][]a, int x){
        if(x==-1) return;
        System.out.print((char)(x+'A'));
        preOrder(a, a[x][0]);
        preOrder(a, a[x][1]);
    }
    public static void inOrder(int [][] a, int x){
        if(x==-1) return;
        inOrder(a,a[x][0]);
        System.out.print((char)(x+'A'));
        inOrder(a, a[x][1]);
    }
    public static void postOrder(int [][]a, int x){
        if(x==-1)return;
        postOrder(a, a[x][0]);
        postOrder(a, a[x][1]);
        System.out.print((char)(x+'A'));
    }
}
