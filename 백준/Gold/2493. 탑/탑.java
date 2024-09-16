import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       int n = Integer.parseInt(br.readLine());
       st = new StringTokenizer(br.readLine());

        Stack<xy> st1 = new Stack<>();
        Stack<xy> st2 = new Stack<>();

       for (int i = 0; i < n; i++) {
           int x = Integer.parseInt(st.nextToken());
           st1.push(new xy(x, i));
       }

       int[] an = new int[n];

       while (!st1.isEmpty()) {
           xy x = st1.pop();
           while(!st2.isEmpty()) {
               if(x.x < st2.peek().x)
                   break;
               xy y = st2.pop();
               an[y.i] = x.i + 1;
           }
           st2.push(x);
       }

       for(int i = 0; i < n; i++)
           System.out.print(an[i] + " ");


    }

    static public class xy{
        int x;
        int i;
        xy(int x, int i){
            this.x = x;
            this.i = i;
        }
    }
}
