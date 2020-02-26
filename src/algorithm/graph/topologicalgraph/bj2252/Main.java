package algorithm.graph.topologicalgraph.bj2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int [] indegree;
    static List<List<Integer>> graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        indegree = new int[N+1];
        graph = new ArrayList<>();
        for(int n=0; n<=N; n++){
            graph.add(new ArrayList<Integer>());
        }
        for(int m=0 ; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            indegree[b]++;
            graph.get(a).add(b);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int a = q.poll();
            System.out.print(a+" ");
            List<Integer> list  = graph.get(a);
            for(int i=0; i<list.size(); i++){
                int b = list.get(i);
                indegree[b]--;
                if(indegree[b]==0){
                    q.offer(b);
                }
            }
        }

    }
}
