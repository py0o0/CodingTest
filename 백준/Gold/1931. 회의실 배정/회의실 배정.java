import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        xy[] v = new xy[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            v[i] = new xy(s, e);
        }

        Arrays.sort(v, (a, b) -> {
            if(a.e == b.e) return a.s - b.s;
            return a.e - b.e;
        });

        Stack<xy> stk = new Stack<>();
        stk.push(v[0]);

        for(int i = 1; i < n; i++){
            if(stk.peek().e <= v[i].s){
                stk.push(v[i]);
            }
        }
        System.out.println(stk.size());
        
    }
    static class xy{
        int s, e;
        public xy(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

}
