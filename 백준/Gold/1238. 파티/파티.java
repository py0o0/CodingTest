import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Road>[] roads;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n+1];
        dp = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            roads[i] = new ArrayList<>();
            for(int j = 0; j <= n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            roads[a].add(new Road(b, t));
        }

        for(int i = 1; i <= n; i++){
            dijkstra(i);
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(i == x) continue;
            max = Math.max(dp[i][x] + dp[x][i], max);
        }
        System.out.println(max);
    }
    static class Road{
        int next, t;
        public Road(int next, int t) {
            this.next = next;
            this.t = t;
        }
    }

    static void dijkstra(int i){
        dp[i][i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> a.t - b.t);
        pq.add(new Road(i, 0));
        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.next]){
                if(dp[i][road.next] > dp[i][x.next] + road.t){
                    dp[i][road.next] = dp[i][x.next] + road.t;
                    pq.add(new Road(road.next, dp[i][x.next] + x.t));
                }
            }
        }
    }
}
