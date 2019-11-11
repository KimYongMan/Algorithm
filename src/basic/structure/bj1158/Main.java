package basic.structure.bj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String [] temp = input.split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        System.out.print("<");
        for(int i=0; i<N-1; i++){
            for(int m=0; m<M; m++){
                if(m==M-1){
                    System.out.print(q.poll());
                }else{
                    q.offer(q.poll());
                }


            }
            System.out.print(", ");
        }
        System.out.print(q.poll());
        System.out.print(">");
        br.close();
    }
}
