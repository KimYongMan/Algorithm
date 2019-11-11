package basic.dp.bj11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int d [];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        d = new int[N+1];
        d[1]=1;
        d[2]=2;
        for(int i=3; i<=N; i++){
            d[i] = (d[i-1] + d[i-2])%10007;
        }
        System.out.println(d[N]);
        br.close();
    }
}
