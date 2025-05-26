import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Road>[] roads;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            roads = new ArrayList[n + 1];
            dp = new int[n + 1];

            for(int i = 0; i <= n; i++) {
                roads[i] = new ArrayList<>();
                dp[i] = Integer.MAX_VALUE;
            }

            while(m-- > 0){
                st = new StringTokenizer(br.readLine());
                int e = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());

                roads[s].add(new Road(e,dis));
            }

            dijkstra(x);

            int cnt = 0;
            int max = 0;

            for(int i = 0; i <= n; i++){
                if(dp[i] == Integer.MAX_VALUE) continue;
                cnt++; max = Math.max(max, dp[i]);
            }
            System.out.println(cnt + " " + max);

        }

    }

    static void dijkstra(int i){
        dp[i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->a.dis-b.dis);
        pq.add(new Road(i,0));

        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.x]){
                if(dp[road.x] > dp[x.x] + road.dis){
                    dp[road.x] = dp[x.x] + road.dis;
                    pq.add(new Road(road.x,dp[road.x]));
                }
            }
        }
    }

    static class Road{
        int x,dis;
        Road(int x,int dis){
            this.x = x;
            this.dis = dis;
        }
    }

}