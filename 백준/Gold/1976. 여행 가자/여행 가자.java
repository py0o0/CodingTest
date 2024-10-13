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
                int n = Integer.parseInt(br.readLine());
                int m = Integer.parseInt(br.readLine());

                roads = new ArrayList[n + 1];
                dp = new int[n + 1][n + 1];
                for (int i = 0; i <= n; i++)
                    roads[i] = new ArrayList<>();

                for(int i = 1; i <= n; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 1; j <= n; j++){
                        int next = Integer.parseInt(st.nextToken());
                        if(next == 0) continue;
                        roads[i].add(new Road(j,next));
                    }
                }
                for(int i = 1; i <= n; i++)
                    for(int j = 1; j <= n; j++)
                        dp[i][j] = Integer.MAX_VALUE;


                for(int i = 1; i <= n; i++)
                    dijkstra(i);

                st = new StringTokenizer(br.readLine());
                int now = Integer.parseInt(st.nextToken());
                while(m-- > 1){
                    int next = Integer.parseInt(st.nextToken());
                    if(dp[now][next] == Integer.MAX_VALUE){
                        System.out.println("NO"); return;
                    }
                    now = next;
                }
                System.out.println("YES");

            }
            static void dijkstra(int start){
                dp[start][start] = 0;
                PriorityQueue<xy> pq = new PriorityQueue<>((a,b) -> a.now_t - b.now_t);
                pq.add(new xy(start,0));

                while(!pq.isEmpty()){
                    xy x = pq.poll();
                    for(Road road : roads[x.now]){
                        if(dp[start][road.next] > dp[start][x.now] + road.t){
                            dp[start][road.next] = dp[start][x.now] + road.t;
                            pq.add(new xy(road.next, dp[start][road.next]));
                        }
                    }
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

            static class Road{
                int next;
                int t;
                Road(int next, int t){
                    this.next = next;
                    this.t = t;
                }
            }


        }


