package basic.math.bj9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int gcd(int i, int j) {
        if(j==0){
            return i;
        }else{
            return gcd(j, i%j);
        }

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int [] a = new int[N+100];
            for(int i =0; i<N; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            long sum=0;
            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    sum = sum + gcd(a[i], a[j]);
                }
            }
            System.out.println(sum);


        }

        br.close();
    }

}
