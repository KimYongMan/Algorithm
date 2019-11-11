package basic.structure.bj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String input = br.readLine();
            String result = valid(input);
            System.out.println(result);

        }
    }

    private static String valid(String input) {
        int cnt=0;
        for(int i=0; i<input.length();i++){
            if(input.charAt(i)=='('){
                cnt+=1;
            }else{
                cnt-=1;
            }
            if(cnt<0){
                return "NO";
            }
        }
        if(cnt==0){
            return "YES";
        }else{
            return "NO";
        }
    }
}
