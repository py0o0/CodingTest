import java.io.*;
import java.util.*;

class Main{

    static ArrayList<Road>[] roads;
    static xy[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        roads = new ArrayList[n + 1];
        dp = new xy[n + 1];

        for(int i = 0; i <= n; i++){
            roads[i] = new ArrayList<>();
            dp[i] = new xy();

            dp[i].x = 0; dp[i].t = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads[s].add(new Road(e,t));
            roads[e].add(new Road(s,t));
        }

        StringBuilder str = new StringBuilder();
        for(int i =  1; i <= n; i++){
            dijkstra(i);
            for(int j = 1; j <= n; j++){
                if(i == j)
                    str.append("- ");
                else str.append(dp[j].x).append(" ");

                dp[j].x = 0;
                dp[j].t = Integer.MAX_VALUE;
            }
            str.append("\n");
        }
        System.out.println(str);
    }

    static void dijkstra(int i){
        dp[i].t = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->a.t-b.t);
        pq.add(new Road(i,0));

        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.next]){

                if(dp[road.next].t > dp[x.next].t + road.t){
                    dp[road.next].t = dp[x.next].t + road.t;
                    if(x.next == i) dp[road.next].x = road.next;
                    else dp[road.next].x = dp[x.next].x;

                    pq.add(new Road(road.next,dp[x.next].t + road.t));
                }
            }
        }

    }

    static class xy{
        int x, t;
    }

    static class Road{
        int next,t;
        Road(int next,int t){
            this.next=next;
            this.t=t;
        }
    }
}