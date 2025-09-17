import java.util.*;
import java.io.*;

public class Main{

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            n = Integer.parseInt(br.readLine());
            dfs(2, "1");
            System.out.println();
        }

    }
    public static void dfs(int cur, String s){
        if(cur > n){
            if(zero(s))
                System.out.println(s);
            return;
        }
        dfs(cur + 1, s + " " + cur);
        dfs(cur + 1, s + "+" + cur);
        dfs(cur + 1, s + "-" + cur);
    }
    static boolean zero(String s){
        int val = 0;
        int x = 0;
        char ch = '+';
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;
            if(Character.isDigit(s.charAt(i))){
                x = x * 10 + (s.charAt(i) - '0');
            }
            else{
                if(ch == '+') val += x;
                else val -= x;

                x = 0;
                ch = s.charAt(i);
            }
        }
        if(ch == '+') val += x;
        else val -= x;

        return (val == 0);
    }
}