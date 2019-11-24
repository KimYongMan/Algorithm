package algorithm.sort.heap.bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        MinHeap heap = new MinHeap(N);
        for(int i = 0; i<N; i++){
            heap.add(Integer.valueOf(br.readLine()));
        }
        while(!heap.isEmpty()){
            System.out.println(heap.top());
            heap.pop();
        }

    }
}
class MinHeap{
    int [] data;
    int idx;
    MinHeap(int size){
        data = new int[size+1];
        this.idx = 0;
    }
    void add(int x){
        data[++idx] = x;
        for(int i = idx; i>1; i/=2){
            int parent = i/2;
            if(data[parent] > data[i]){
                int temp = data[parent];
                data[parent] = data[i];
                data[i] = temp;
            }else{
                break;
            }
        }

    }
    void pop(){
        data[1] = data[idx--];
        int child;
        for(int i =1; i*2<=idx; i=child){
            child = 2*i;
            if( (child+1 <= idx) && (data[child+1] < data[child])){
                child=child+1;
            }
            if(data[i] > data[child]){
                int temp = data[i];
                data[i] = data[child];
                data[child] = temp;
            }else{
                break;
            }
        }


    }
    int top(){
        return data[1];
    }
    boolean isEmpty(){
        return idx==0;
    }
}
