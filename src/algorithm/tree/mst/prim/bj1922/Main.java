package algorithm.tree.mst.prim.bj1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Node>> g;
    static boolean check[];
    static int ans;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.valueOf(st.nextToken());
        g =  new ArrayList<>();
        for(int i=0; i<=N; i++){
            g.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            g.get(a).add(new Node(b, c));
            g.get(b).add(new Node(a, c));
        }
        check = new boolean[N+1];
        ans = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getCost));
        check[1] = true;
        for(int i=0; i<g.get(1).size(); i++){
            pq.offer(g.get(1).get(i));
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int to = node.getTo();
            int cost = node.getCost();
            if(check[to]==true)continue;
            check[to]=true;
            ans+=cost;
            for(int i=0; i< g.get(to).size(); i++){
                int to2 = g.get(to).get(i).getTo();
                if(check[to2]==true)continue;
                pq.offer(g.get(to).get(i));
            }
        }
        System.out.println(ans);
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
