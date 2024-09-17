import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<xy>[] g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new ArrayList<>();

        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g[s].add(new xy(e, d));
            g[e].add(new xy(s, d));
        }

        for(int i = 2; i<= n; i++)
            dp[i] = Integer.MAX_VALUE;


        PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.d));
        pq.add(new xy(1,0));

        while(!pq.isEmpty()) {
            xy x = pq.poll();
            int s = x.s;
            for(xy v : g[s]) {
                if(dp[v.s] > dp[s] + v.d) {
                    dp[v.s] = dp[s] + v.d;
                    pq.add(new xy(v.s, dp[v.s]));
                }
            }
        }
        System.out.println(dp[n]);
    }

    static public class xy{
        int s;
        int d;
        xy(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }


}
