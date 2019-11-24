package algorithm.queue.bj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        Queue q = new Queue();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int val = Integer.valueOf(st.nextToken());
                q.offer(val);
            }else if(cmd.equals("pop")){
                System.out.println(q.pull());
            }else if(cmd.equals("size")){
                System.out.println(q.size());
            }else if(cmd.equals("front")){
                System.out.println(q.front());
            }else if(cmd.equals("back")){
                System.out.println(q.back());
            }else if(cmd.equals("empty")){
                if(q.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }

    }
}
class Queue{
    int front;
    int end;
    int [] data;

    public Queue() {
        this.front=0;
        this.end=0;
        this.data=new int[100000];
    }
    public void offer(int val){
        data[end++] = val;
    }

    public int size(){
        return end - front;
    }
    public boolean isEmpty(){
        return front==end;
    }
    public int pull(){
        if(isEmpty()){
            return -1;
        }
        return data[front++];
    }
    public int front(){
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }
    public int back(){
        if(isEmpty()){
            return -1;
        }
        return data[end-1];
    }
}