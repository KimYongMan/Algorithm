package algorithm.bfs.bj17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, ans;
    static int [][] time = new int [500001][2];
    static int [] cal = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());
        Queue<Node> q = new LinkedList<>();
        for(int[] row : time){
            Arrays.fill(row, -1);
        }

        time[N][0] = 0;
        q.offer(new Node(N, 0));
        while(!q.isEmpty()){
            Node n = q.poll();
            int x = n.getDist();
            int p = n.getP();
            int dx[] =  {x*2, x+1, x-1};
            for(int y : dx){
                if(y>=0 && y<=500000){
                    if(time[y][1-p]==-1){
                        time[y][1-p] = time[x][p]+1;
                        q.add(new Node(y, 1-p));
                    }
                }
            }
        }
        ans = -1;
        for(int t=0; t<=500000; t++){
            K = K+t;
            if(K>500000) break;;
            if(time[K][t%2]<=t){
                ans = t;
                break;
            }

        }
        System.out.println(ans);

    }
}
class Node{
    int dist;
    int p;

    public Node(int dist, int p) {
        this.dist = dist;
        this.p = p;
    }

    public int getDist() {
        return dist;
    }

    public int getP() {
        return p;
    }
}
