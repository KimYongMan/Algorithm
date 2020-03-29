package algorithm.dp.bj1937;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int map[][];
    static int [][] d;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        map = new int [N+1][N+1];
        d = new int [N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                ans = Math.max(ans, go(i, j));
            }
        }
        System.out.println(ans);

    }

    private static int go(int i, int j) {
        if(d[i][j]!=0){
            return d[i][j];
        }
        d[i][j]=1;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x>=1 && x<=N && y>=1 && y<=N){
                if(map[i][j]<map[x][y]){
                    d[i][j] = Math.max(d[i][j], go(x, y)+1);
                }
            }
        }
        return d[i][j];

    }
}
