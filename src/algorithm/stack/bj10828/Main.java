package algorithm.stack.bj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        Stack stack = new Stack();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int val = Integer.valueOf(st.nextToken());
                stack.push(val);

            }else if(cmd.equals("pop")){
                System.out.println(stack.pop());
            }else if(cmd.equals("size")){
                System.out.println(stack.size);
            }else if(cmd.equals("top")){
                System.out.println(stack.top());
            }else if(cmd.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
    }
}
class Stack{
    int [] data = new int[100000];
    int size;

    public Stack() {
        this.size = 0;
    }
    public void push(int val){
        data[size++] = val;
    }
    public int top(){
        if(isEmpty()){
            return -1;
        }else{
            return data[size-1];
        }
    }
    public int pop(){
        if(isEmpty()){
            return -1;
        }else{
            return data[--size];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
