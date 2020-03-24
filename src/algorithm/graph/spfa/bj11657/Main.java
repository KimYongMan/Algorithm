package algorithm.graph.spfa.bj11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//todo 최대 N-1번으로 최단경로가 나와야함. 하지만 벨만포드에서는 음수까지도 계산하기 때문에 N-1번과 N번이 같아야만 최단거리로 인정
//todo 각각에 N번을 수행해서 최단 경로를 찾아내는 것임
public class Main {
    static final int inf = Integer.MAX_VALUE;
    static int N, M;
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        dist = new int [N+1];
        List<Node> g = new ArrayList<>();
        for(int i=1; i<=N; i++){
            dist[i] = inf;
        }
        for(int m=0 ; m<M; m++){
            st = new StringTokenizer(br.readLine());
            g.add(new Node(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()) , Integer.valueOf(st.nextToken())));
        }
        dist[1] = 0;
        boolean cycle = false;
        for(int i=1; i<=N; i++){
            for(Node node : g){
                int from = node.from;
                int to = node.to;
                int cost = node.cost;
                if(dist[from]!=inf && dist[to] > dist[from]+ cost){
                    dist[to] = dist[from]+ cost;
                    if(i==N){
                        cycle = true;
                    }
                }
            }
        }
        if(cycle){
            System.out.println("-1");
        }else {
            for(int i=2; i<=N; i++){
                if(dist[i]==inf)dist[i] = -1;
                System.out.println(dist[i]);
            }
        }
    }
}
class Node{
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
