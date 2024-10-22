        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static ArrayList<Road>[] roads;
            static int[][] dp;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                roads = new ArrayList[n + 1];
                dp = new int[n + 1][n + 1];

                for(int i = 0; i<=n; i++){
                    roads[i] = new ArrayList<>();
                    Arrays.fill(dp[i], Integer.MAX_VALUE);
                }

                for(int i = 1; i <= n; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 1; j <= n; j++){
                        int x = Integer.parseInt(st.nextToken());
                        if(i == j) continue;
                        roads[i].add(new Road(j, x));
                    }
                }

                for(int i = 1; i <= n; i++)
                    dijkstra(i);


                for(int i = 0; i<m;i++){
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    int t = Integer.parseInt(st.nextToken());
                    if(dp[s][e] > t) System.out.println("Stay here");
                    else System.out.println("Enjoy other party");
                }
            }
            static void dijkstra(int start){
                dp[start][start] = 0;
                PriorityQueue<xy> pq = new PriorityQueue<>((a, b) -> a.now_t - b.now_t);
                pq.add(new xy(start, 0));

                while(!pq.isEmpty()){
                    xy x = pq.poll();
                    for(Road road : roads[x.now]){
                        if(dp[start][road.next] > dp[start][x.now] + road.t){
                            dp[start][road.next] = dp[start][x.now] + road.t;
                            pq.add(new xy(road.next,dp[start][road.next]));
                        }
                    }

                }
            }

            static class Road{
                int next;
                int t;
                Road(int n, int t){
                    this.next = n;
                    this.t = t;
                }
            }
            static class xy{
                int now;
                int now_t;
                xy(int now, int now_t){
                    this.now = now;
                    this.now_t = now_t;
                }
            }








        }

