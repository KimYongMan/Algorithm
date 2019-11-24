package algorithm.tree.traverse.bj1991;

import java.util.Scanner;

public class Main {
    static int N;
    static Node[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nodes = new Node[N];
        for (int n = 0; n < N; n++) {
            int p = sc.next().charAt(0) - 'A';
            int left = -1;
            int right = -1;

            char l = sc.next().charAt(0);
            if (l != '.') {
                left = l - 'A';
            }
            char r = sc.next().charAt(0);
            if (r != '.') {
                right = r - 'A';
            }
            nodes[p] = new Node(left, right);
        }
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
    static void preorder(int v){
        if(v==-1)return;
        System.out.print((char)(v+'A'));
        preorder(nodes[v].left);
        preorder(nodes[v].right);
    }
    static void inorder(int v){
        if(v==-1)return;
        inorder(nodes[v].left);
        System.out.print((char)(v+'A'));
        inorder(nodes[v].right);
    }
    static void postorder(int v){
        if(v==-1)return;
        postorder(nodes[v].left);
        postorder(nodes[v].right);
        System.out.print((char)(v+'A'));

    }
}

class Node{
    int left;
    int right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}