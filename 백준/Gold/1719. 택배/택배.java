import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static ArrayList<Road>[] roads;
    static int[][] dist;
    static int[][] an;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        for(int i = 0; i<=n;i++)
            roads[i] =  new ArrayList<>();

        dist = new int[n + 1][n + 1];
        an = new int[n + 1][n + 1];

        for(int i = 1; i<=n;i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        for(int i = 0; i<m; i++){

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads[s].add(new Road(e, t));
            roads[e].add(new Road(s, t));
        }

        for(int i= 1; i<= n; i++)
            dijkstra(i);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j)
                    System.out.print("- ");
                else
                    System.out.print(an[i][j] + " ");
            }
            System.out.println();
        }



    }

    static void dijkstra(int s){
        dist[s][s] = 0;

        PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.t));
        pq.add(new xy(s, 0, 0));

        while(!pq.isEmpty()){
            xy x = pq.poll();

            for(Road road : roads[x.x]){

                if(dist[s][road.next] > dist[s][x.x] + road.t){
                    dist[s][road.next] = dist[s][x.x] + road.t;

                    if(x.first_move == 0) {
                        an[s][road.next] = road.next;
                        pq.add(new xy(road.next, dist[s][road.next], road.next));
                    }
                    else{
                        an[s][road.next] = x.first_move ;
                        pq.add(new xy(road.next, dist[s][road.next], x.first_move));
                    }
                }
            }

        }


    }

    static class xy{
        int x;
        int t;
        int first_move;
        public xy(int x, int t, int first_move){
            this.x = x;
            this.t = t;
            this.first_move = first_move;
        }
    }

    static class Road{
        int next;
        int t;
        Road(int next, int t){
            this.next = next;
            this.t = t;
        }
    }

}
