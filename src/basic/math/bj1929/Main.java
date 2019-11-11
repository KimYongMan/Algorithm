package basic.math.bj1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        check =new boolean[N+1];
        check[0]=true;
        check[1]=true;
        checkm(M, N);
        for(int i=M; i<=N; i++){
            if(check[i]==false){
                System.out.println(i);
            }
        }
        br.close();
    }
    static void checkm(int m, int n){

            for(int i=2; i*i<=n; i++){
                if(check[i]==true){
                    continue;
                }
                for(int j=i+i; j<=n; j+=i){

                    check[j]=true;
                }
            }

    }
}
