package algorithm.tree.mst.kruscal.bj1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int parent[];
    static int N, M;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++){

            parent[i]= i;
        }
        ans = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getCost));
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            pq.offer(new Node(a, b, c));
        }
        while (!pq.isEmpty()){
            Node node = pq.poll();
            int from = node.getFrom();
            int to = node.getTo();
            int cost = node.getCost();
            int x = find(from);
            int y = find(to);
            if(x!=y){
                union(from, to);
                ans += cost;
            }
        }
        System.out.println(ans);

    }
    static void union(int x, int y){
        int a = parent[x];
        int b = parent[y];
        parent[a] = b;
    }
    static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
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

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
