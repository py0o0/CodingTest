import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Road>[] roads;
    static long[] dp;
    static int[] testTown;
    static int n, m, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n+1];
        dp = new long[n+1];

        for(int i = 0; i <= n; i++){
            roads[i] = new ArrayList<>();
            dp[i] = Long.MAX_VALUE;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads[b].add(new Road(a, t));
        }


        testTown = new int[k];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) testTown[i] = Integer.parseInt(st.nextToken());

        dijkstra();

        long max = 0;
        int idx = 0;
        for(int i = 1; i <= n; i++){
            boolean flag = isTestTown(i);
            if(flag) continue;

            if(max < dp[i]){
                max = dp[i];
                idx = i;
            }
        }
        System.out.println(idx);
        System.out.println(max);
    }

    static boolean isTestTown(int x){
        for(int i = 0; i < k; i++){
            if(testTown[i] == x) return true;
        }
        return false;
    }

    static void dijkstra(){

        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> Long.compare(a.t, b.t));
        for(int i = 0; i < k; i++) {
            int x = testTown[i];
            dp[x] = 0;
            pq.add(new Road(x, 0));
        }

        while(!pq.isEmpty()){
            Road x = pq.poll();
            
            if(x.t > dp[x.x]) continue;
            
            for(Road road : roads[x.x]){
                if(dp[road.x] > dp[x.x] + road.t){
                    dp[road.x] = dp[x.x] + road.t;
                    pq.add(new Road(road.x, dp[road.x]));
                }
            }
        }
    }

    static class Road{
        int x;
        long t;
        public Road(int x, long t){
            this.x = x;
            this.t = t;
        }
    }


}
