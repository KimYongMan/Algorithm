package medium2.dp.coin.bj2293;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] num = new int[N];
        int [] d = new int[K+1];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }
        d[0]=1;
        for(int i=0; i<N; i++){
            for(int j=1; j<=K; j++){
                if(j-num[i]>=0){
                    d[j]+=d[j-num[i]];
                }

            }
        }
        System.out.println(d[K]);
    }
}
