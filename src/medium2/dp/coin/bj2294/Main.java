package medium2.dp.coin.bj2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        int [] d = new int[K+1];
        Arrays.fill(d, -1);
        d[0]=0;

        for(int i=0;i<N; i++){
            for(int j=1; j<=K; j++){
                if(j-num[i]>=0 && d[j-num[i]]!=-1){
                    if(d[j]==-1 || d[j]>d[j-num[i]]+1){
                        d[j] = d[j-num[i]]+1;
                    }
                }
            }
        }
        System.out.println(d[K]);
    }
}
