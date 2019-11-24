package algorithm.sort.compare.bj11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.valueOf(br.readLine());
        PriorityQueue<Point> pq = new PriorityQueue<Point>(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Point(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())));
        }
        while(!pq.isEmpty()){
            Point p = pq.poll();
            System.out.println(p.getX() + " " + p.getY());
        }

    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
