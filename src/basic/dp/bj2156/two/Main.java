package basic.dp.bj2156.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N+1];
        int [][] d = new int[N+1][3];
        for(int i=1; i<=N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=N; i++){
            d[i][0] =Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
            d[i][1] = d[i-1][0] + A[i];
            d[i][2] = d[i-1][1] + A[i];
        }
        System.out.println(Math.max(d[N][0], Math.max(d[N][1], d[N][2])));

        br.close();
    }
}
