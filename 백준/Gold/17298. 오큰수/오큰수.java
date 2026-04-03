import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stk = new Stack<>();

        int[] an = new int[n];

        for(int i = n - 1; i >= 0; i--){

            while(!stk.isEmpty() && stk.peek() <= v[i]) stk.pop();

            if(stk.isEmpty()) an[i] = -1;
            else an[i] = stk.peek();
            stk.push(v[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(an[i]).append(" ");
        System.out.println(sb);

        
    }

}
