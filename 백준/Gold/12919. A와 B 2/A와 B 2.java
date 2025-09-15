import java.util.*;
import java.io.*;

public class Main{

    static String str;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        input = br.readLine();
        str = br.readLine();
        if(dfs(str)) System.out.println(1);
        else System.out.println(0);
    }
    static boolean dfs(String str) {
        if(input.length() == str.length()){
            return str.equals(input);
        }

        if(str.charAt(str.length() - 1) == 'A'){
           String s = str.substring(0, str.length() - 1);
           if(dfs(s)) return true;
        }

        if(str.charAt(0) == 'B'){
            String s = str.substring(1);
            s = new StringBuilder(s).reverse().toString();
            if(dfs(s)) return true;
        }
        return false;
    }
}