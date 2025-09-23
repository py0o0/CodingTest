import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        String an = "";
        Stack<Character> stk = new Stack<>();

        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('/', 2);
        map.put('*', 2);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('A' <= c && c <= 'Z') {
                an += c;
                continue;
            }

            if(c == '('){
                stk.push(c);
            }
            else if(c == ')'){
                while(stk.peek() != '('){
                    an += stk.pop();
                }
                stk.pop();
            }
            else if(stk.isEmpty() || stk.peek() == '('){
                stk.push(c);
            }
            else{
                if(map.get(c) <= map.get(stk.peek())){
                    while(!stk.isEmpty() && stk.peek() != '(' && map.get(c) <= map.get(stk.peek())){
                        an += stk.pop();
                    }
                }
                stk.push(c);
            }

        }
        while(!stk.isEmpty()){
            an += stk.pop();
        }
        System.out.println(an);
    }

}