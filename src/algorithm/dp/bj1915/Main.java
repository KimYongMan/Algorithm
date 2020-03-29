package algorithm.dp.bj1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int [][]d, map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        d = new int [N+1][M+1];
        map = new int [N+1][M+1];
        ans = 0;
        for(int i=1; i<=N; i++){
            String num = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = num.charAt(j-1)-'0';

            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j] ==1){
                    d[i][j] = Math.min(d[i-1][j], Math.min(d[i-1][j-1],d[i][j-1]) )+1;
                    ans = Math.max(ans,d[i][j]);
                }
            }
        }
        System.out.println(ans * ans);
    }
}
