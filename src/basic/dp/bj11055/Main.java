package basic.dp.bj11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a [] = new int[N+1];
        int [] d = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            d[i] = a[i];
            for(int j=1; j<i; j++){
                if(a[i]>a[j]){
                    if(d[i]<d[j]+a[i]){
                        d[i] = d[j]+a[i];
                    }
                }
            }
        }
        int ans = d[1];
        for(int i=2;i<=N; i++){
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
        br.close();
    }
}
