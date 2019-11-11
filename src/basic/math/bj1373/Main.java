package basic.math.bj1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int l = s.length();
        int ans=0;
        if(l%3==1){
            System.out.print(s.charAt(0)-'0');
        }
        if(l%3==2){
            System.out.print((s.charAt(0)-'0')*2 + s.charAt(1)-'0');
        }
        for(int i=l%3; i<l;i+=3){
            System.out.print((s.charAt(i)-'0')*4 + (s.charAt(i+1)-'0')*2 + (s.charAt(i+2)-'0'));
        }
        System.out.println();
        br.close();
    }
}
