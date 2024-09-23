import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static ArrayList<Road>[] roads;
    static int[] star_dist;
    static int[] mac_dist;
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        house = new int[n + 1];
        star_dist = new int[n + 1];
        mac_dist = new int[n + 1];


        for (int i = 0; i<=n; i++)
            roads[i] = new ArrayList<>();

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads[s].add(new Road(e,t));
            roads[e].add(new Road(s,t));
        }

        st = new StringTokenizer(br.readLine());

        int star_len = Integer.parseInt(st.nextToken());
        int stargun = Integer.parseInt(st.nextToken());

        int[] stars = new int[star_len];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<star_len; i++) {
            stars[i] = Integer.parseInt(st.nextToken());
            house[stars[i]] = -1;
        }

        star_dist = dijkstra(stars,star_dist);


        st = new StringTokenizer(br.readLine());
        int mac_len = Integer.parseInt(st.nextToken());
        int macgun = Integer.parseInt(st.nextToken());

        int[] macs = new int[mac_len];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<mac_len; i++) {
            macs[i] = Integer.parseInt(st.nextToken());
            house[macs[i]] = -1;
        }

        mac_dist = dijkstra(macs,mac_dist);

        int min = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++) {
            if(house[i] != -1 && star_dist[i] <= stargun && mac_dist[i] <= macgun)
                min = Math.min(min,star_dist[i] + mac_dist[i]);
        }



        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);




    }

    static int[] dijkstra(int[] Array, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.t));
        for(int i = 0; i<Array.length; i++){
            dist[Array[i]] = 0;
            pq.add(new xy(Array[i],0));
        }


        while(!pq.isEmpty()){
            xy node = pq.poll();

            for(Road road : roads[node.now]){
                if(dist[road.next] > dist[node.now] + road.t){
                    dist[road.next] = dist[node.now] + road.t;
                    pq.add(new xy(road.next,dist[road.next]));
                }
            }
        }
        return dist;

    }

    static class xy{
        int now;
        int t;

        xy(int now, int t){
            this.now = now;
            this.t = t;
        }
    }

    static class Road {
        int next;
        int t;
        Road(int next, int t) {
            this.next = next;
            this.t = t;
        }
    }

}
