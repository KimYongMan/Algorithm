package basic.dp.bj2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long []d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int len = in.length();
        d = new long[len+1];
        if(in.charAt(0)=='0'){
            d[1]=0;
        }else {
            d[1] = 1;
        }
        d[0]=1;
        for(int i=2; i<=len; i++){
            int c = in.charAt(i-1)-'0';
            if(c>=1 && c<=9){
                d[i]=d[i-1]%1000000;

            }
            int e = in.charAt(i-2)-'0';
            int t =e*10 + c;
            if(t>=10 && t<=26){
                d[i] = (d[i]+d[i-2])%1000000;

            }
        }
        System.out.println(d[len]);

        br.close();
    }

}
