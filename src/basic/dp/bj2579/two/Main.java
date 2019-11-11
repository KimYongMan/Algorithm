package basic.dp.bj2579.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] a = new int [N+1];
        int [][] d= new int [N+1][3];
        for(int i=1; i<=N; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        d[1][1]=a[1];
        for(int i=2; i<=N; i++){
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + a[i];
            d[i][2] = d[i-1][1] + a[i];
        }
        System.out.println(Math.max(d[N][1], d[N][2]));

        br.close();
    }
}
