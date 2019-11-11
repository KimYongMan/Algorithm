package high2.string.kmp.bj1786;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String T;
    static String P;
    static char [] tc;
    static char [] pc;
    static int [] pi;
    static List<Integer> ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextLine();
        P = sc.nextLine();
        tc = T.toCharArray();
        pc = P.toCharArray();
        ans = new ArrayList<>();
        makePi();
        KMP();
        System.out.println(ans.size());
        for(int a : ans){
            System.out.print((a+1)+ " ");
        }
    }

    private static void KMP() {
        int len = tc.length;
        int j=0;
        for(int i=0; i<len; i++){
            while(j>0 && tc[i]!=pc[j]){
                j =pi[j-1];
            }
            if(tc[i]==pc[j]){
                if(j==pc.length-1){
                    ans.add(i-j);
                    j = pi[j];
                }else{
                    j=j+1;
                }

            }
        }
    }

    static void makePi(){
        int len = pc.length;
        pi = new int[len+1];
        pi[0]=0;
        int j=0;
        for(int i=1; i<len; i++){
            while(j>0 && pc[i]!=pc[j]){
                j=pi[j-1];
            }
            if(pc[i]==pc[j]){
                j=j+1;
                pi[i]=j;
            }else{
                pi[i]=0;
            }
        }
    }
}
