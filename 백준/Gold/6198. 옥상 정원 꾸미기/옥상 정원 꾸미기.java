import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n  = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        long an = 0;

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(stk.isEmpty()){stk.push(x); continue;}

            if(stk.peek() <= x){
                while(!stk.isEmpty() && stk.peek() <= x) stk.pop();
            }
            an += stk.size();
            stk.push(x);
        }
        System.out.println(an);

    }
}