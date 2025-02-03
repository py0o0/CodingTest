import java.io.*;
import java.util.*;

class Main{

    static ArrayList<Road>[] roads;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        roads = new ArrayList[n+1];
        dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            roads[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        while(true){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(s == -1 && e == -1) break;

            roads[s].add(new Road(e,1));
            roads[e].add(new Road(s,1));
        }

        int[] an = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int max = 0;
            dijskra(i);
            for(int j = 1; j<=n; j++){
                max = Math.max(dp[j],max);
                dp[j] = Integer.MAX_VALUE;
            }
            an[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++)
            min = Math.min(min, an[i]);
        System.out.print(min + " ");

        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(an[i] == min) cnt++;
        }
        System.out.println(cnt);

        for(int i = 1; i <= n; i++){
            if(an[i] == min) System.out.print(i + " ");
        }


    }

    static void dijskra(int i){
        dp[i] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>((a,b) -> a.d - b.d);
        pq.add(new Road(i,0));

        while(!pq.isEmpty()){
            Road x = pq.poll();
            for(Road road : roads[x.x]){
                if(dp[road.x] > dp[x.x] + road.d){
                    dp[road.x] = dp[x.x] + road.d;
                    pq.add(new Road(road.x,dp[road.x]));
                }
            }
        }
    }

    static class Road{
        int x;
        int d;
        Road(int x,int d){
            this.x=x;
            this.d=d;
        }
    }

}