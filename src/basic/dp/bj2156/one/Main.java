package basic.dp.bj2156.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N+1];
        int [] d = new int[N+1];
        for(int i=1; i<=N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        d[1] = A[1];
        if(N>=2){
            d[2] = A[1]+A[2];
        }

        for(int i=3; i<=N; i++){
            d[i] = d[i-1];
            if(d[i]<d[i-2]+A[i]){
                d[i] = d[i-2]+A[i];
            }
            if(d[i]<d[i-3]+A[i]+A[i-1]){
                d[i] = d[i-3]+A[i]+A[i-1];
            }
        }
        int ans = d[1];
        for(int i=2; i<=N;i++){
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
        br.close();
    }
}
