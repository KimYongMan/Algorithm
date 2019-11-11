package basic.math.bj1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] eight = {"000","001","010", "011", "100", "101", "110", "111"};
        String s = br.readLine();
        int len = s.length();
        boolean start = true;
        if(s.length()==1 && s.charAt(0)=='0'){
            System.out.print("0");
        }
        for(int i=0; i<len; i++){
            int c = s.charAt(i)-'0';
            if(start==true && c<4){
                if(c==0){
                    continue;
                }
                if(c==1){
                    System.out.print("1");
                }
                if(c==2){
                    System.out.print("10");
                }
                if(c==3){
                    System.out.print("11");
                }
                start=false;
            }else{
                System.out.print(eight[c]);
                start=false;
            }

        }
        System.out.println();
        br.close();
    }
}
