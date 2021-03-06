package basic.dp.bj1463.TopDown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int [] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        d = new int[input+1];
        System.out.println(go(input));
    }

    private static int go(int n) {
        if(n==1){
            return 0;
        }
        if(d[n]>0){
            return d[n];
        }
        d[n] = go(n-1)+1;
        if(n%2==0){
            int temp = go(n/2)+1;
            if(temp <d[n]){
                d[n] = temp;
            }
        }
        if(n%3==0){
            int temp = go(n/3)+1;
            if(d[n]>temp){
                d[n] = temp;
            }
        }
        return d[n];
    }
}
