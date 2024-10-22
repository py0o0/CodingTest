        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static ArrayList<Road>[] roads;
            static int[] dp;
            static int[] visit;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int root = Integer.parseInt(st.nextToken());

                roads = new ArrayList[n + 1];
                dp = new int[n + 1];
                visit = new int[n + 1];

                for(int i = 0; i<=n; i++){
                    dp[i] = Integer.MAX_VALUE;
                    roads[i] = new ArrayList<>();
                }

                for(int i = 0; i < n - 1; i++){
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    int t = Integer.parseInt(st.nextToken());

                    roads[s].add(new Road(e,t));
                    roads[e].add(new Road(s,t));
                }

                int giga = root;
                int giga_len = 0;

                while(true){
                    visit[giga] = 1;

                    int cnt = 0;
                    int temp = giga;
                    int temp_len = 0;
                    for(Road road : roads[giga]){
                        if(visit[road.next] == 1) continue;
                        cnt++;
                        temp = road.next;
                        temp_len = road.t;
                    }
                    if(cnt != 1) break;
                    giga = temp;
                    giga_len += temp_len;
                }

                dijkstra(giga);

                int len = 0;
                for(int i = 1; i <= n; i++){
                    if(dp[i] == Integer.MAX_VALUE) continue;
                    len = Math.max(len, dp[i]);
                }
                System.out.println(giga_len + " " + len);

            }
            static void dijkstra(int start){
                dp[start] = 0;
                PriorityQueue<xy> pq = new PriorityQueue<>((a,b) -> a.now_t - b.now_t);
                pq.add(new xy(start,0));

                while(!pq.isEmpty()){
                    xy x = pq.poll();
                    for(Road road : roads[x.now]){
                        if(visit[road.next] == 1) continue;
                        if(dp[road.next] > dp[x.now] + road.t){
                            dp[road.next] = dp[x.now] + road.t;
                            pq.add(new xy(road.next,dp[road.next]));
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


