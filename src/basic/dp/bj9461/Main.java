package basic.dp.bj9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static long d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            d= new long[N+1];
            d[1]=1;
            d[2]=1;
            d[3]=1;
            for(int i=4; i<=N; i++){
                d[i]=d[i-2]+d[i-3];
            }
            System.out.println(d[N]);
        }

        br.close();
    }
}
