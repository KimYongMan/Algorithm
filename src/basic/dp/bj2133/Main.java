package basic.dp.bj2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [] d = new long[N+100];
        d[0]=1;
        d[1]=0;
        d[2]=3;

        for(int i=3; i<=N; i++){
            d[i] = 3*d[i-2];
            for(int j=i-4;j>=0;j-=2){
                d[i]=d[i]+2*d[j];
            }
        }
        System.out.println(d[N]);
        br.close();
    }
}
