package algorithm.bfs.bj16973;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, W, sx, sy, fx, fy;
    static int [][] map, dist, sum;
    static int [] dx={1,0,-1,0};
    static int [] dy={0,1, 0, -1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int [N+1][M+1];
        dist = new int [N+1][M+1];
        sum = new int [N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
                dist[i][j] = -1;
                sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + map[i][j];

            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.valueOf(st.nextToken());
        W = Integer.valueOf(st.nextToken());
        sx = Integer.valueOf(st.nextToken());
        sy = Integer.valueOf(st.nextToken());
        fx = Integer.valueOf(st.nextToken());
        fy = Integer.valueOf(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, sy));
        dist[sx][sy] = 0;
        while(!q.isEmpty()){
            Node n = q.poll();
            int x = n.getX();
            int y = n.getY();
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y + dy[k];
                if(nx>=1 && nx+H-1<=N && ny>=1 && ny+W-1<=M){
                    if(isMove(nx, ny, nx+H-1, ny+ W -1)==0){
                        if(dist[nx][ny]==-1){
                            q.offer(new Node(nx, ny));
                            dist[nx][ny] = dist[x][y] +1;
                        }

                    }
                }
            }
        }
        System.out.println(dist[fx][fy]);

    }

    private static int isMove(int nx, int ny, int i, int j) {
        return sum[i][j] - sum[nx-1][j] - sum[i][ny-1] + sum[nx-1][ny-1];
    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}