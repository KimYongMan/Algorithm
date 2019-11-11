package high2.string.bj1701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        String temp="";
        int ans=0;
        for(int i=len-1;i>=0;i--){
            temp = input.charAt(i)+temp;
            ans = Math.max(ans,findMax(temp));
        }
        System.out.println(ans);
    }
    public static int findMax(String p){
        int max=0;
        int l = p.length();
        int [] pi = new int[l];
        char [] c = p.toCharArray();
        pi[0]=0;
        int j=0;
        for(int i=1;i<l;i++){
            while(j>0 && c[i]!=c[j]){
                j = pi[j-1];
            }
            if(c[i]==c[j]){
                pi[i]=j+1;
                j=j+1;
                max = Math.max(max, pi[i]);
            }else{
                pi[i]=0;
            }
        }


        return max;
    }
}
