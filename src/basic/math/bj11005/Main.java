package basic.math.bj11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        while(N>0){
            int r = N%B;
            if(r<10){
                sb.append((char)(r+'0'));
            }else{
                sb.append((char)(r-10+'A'));
            }
            N = N/B;

        }
        System.out.println(sb.reverse());

        br.close();
    }
}
