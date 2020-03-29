package algorithm.tree.segmenttree.bj10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//todo ㅅㅔ그먼트 트리는 POST Traverse방식이다.
//todo 선처리로 트리를 만드는 엔로그엔, 탐색하는대 로그엔이 걸린다
//todo 수정할 때에는 i~i로 하면은 i에 대한 구간으로 이동하기 때문에 i~i로 구간을 찾아서 업데이트를 해주면 된다
//todo 세그먼트 트리는 구간에서 최소, 최대, 합을 구할 때 사용 가능. 그리고 그 구간을 구하는 횟수가 많을 때 사용
public class Main {
    static int N, M;
    static int tree[];
    static int a[];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        a = new int [N+1];
        int h;
        for(h=1 ; h<N; h*=2);
        h*=2;
        tree = new int[h];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.valueOf(st.nextToken());

        }

        initTree(1, 1, N);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int ans = query(1, 1, N,start, end);
            System.out.println(ans);
        }

    }

    private static void initTree(int index, int start, int end) {
        if(start==end){
            tree[index] = a[start];
            return;
        }
        initTree(index*2, start, (start + end)/2);
        initTree(index*2 +1, (start+end)/2+1, end);
        tree[index] = Math.min(tree[index*2], tree[index*2+1]);
    }

    private static int query(int index, int i, int j, int start, int end) {
        if(j< start || i>end) return -1;
        if(start<=i && j<=end)return tree[index];
        int a =query(index *2, i, (i+j)/2, start, end);
        int b = query(index*2+1, (i+j)/2+1, j, start, end);
        if(a==-1)return b;
        if(b==-1)return a;
        return Math.min(a, b);
    }

//    private static void initTree(int i, int start, int end) {
//        if(start==end){
//            tree[i] = a[start];
//        }
//        initTree(i*2, start, (start + end)/2);
//        initTree(i*2 +1, (start+end)/2+1, end);
//        tree[i] = Math.min(tree[i*2], tree[i*2+1]);
//    }
}
