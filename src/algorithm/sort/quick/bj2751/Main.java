package algorithm.sort.quick.bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int N;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.valueOf(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        quicksort(0, N-1);
        for(int a : arr){
            System.out.println(a);
        }

    }

    private static void quicksort(int low, int high) {
        if(low<high){
            int pivot = partition(low , high);
            quicksort(low, pivot-1);
            quicksort(pivot+1, high);
        }

    }

    private static int partition(int low, int high) {
        int index = findPivot(low, high);
        int pivot = arr[index];
        swap(index, high);//피봇을 맨 마지막으로 보냄
        int big = low; //피봇보다 큰 숫자를 저장할 인덱스
        for(int i=low; i<high; i++){//피봇보다 작은 값을 찾으면 큰 값이랑 교환을 함
            if(arr[i] < pivot){
                swap(i, big);
                big++;
            }
        }
        swap(big, high);//맨 마지막값(피봇)과 큰수를 바꾸어서 왼쪽에는 피복보다 작은 수 오른쪽에는 피봇보다 큰수
        return big;
    }

    private static int findPivot(int low, int high) {
        return (high+low)/2;
    }

    private static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
