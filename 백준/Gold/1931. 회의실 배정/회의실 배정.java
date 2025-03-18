import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        xy[] v = new xy[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].s = Integer.parseInt(st.nextToken());
            v[i].e = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(v,(a,b)->{
            if(a.e == b.e) return a.s - b.s;
            return a.e - b.e;
        });
        Stack<xy> stk =  new Stack<>();
        stk.push(v[0]);

        for(int i = 1; i < n; i++){
            if(stk.peek().e <= v[i].s) stk.push(v[i]);
        }
        System.out.println(stk.size());
    }
    static class xy{
        int s,e;
    }


}