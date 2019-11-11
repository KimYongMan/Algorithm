package basic.dp.bj2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long [][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        d = new long[K+1][N+1];
        d[0][0]=1;
        for(int k=1; k<=K; k++){
            for(int i=0;i<=N;i++){
                for(int j=0;j<=i;j++){
                    d[k][i]+= d[k-1][i-j];
                    d[k][i]%=1000000000;
                }
            }
        }
        System.out.println(d[K][N]);

        br.close();
    }
}
