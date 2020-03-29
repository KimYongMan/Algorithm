package algorithm.tree.penwicktree.bj2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

//todo 펜윅 트리는 구간에서 "합"만을  구할 때 사용 가능. 그리고 그 구간을 구하는 횟수가 많을 때 사용
//todo 누적합을 이용
//todo 세그먼트 트리에서 오른쪽 자식을 없앤 것과 같음
//todo 구간의 합은 구할 수가 없음, 1~ I번까지의 합만 구할 수가 었음
//todo i & -i = 맨 마지막 1인 값을 나타내게 됨, -i = ~i +1임
public class Main {
    static int N, M, K, Q;
    static long [] tree;
    static int [] value;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M =  Integer.valueOf(st.nextToken());
        K =  Integer.valueOf(st.nextToken());
        Q = M + K;
        tree = new long [N+1];
        value = new int [N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.valueOf(st.nextToken());
            update(i, value[i]);
        }
        for( int q =0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.valueOf(st.nextToken());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            if(t==1){
                int diff = b -value[a];
                value[a]= b;
                update(a, diff);
            }if(t==2){
                System.out.println(penwick(b)-penwick(a-1));
            }
        }
    }

    private static long penwick(int index) {
        long ans = 0;
        for(int i= index; i>0; i-=i&-i){
            ans += tree[i];
        }
        return ans;
    }

    private static void update(int index, int value) {
        for(int i = index; i<=N; i +=i&-i ){
            tree[i]+=value;
        }
    }
}
