package algorithm.graph.unionfind.bj1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] parent;
    public static void main(String[] args)throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i]=i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            if(a==0){
                union(b,c);
            }
            if(a==1){
                if(find(b)==find(c)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }

            }
        }
    }

    static int find(int x){
        if(x==parent[x])return x;
        else{
            return parent[x] = find(parent[x]);
        }
    }
    static void union(int b, int c){
        b = find(b);
        c = find(c);
        if(b!=c){
            parent[c]= b;
        }

    }
}
