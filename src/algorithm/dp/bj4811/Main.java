package algorithm.dp.bj4811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static long [][] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            int t = Integer.valueOf(br.readLine());
            if(t==0){
                break;
            }
            dp = new long[t+1][t+1];
            for(long [] i : dp){
                Arrays.fill(i, -1);
            }
            System.out.println(cal(t, 0));
        }

    }

    private static long cal(int t, int i) {
        if(dp[t][i]!=-1)return dp[t][i];
        if(t==0){
            return 1;
        }
        if(i==0){
            return dp[t][i] = cal(t-1, i+1);
        }
        return dp[t][i] = cal(t-1, i+1) + cal(t, i-1);

    }
}
