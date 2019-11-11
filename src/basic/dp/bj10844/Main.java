package basic.dp.bj10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d[][] = new int[101][10];
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=9; i++){
            d[1][i]=1;
        }
        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                if(j-1>=0)d[i][j]=(d[i][j]+d[i-1][j-1])%1000000000;
                if(j+1<=9)d[i][j]=(d[i][j]+d[i-1][j+1])%1000000000;

            }
        }
        int sum=0;
        for(int i=0; i<=9; i++){
            sum =(sum+ d[N][i])%1000000000;
        }
        System.out.println(sum%1000000000);
        br.close();
    }
}
