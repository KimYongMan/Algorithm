package basic.dp.bj9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [][] dp;
        int [][] A;
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
           A =  new int[3][N+1];
           dp = new int [N+1][3];
           for(int i=1; i<=2; i++){
               String input = br.readLine();
               StringTokenizer st = new StringTokenizer(input);
               for(int j=1; j<=N; j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
               }
           }
           dp[1][0] = 0;
           dp[1][1] =A[1][1];
           dp[1][2] = A[2][1];
           for(int i=2; i<=N; i++){
               dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
               dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2])+A[1][i];
               dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + A[2][i];
           }
            System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
        }

        br.close();
    }
}
