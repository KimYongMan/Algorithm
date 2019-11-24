package algorithm.sort.merge.bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int [] arr;
    static int [] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        ans = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }

        mergesort(0, N-1);
        for(int a : arr){
            System.out.println(a);
        }
    }

    private static void mergesort(int l, int r) {
        if(r - l<2){
            if(arr[l] > arr[r]){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            return;
        }
        int half = (l + r)/2;
        mergesort(l, half);
        mergesort(half+1, r);
        int idx = l;
        int li =l;
        int ri = half+1;
        while(li<=half && ri<=r){
            if(arr[li]>arr[ri])ans[idx++] = arr[ri++];
            else ans[idx++] = arr[li++];
        }
        while(li<=half)ans[idx++]=arr[li++];
        while(ri<=r)ans[idx++]=arr[ri++];

        for(int i=l; i<=r; i++){
            arr[i] = ans[i];
        }
    }
}
