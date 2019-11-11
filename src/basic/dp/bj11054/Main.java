package basic.dp.bj11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] a = new int [N+1];
        int [] d = new int[N+1];
        int [] d1 = new int [N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++ ){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            d[i]=1;
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && d[i]<d[j]+1){
                    d[i] = d[j]+1;
                }
            }
        }
        for(int i=N-1; i>=0; i--){
            d1[i]=1;
            for(int j=i+1;j<N;j++){
                if(a[i]>a[j] && d1[i] <d1[j]+1){
                    d1[i] = d1[j]+1;
                }
            }
        }
        int ans = d[0] + d1[0]-1;
        for(int i=1; i<N; i++){
            ans = Math.max(ans, d[i]+d1[i]-1);
        }
        System.out.println(ans);

        br.close();
    }
}
