import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) v[i] = Integer.parseInt(st.nextToken());

        int[] an = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(v[n - 1]);
        an[n - 1] = -1;

        for(int i = n - 2; i >= 0; i--) {
            if(stk.peek() <= v[i]){
                while(!stk.isEmpty() && stk.peek() <= v[i]) stk.pop();
            }
            an[i] = (stk.isEmpty() ? -1 : stk.peek());
            stk.push(v[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(an[i]).append(" ");
        System.out.println(sb);


    }
}