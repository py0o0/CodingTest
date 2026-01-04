import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Road>[] roads;
    static int[] dp, prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        roads = new ArrayList[n + 1];
        dp = new int[n + 1];
        prev = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            roads[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            roads[a].add(new Road(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dp[end]);

        List<Integer> list = new ArrayList<>();
        int cur = end;
        list.add(cur);
        while(true){
            cur = prev[cur];
            list.add(cur);
            if(cur == start) break;
        }
        System.out.println(list.size());
        for(int i = list.size() - 1; i > -1; i--){
            System.out.print(list.get(i) + " ");
        }
    }

    static void dijkstra(int i){
        PriorityQueue<Road> pq = new PriorityQueue<>((a, b) -> a.t - b.t);
        dp[i] = 0;
        pq.add(new Road(i, 0));

        while(!pq.isEmpty()){
            Road x = pq.poll();
            if(dp[x.x] < x.t) continue;
            for(Road road : roads[x.x]){
                if(dp[road.x] > dp[x.x] + road.t){
                    dp[road.x] = dp[x.x] + road.t;
                    prev[road.x] = x.x;
                    pq.add(new Road(road.x, dp[x.x] + road.t));
                }
            }
        }
    }

    static class Road{
        int x, t;
        Road(int a, int b){
            x = a; t = b;
        }
    }

}
