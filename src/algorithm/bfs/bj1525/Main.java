package algorithm.bfs.bj1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [] dx={1,0,-1,0};
    static int [] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][] map = new int [3][3];
        StringTokenizer st;
        int start = 0;
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3;j++){

                map[i][j] = Integer.valueOf(st.nextToken());
                if(map[i][j]==0){
                    map[i][j] = 9;
                }
                start = start*10 + map[i][j];
            }
        }
        Queue<Integer>q = new LinkedList<>();
        Map<Integer, Integer> store = new HashMap<>();
        q.offer(start);
        store.put(start, 0);
        while(!q.isEmpty()){
            int v = q.poll();
            String num = Integer.toString(v);
            int index = num.indexOf('9');
            int x = index / 3;
            int y = index %3;
            for(int i=0; i<4; i++){
                int nextx = x+dx[i];
                int nexty = y+dy[i];
                if((nextx>=0 && nextx <3) && (nexty>=0 && nexty <3)){
                    StringBuilder sb = new StringBuilder(num);
                    char temp = sb.charAt(x*3+y);
                    sb.setCharAt(x*3+y, sb.charAt(nextx* 3+ nexty));
                    sb.setCharAt(nextx*3 + nexty, temp);
                    int key = Integer.valueOf(sb.toString());
                    if(!store.containsKey(key)){
                        store.put(key, store.get(v)+1);
                        q.offer(key);
                    }
                }
            }
        }
        if(store.containsKey(123456789)){
            System.out.println(store.get(123456789));
        }else{
            System.out.println(-1);
        }


    }
}
