package basic.dp.bj11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][]d = new int[1001][10];
        for(int i=0; i<=9; i++){
            d[1][i]=1;
        }
        for(int i=2;i<=N;i++){
            for(int j=0;j<=9;j++){
                for(int k=0; k<=j; k++){
                    d[i][j]= (d[i][j]+d[i-1][k])%10007;
                }
            }
        }
        int sum=0;
        for(int i=0; i<=9; i++){
            sum = (sum +d[N][i])%10007;
        }
        System.out.println(sum);
        br.close();

    }
}
