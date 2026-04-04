import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        xy[] v = new xy[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[i] = new xy(a, b);
        }

        Arrays.sort(v, (a, b) -> {
            if(a.s == b.s) return a.e - b.e;
            else return a.s - b.s;
        });

        int cur = v[0].e;
        int an = v[0].e - v[0].s;

        for(int i = 1; i < n; i++){
            if(cur < v[i].s){
                an += v[i].e - v[i].s;
                cur = v[i].e;
            } else if(cur < v[i].e){
                an += v[i].e - cur;
                cur = v[i].e;
            }
        }
        System.out.println(an);
    }

    static class xy{
        int s, e;
        public xy(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
