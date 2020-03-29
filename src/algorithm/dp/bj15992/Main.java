package algorithm.dp.bj15992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static long [][] d;
    static long f = 1000000009l;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.valueOf(st.nextToken());
        d = new long[1001][1001];
        d[0][0] = 1;
        for(int i=1; i<=1000; i++){
            for(int j=1; j<=1000; j++){
                if(i-1>=0) d[i][j] += d[i-1][j-1] ;
                if(i-2>=0) d[i][j] += d[i-2][j-1] ;
                if(i-3>=0) d[i][j] += d[i-3][j-1] ;
                d[i][j] %=f;
            }
        }
        for( int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());

            System.out.println(d[N][M] % f);
        }


    }
}
