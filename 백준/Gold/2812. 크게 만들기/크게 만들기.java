import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < line.length(); i++){
            char x = line.charAt(i);

            while(!stk.isEmpty() && k > 0 && stk.peek() < x){
                stk.pop();
                k--;
            }
            stk.push(x);
        }
        while(k > 0){
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        System.out.println(sb.reverse());
    }


}
