import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        xy[] v = new xy[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            v[i] = new xy(s, e);
        }

        Arrays.sort(v, (a, b) -> {
            if(a.s == b.s) return a.e - b.e;
            return a.s - b.s;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int an = 1;
        for(int i = 0; i < n; i++){
            if(!pq.isEmpty() && pq.peek() <= v[i].s){
                while(!pq.isEmpty() && pq.peek() <= v[i].s) pq.poll();
            }
            pq.add(v[i].e);
            an = Math.max(an, pq.size());
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
