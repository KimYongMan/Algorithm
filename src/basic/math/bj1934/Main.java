package basic.math.bj1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = gcd(a,b);
            System.out.println(a*b/gcd);
        }

        br.close();
    }
    static int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}
