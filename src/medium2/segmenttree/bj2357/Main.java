package medium2.segmenttree.bj2357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//todo 최소값과 최대값
public class Main {
    static int N, M;
    static long a[];
    static long ans;
    static long tree[];
    static long treemax[];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        a = new long[N+1];
        ans = 0;

        tree = new long[(1<<N)+1];
        treemax=new long[(1<<N)+1];
        Arrays.fill(tree, -1);
        for(int i=1; i<=N; i++){
            a[i] = Long.valueOf(br.readLine());
        }
        init(1, 1, N);
        initmax(1,1,N);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            System.out.println(min(1, 1, N, a,b)+ " " + max(1, 1, N, a,b));
        }
    }
    static long init(int node, int start, int end){
        if(start==end){
            return tree[node]=a[start];
        }
        return tree[node] = Math.min(init(node*2, start, (start+end)/2), init(node*2+1, (start+end)/2+1, end));
    }
    static long min(int node, int start, int end, int i, int j){
        if(start>j || end <i){
            return -1;
        }
        if(start>=i && end <=j){
            return tree[node];
        }
        long a = min(node*2, start, (start+end)/2, i, j);
        long b = min(node*2+1, (start+end)/2+1, end, i, j);
        if(a==-1)return b;
        if(b==-1) return a;
        return Math.min( a, b);
    }
    static long initmax(int node, int start, int end){
        if(start==end){
            return treemax[node]=a[start];
        }
        return treemax[node] = Math.max(initmax(node*2, start, (start+end)/2), initmax(node*2+1, (start+end)/2+1, end));
    }
    static long max(int node, int start, int end, int i, int j){
        if(start>j || end <i){
            return -1;
        }
        if(start>=i && end <=j){
            return treemax[node];
        }
        return Math.max(max(node*2, start, (start+end)/2, i, j), max(node*2+1, (start+end)/2+1, end, i, j));
    }

}
