package basic.dp.bj2193.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        d = new long[91];
        d[1] = 1;
        d[2] = 1;
        for(int i=3;i<=N; i++){
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[N]);
        br.close();
    }
}
