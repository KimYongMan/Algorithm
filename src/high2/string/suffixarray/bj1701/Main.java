package high2.string.suffixarray.bj1701;

public class Main {
    public static void main(String[] args) {

    }
}
class SuffixArray{
    Integer sa[];
    String s;
    char [] c;
    int n;
    Integer [][] group;
    int [] lcp;
    SuffixArray(String s){
        this.s=s;
        this.n = s.length();
        this.c = s.toCharArray();
        sa = new Integer [n+1];
        group = new Integer [22][n+1];
        lcp = new int [n+1];

    }
    void makeSa(){
        for(int i=0; i<n; i++){
            sa[i]=i;
        }
        for(int i=0;i<n; i++){
            group[0][i]=c[i]-'a';
        }
        group[0][n]=-1;
        int last =0;
        for(int k=0,len=1; len/2 <n;len*=2, k++ ){
            
        }
    }

}
