import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Road>[] roads;
    static long[][] dp;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n+1];
        dp = new long[n+1][n + 1];

        for(int i = 0; i <= n; i++) {
            roads[i] = new ArrayList<>();
            for(int j = 0; j <= n; j++)
                dp[i][j] = Long.MAX_VALUE;

        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());

            roads[x].add(new Road(y, t));
            roads[y].add(new Road(x, t));
        }



        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        dijkstra(v1);
        dijkstra(v2);

        if(dp[1][v1] == Long.MAX_VALUE || dp[v1][v2] == Long.MAX_VALUE || dp[v2][n] == Long.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        long an = Math.min(dp[1][v1] + dp[v1][v2] + dp[v2][n], dp[1][v2] + dp[v2][v1] + dp[v1][n]);
        System.out.println(an);
    }

    static void dijkstra(int i){
        dp[i][i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> Long.compare(a.t, b.t));
        pq.add(new Road(i, 0));

        while(!pq.isEmpty()){
            Road x = pq.poll();
            if(dp[i][x.x] < x.t) continue;

            for(Road road : roads[x.x]){
                if(dp[i][road.x] > dp[i][x.x] + road.t){
                    dp[i][road.x] = dp[i][x.x] + road.t;
                    pq.add(new Road(road.x, dp[i][road.x]));
                }
            }
        }
    }

    static class Road{
        int x;
        long t;
        public Road(int x, long t) {
            this.x = x;
            this.t = t;
        }
    }


}
