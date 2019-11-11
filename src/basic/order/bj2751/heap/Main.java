package basic.order.bj2751.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MinHeap heap = new MinHeap(N);
        for(int n=0; n<N; n++){
            heap.push(Integer.parseInt(br.readLine()));
        }
        for(int i=0; i<N; i++){
            System.out.println(heap.top());
            heap.pop();
        }

        br.close();
    }
}
class MinHeap{
    private int size;
    private int [] heap;

    public MinHeap(int n) {
        heap = new int[n+2];
        size=0;
    }
    public int top(){
        return heap[1];
    }
    public void push(int x){
        heap[++size] = x;
        for(int i=size; i>1; i/=2){
            if(heap[i]<heap[i/2]){
                int temp = heap[i/2];
                heap[i/2] = heap[i];
                heap[i] = temp;
            }else{
                break;
            }
        }
    }
    public void pop(){
        heap[1] = heap[size--];
        int child;
        for(int i=1;i*2<=size;i=child){
            child = i*2;
            if(i*2+1<=size && heap[2*i]>heap[2*i+1]){
                child=i*2+1;
            }
            if(heap[i]<heap[child]){
                break;
            }else{
                int temp = heap[i];
                heap[i] = heap[child];
                heap[child] = temp;

            }
        }
    }
    public boolean isEmpty(){
        return size==0;
    }
}