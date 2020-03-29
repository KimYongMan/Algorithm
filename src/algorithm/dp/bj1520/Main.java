package algorithm.dp.bj1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static long [][] map, d;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        map = new long [M+1][N+1];
        d = new long [M+1][N+1];
        for(int m=1; m<=M; m++ ){
            st = new StringTokenizer(br.readLine());
            for(int n=1 ; n<=N; n++){
                map[m][n] = Integer.valueOf(st.nextToken());
                d[m][n]= -1;
            }
        }
        System.out.println(go(1,1));


    }

    private static long go(int x, int y) {
        if(x==M && y==N)return 1;
        if(d[x][y]!=-1) return d[x][y];
        d[x][y]=0;
        for(int k=0; k<4; k++){
            int i = x+dx[k];
            int j = y+dy[k];
            if(i>=1 && i<=M && j>=1 && j<=N){
                if(map[x][y]> map[i][j]){
                    d[x][y] += go(i,j);
                }

            }
        }
        return d[x][y];
    }
}
