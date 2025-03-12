import java.io.*;
import java.util.*;

class Main{

    static ArrayList<Road>[] roads;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            roads[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n;j++){
                int x = Integer.parseInt(st.nextToken());

                if(x == 1){
                    roads[i].add(new Road(j,1));
                    roads[j].add(new Road(i,1));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        m--;
        dijstra(x);

        while(m-->0){
            int a = Integer.parseInt(st.nextToken());
            if(dp[a] == Integer.MAX_VALUE){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    public static void dijstra(int i){
        dp[i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        pq.add(new Road(i,0));

        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.x]){
                if(dp[road.x] > x.val + road.val){
                    dp[road.x] = x.val + road.val;
                    pq.add(new Road(road.x,x.val + road.val));
                }
            }
        }
    }
    static class Road{
        int x;
        int val;
        Road(int x, int val){
            this.x = x;
            this.val = val;
        }
    }




}