package basic.math.bj2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int l = N.length();
        int B = Integer.parseInt(st.nextToken());
        int ans =0;
        for(int i=0; i<l ; i++){
            char c = N.charAt(i);
            if(c>='0' && c<='9'){
                ans = ans * B +( c-'0');
            }else{
                ans = ans * B +( c-'A'+10);
            }
        }
        System.out.println(ans);
        br.close();
    }
}
