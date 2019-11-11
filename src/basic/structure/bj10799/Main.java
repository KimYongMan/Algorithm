package basic.structure.bj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int sum=0;
        String input = br.readLine();
        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);
            if(temp=='('){
                stack.push(i);
            }else{
                int idx = stack.pop();
                if(i-idx==1){
                    sum+=stack.size();
                }else{
                    sum+=1;
                }
            }
        }
        System.out.println(sum);
    }
}
