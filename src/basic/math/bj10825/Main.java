package basic.math.bj10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Student> al = new ArrayList<>();
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            al.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(al);
        for(Student s : al){
            System.out.println(s.name);
        }
        br.close();
    }
}
class Student implements Comparable{
    String name;
    int k;
    int eng;
    int math;

    public Student(String name, int k, int eng, int math) {
        this.name = name;
        this.k = k;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Object o) {
        if(Integer.compare(k,((Student)o).k)>0){
            return -1;
        }else if(this.k == ((Student)o).k){
            if(this.eng < ((Student)o).eng){
                return -1;
            }else if(this.eng == ((Student)o).eng){
                if(this.math > ((Student)o).math){
                    return -1;
                }else if(this.math == ((Student)o).math){
                    return this.name.compareTo(((Student)o).name);

                }

            }
        }
        return 1;
    }
}