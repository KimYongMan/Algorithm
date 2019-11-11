package basic.inoutput.bj11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char []temp = input.toCharArray();
        for(int i=1; i<= temp.length; i++){
            System.out.print(temp[i-1]);
            if(i%10==0){
                System.out.println();
            }
        }
    }
}
