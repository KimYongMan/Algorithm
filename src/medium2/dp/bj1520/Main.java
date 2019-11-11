package medium2.dp.bj1520;

import java.util.Scanner;

public class Main {
    static int M, N;
    static int [][] num;
    static int [][] d;
    static int [] dx={1,0,-1,0};
    static int [] dy={0,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        num =new int[M][N];
        d = new int [M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                num[i][j] = sc.nextInt();
                d[i][j]=-1;
            }
        }
        go(0,0);
        System.out.println(d[0][0]);

    }
    static int go(int y, int x){
        if(y==M-1 && x==N-1){
            return 1;
        }
        if(d[y][x]>=0) return d[y][x];
        d[y][x]=0;
        for(int i=0; i<4; i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny>=0 && ny<M && nx>=0 && nx<N){
                if(num[y][x]>num[ny][nx]) d[y][x]+=go(ny, nx);
            }

        }
        return d[y][x];
    }
}
