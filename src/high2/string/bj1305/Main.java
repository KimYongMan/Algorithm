package high2.string.bj1305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [] pi;
    static int N;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pi = new int[N];
        input = br.readLine();
        makePi();
        System.out.println(N-pi[N-1]);

        br.close();
    }
    public static void makePi(){
        char [] c = input.toCharArray();
        int len = c.length;
        int j=0;
        pi[0]=0;
        for(int i=1;i<len; i++){
            while(j>0 && c[i]!=c[j]){
                j = pi[j-1];
            }
            if(c[i]==c[j]){
                pi[i]=j+1;
                j=j+1;
            }else{
                pi[i]=0;
            }
        }
    }
}
