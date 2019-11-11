package medium2.dp.bj10942;
//todo 재귀함수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [][]d;
    static int a[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.valueOf(br.readLine());
        a = new int [N+1];
        d = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i]= Integer.valueOf(st.nextToken());
            Arrays.fill(d[i],-1);
        }

        int M = Integer.valueOf(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            sb.append(go(a-1, b-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int go(int x, int y){
        if(x==y){
            return 1;
        }
        if(x+1==y){
            if(a[x]==a[y]){
                return 1;
            }else{
                return 0;
            }
        }
        if(d[x][y]!=-1){
            return d[x][y];
        }
        if(a[x]==a[y]){
            return d[x][y]=go(x+1,y-1);
        }else{
            return  0;
        }
    }
}
