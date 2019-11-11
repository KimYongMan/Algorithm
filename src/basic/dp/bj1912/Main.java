package basic.dp.bj1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] a = new int[N+1];
        int [] d = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            d[i] = a[i];
            if(i==0) continue;
            if(d[i]<d[i-1]+a[i]){
                d[i] = d[i-1]+a[i];
            }
        }
        int ans = d[0];
        for(int i=1; i<N; i++){
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);

        br.close();
    }
}
