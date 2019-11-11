package basic.structure.bj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackR = new Stack<>();
        String input = br.readLine();

        for(int i=0; i<input.length(); i++){
            stackL.push(input.charAt(i));
        }
        input = br.readLine();
        int M = Integer.parseInt(input);
        StringTokenizer st;
        for (int m = 0; m <M ; m++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if(command=='L'){
                if(!stackL.isEmpty()){
                    stackR.push(stackL.pop());
                }
            }else if(command=='D'){
                if(!stackR.isEmpty()){
                    stackL.push(stackR.pop());
                }
            }else if(command=='B'){
                if(!stackL.isEmpty()){
                    stackL.pop();
                }
            }else if(command=='P'){
                stackL.push(st.nextToken().charAt(0));
            }
        }
        while(!stackL.isEmpty()){
            stackR.push(stackL.pop());
        }
        while(!stackR.isEmpty()){
            System.out.print(stackR.pop());
        }
    }
}
