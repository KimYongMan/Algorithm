package medium2.lca.bj11437;

import java.util.*;

public class Main {
    static int N;
    static List<Integer> list[];
    static Queue<Integer> q;
    static boolean check[];
    static int parent[];
    static int depth[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        list = new ArrayList[N+1];
        q = new LinkedList<>();
        check = new boolean[N+1];
        parent = new int[N+1];
        depth = new int[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        int start = 1;
        check[start]=true;
        depth[start]=0;
        parent[start]=start;
        q.add(start);
        while(!q.isEmpty()){
            int a = q.poll();
            for(int b : list[a]){
                if(check[b]==false){
                    check[b]=true;
                    depth[b]= depth[a]+1;
                    parent[b]=a;
                    q.add(b);
                }
            }
        }
        int c = sc.nextInt();
        for(int i=0; i<c; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(depth[a] < depth[b]){
                int temp = a;
                a= b;
                b = temp;
            }
            while(depth[a]!=depth[b]){
                a=parent[a];
            }
            while(a!=b){
                a= parent[a];
                b= parent[b];
            }
            System.out.println(a);
        }
    }
}
