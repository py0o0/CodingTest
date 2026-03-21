import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s1 = br.readLine();
        String s2 = br.readLine();

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s1.length(); i++) {
            stk.push(s1.charAt(i));
            if (stk.peek() == s2.charAt(s2.length() - 1) && stk.size() >= s2.length()) {
                boolean flag = true;
                for (int j = 1; j <= s2.length(); j++) {
                    if (stk.get(stk.size() - j) != s2.charAt(s2.length() - j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 1; j <= s2.length(); j++)
                        stk.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char x : stk) sb.append(x);
        if (sb.length() == 0) sb.append("FRULA");
        System.out.println(sb);
    }

}
