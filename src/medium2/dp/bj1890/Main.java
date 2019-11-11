package medium2.dp.bj1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Todo N^3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.valueOf(br.readLine());
        int [][] map = new int [N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] =Integer.valueOf(st.nextToken());
            }
        }
        int [][] d = new int[N+1][N+1];
        d[1][1]=1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==1 && j==1)continue;
                for(int k=1; k<j; k++){
                    if(j==map[i][k]+k){
                        d[i][j] +=d[i][k];
                    }

                }
                for(int k=1; k<i; k++){
                    if(i==map[k][j]+k){
                        d[i][j]+=d[k][j];
                    }
                }
            }
        }
        System.out.println(d[N][N]);
    }
}
