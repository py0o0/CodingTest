    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        static ArrayList<Road>[] roads;
        static int[][] dist;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int INF = 200000001;

            roads = new ArrayList[n + 1];
            dist = new int[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                Arrays.fill(dist[i], INF);
                roads[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                roads[s].add(new Road(e, t));
                roads[e].add(new Road(s, t));
            }

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            dijkstra(1);
            dijkstra(v1);
            dijkstra(v2);


            int min = Math.min(dist[1][v1] + dist[v1][v2] + dist[v2][n], dist[1][v2] + dist[v2][v1] + dist[v1][n]);
            if (min >= INF)
                min = -1;
            System.out.println(min);

        }

        static void dijkstra(int s) {
            dist[s][s] = 0;

            PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.t));
            pq.add(new xy(s, 0));

            while (!pq.isEmpty()) {
                xy x = pq.poll();
                for (Road road : roads[x.now]) {
                    if (dist[s][road.next] > dist[s][x.now] + road.t) {
                        dist[s][road.next] = dist[s][x.now] + road.t;
                        pq.add(new xy(road.next, dist[s][road.next]));
                    }
                }
            }


        }

        static class xy {
            int now;
            int t;

            xy(int now, int t) {
                this.now = now;
                this.t = t;
            }
        }

        static class Road {
            int next;
            int t;

            Road(int n, int t) {
                this.next = n;
                this.t = t;
            }
        }


    }
