package basic.dp.bj2193.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long d[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new long[91][2];
        d[1][0]=0;
        d[1][1]=1;
        for(int i=2; i<=N; i++){
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }
        System.out.println(d[N][0]+d[N][1]);
        br.close();
    }
}
