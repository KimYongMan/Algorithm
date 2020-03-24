package algorithm.graph.daikstra.bj1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, K;
    static int [] check;
    static int [] dist;
    static List<List<Node>> g;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = getInteger(st);
        E = getInteger(st);
        g = new ArrayList<>();
        for(int i=0; i<=V; i++){
            g.add(new ArrayList<>());
        }
        check = new int[V+1];
        dist = new int[V+1];
        for(int i=1; i<=V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        K = getInteger(st);
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = getInteger(st);
            int to = getInteger(st);
            int cost = getInteger(st);
            g.get(from).add(new Node(to, cost));
        }
        PriorityQueue<Edge>pq = new PriorityQueue<>(Comparator.comparing(Edge::getCost));
        pq.offer(new Edge(K, 0));
        dist[K]= 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.getFrom();
            int cost = edge.getCost();
            check[from] =1;
            for(Node node : g.get(from)){
                int to = node.getTo();
                if(check[to]!=0){
                    continue;
                }

                int distcost = node.getCost();
                if(dist[to] > cost + distcost){
                    dist[to] = cost + distcost;
                    pq.offer(new Edge(to, dist[to]));
                }

            }
        }
        for(int i=1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }


    }

    private static Integer getInteger(StringTokenizer st) {
        return Integer.valueOf(st.nextToken());
    }
}
class Node{
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
class Edge{
    int from;
    int cost;

    public Edge(int from, int cost) {
        this.from = from;
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public int getCost() {
        return cost;
    }
}

//3 4
//1
//1 3 6
//1 2 2
//2 3 3
//3 2 1
//todo 꺼내왔을 때 check[from] 확인해야 함. check[to]가 아님