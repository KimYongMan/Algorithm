package basic.math.bj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int n=0; n<N; n++){
            if(check(Integer.parseInt(st.nextToken()))){
                ans +=1;
            }
        }
        System.out.println(ans);

        br.close();
    }
    static boolean check(int n){
        if(n<2){
            return false;
        }else{
            for(int i=2; i*i<=n;i++){
                if(n%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
