import java.io.*;
import java.util.*;

class Main{

    static ArrayList<Road>[] roads;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n,m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        for(int i=0;i<=n;i++){
            roads[i] = new ArrayList<>();
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads[s].add(new Road(e, t));
            roads[e].add(new Road(s, t));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(a,0);
        dijkstra(b,1);

        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++){
            if(i == a || i == b) continue;
            min = Math.min(min, dp[i][0] + dp[i][1]);
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(i == a || i == b) continue;
            int x = dp[i][0] + dp[i][1];
            if(x == min){
                if(dp[i][0] <= dp[i][1]) arr.add(i);
            }
        }

        if(arr.size() == 0){
            System.out.println(-1); return;
        }

        int dis = dp[arr.get(0)][0];
        int an = arr.get(0);

        for(int i = 1; i< arr.size(); i++){
            int dis1 = dp[arr.get(i)][0];
            if(dis > dis1){
                dis = dis1; an = arr.get(i);
            }
        }
        System.out.println(an);
    }


    static void dijkstra(int a,int b){
        dp[a][b] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((c,d)-> c.t-d.t);
        pq.add(new Road(a, 0));

        while(!pq.isEmpty()){
            Road r = pq.poll();
            for(Road road : roads[r.x]){
                if(dp[road.x][b] > dp[r.x][b] + road.t){
                    dp[road.x][b] = dp[r.x][b] + road.t;
                    pq.add(new Road(road.x, dp[road.x][b]));
                }
            }
        }
    }

    static class Road{
        int x;
        int t;
        Road(int x,int t){
            this.x = x;
            this.t = t;
        }
    }


}