package basic.math.bj6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = "";
        boolean [] check;
        ArrayList<Integer> ans ;
        check = new boolean[1000000+1];
        ans = new ArrayList<>();
        check[0]=true;
        check[1]=true;
        for(int i=2; i*i <=1000001; i++){
            if(check[i]==true){
                continue;
            }
            ans.add(i);
            for(int j=i+i; j<=1000000; j+=i){
                check[j]=true;
            }
        }
        while(((in=br.readLine())!=null) && in.length()>0){
            int N =Integer.parseInt(in);
            if(N==0){
                break;
            }

            for(int i=1; i<ans.size();i++){
                if(check[N-ans.get(i)]==false){
                    System.out.println(N+ " = " +ans.get(i)+" + "+  (N-ans.get(i)));
                    break;
                }
            }
        }

        br.close();
    }
}
