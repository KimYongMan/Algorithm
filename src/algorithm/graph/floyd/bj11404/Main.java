package algorithm.graph.floyd.bj11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int inf = 100000000;
    static int N, M;
    static int [][]a, d;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());
        a = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    a[i][j] = 0;
                }else{
                    a[i][j] = inf;
                }
            }
        }
        StringTokenizer st;
        for(int m=1; m<=M; m++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            if(a[from][to] > cost){
                a[from][to] = cost;
            }

        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(a[i][j]> a[i][k] + a[k][j])
                        a[i][j] = a[i][k] + a[k][j];
                }
            }
        }
        for(int i=1; i<=N; i++){

            for(int j=1; j<=N; j++){
                if(a[i][j]==inf)a[i][j]=0;
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
