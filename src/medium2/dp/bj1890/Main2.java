package medium2.dp.bj1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Todo N^2
public class Main2 {
    public static void main(String[] args)throws IOException {
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
        long [][] d = new long[N+1][N+1];
        d[1][1]=1;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]==0)continue;
                if(j+map[i][j]<=N){
                    d[i][j+map[i][j]]+=d[i][j];
                }
                if(i+map[i][j]<=N){
                    d[i+map[i][j]][j]+=d[i][j];
                }

            }
        }
        System.out.println(d[N][N]);

    }
}
