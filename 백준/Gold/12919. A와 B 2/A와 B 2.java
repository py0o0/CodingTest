import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int an = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s1 = br.readLine();
        String s2 = br.readLine();


        dfs(s1,s2);
        System.out.println(an);
    }
    public static void dfs(String s1, String s2) {
        if(s1.length() == s2.length()){
            if(s1.equals(s2))
                an = 1;
            return;
        }

        if(s2.charAt(0) == 'B'){
            String s = s2.substring(1);
            s = new StringBuilder(s).reverse().toString();
            dfs(s1,s);
        }

        if(s2.charAt(s2.length() - 1) == 'A'){
            String s = s2.substring(0, s2.length() - 1);
            dfs(s1,s);
        }


    }

}
