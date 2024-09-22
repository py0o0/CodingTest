import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<xy>[] road;
    static int[] visit;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        road = new ArrayList[n + 1];
        dist = new int[n + 1];

        for(int i = 0; i <= n; i++)
            road[i] = new ArrayList<>();

        for (int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            road[s].add(new xy(e, t));
        }

        int max = 0;

        visit = new int[n + 1];
        dijkstra(end);
        int[] back = new int[n + 1];
        for(int i = 1; i <= n; i++)
            back[i] = dist[i];


        for(int i= 1; i<=n;i++){
            visit = new int[n + 1];
            dijkstra(i);
            int go = dist[end];

            max = Math.max(max, go + back[i] );
        }


        System.out.println(max);

    }

    static void dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        PriorityQueue<dij> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.t));
        pq.add(new dij(start,0));

        while(!pq.isEmpty()){
            dij x = pq.poll();
            if(visit[x.x] == 1) continue;
            visit[x.x] = 1;

            for(xy road : road[x.x]){
                if(dist[road.e] > dist[x.x] + road.t){
                    dist[road.e] = dist[x.x] + road.t;
                    pq.add(new dij(road.e,dist[road.e]));
                }
            }

        }



    }


    public static class xy{
        int e;
        int t;
        public xy(int e, int t){
            this.e = e;
            this.t = t;
        }
    }
    public static class dij{
        int x;
        int t;
        public dij(int x, int t){
            this.x = x;
            this.t = t;
        }
    }



}
