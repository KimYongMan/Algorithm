package basic.math.bj1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=5; i<=N; i*=5){
            ans += N/i;
        }
        System.out.println(ans);
        br.close();


    }
}
