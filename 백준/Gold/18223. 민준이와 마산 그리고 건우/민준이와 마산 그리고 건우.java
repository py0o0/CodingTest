import java.io.*;
import java.util.*;

class Main{

    static ArrayList<Road>[] roads;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        dp = new long[n + 1];

        for(int i = 0; i < n + 1; i++){
            roads[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            roads[s].add(new Road(e,t));
            roads[e].add(new Road(s,t));
        }

        dijkstra(1);
        long a = dp[n]; // 1->n
        long b = dp[target]; // 1->target

        dijkstra(target);
        long c = dp[n]; // target->n

        if(a == b + c)
            System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }

    static void dijkstra(int i){
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[i] = 0;

        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->Long.compare(a.t,b.t));
        pq.add(new Road(i,0));
        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.e]){
                if(dp[road.e] > dp[x.e] + road.t){
                    dp[road.e] = dp[x.e] + road.t;
                    pq.add(new Road(road.e,dp[road.e]));
                }
            }
        }
    }

    static class Road{
        int e;
        long t;
        Road(int e, long t){
            this.e = e;
            this.t = t;
        }
    }


}