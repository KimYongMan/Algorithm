package high1.dp3.bj2133;

import java.util.Scanner;

public class Main {
    static int N;
    static int [][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N+1][8];
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[1][2] = 0;
        dp[1][3] = 1;
        dp[1][4] = 0;
        dp[1][5] = 0;
        dp[1][6] = 1;
        dp[1][7] = 0;

        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][7];
            dp[i][1] = dp[i-1][6];
            dp[i][2] = dp[i-1][5];
            dp[i][3] = dp[i-1][4] + dp[i-1][7];
            dp[i][4] = dp[i-1][3];
            dp[i][5] = dp[i-1][2];
            dp[i][6] = dp[i-1][1] + dp[i-1][7];
            dp[i][7] = dp[i-1][0] + dp[i-1][3] + dp[i-1][6];
        }
        System.out.println(dp[N][7]);
    }
}
