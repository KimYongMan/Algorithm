package basic.dp.bj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static int []d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            d= new int[11];
            d[1]=1;
            d[2]=2;
            d[3]=4;
            for(int i=4; i<=N; i++){
                d[i] = d[i-1]+d[i-2]+d[i-3];
            }
            System.out.println(d[N]);
        }
        br.close();
    }
}
