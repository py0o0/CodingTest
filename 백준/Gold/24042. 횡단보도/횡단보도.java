        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static ArrayList<Road>[] roads;
            static long[] dp;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                roads = new ArrayList[n + 1];
                dp = new long[n + 1];

                for (int i = 0; i < n + 1; i++) {
                    roads[i] = new ArrayList<>();
                    dp[i] = Long.MAX_VALUE;
                }
                
                for(int i =0; i < m; i++){
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    roads[s].add(new Road(e, i));
                    roads[e].add(new Road(s, i));
                }

                dijkstra(1, n, m);

                System.out.println(dp[n]);


            }
            static void dijkstra(int start, int n, int m){
                dp[start] = 0;
                PriorityQueue<xy> pq = new PriorityQueue<>((a,b) -> Long.compare(a.cur_t , b.cur_t));
                pq.add(new xy(start,0));

                while(!pq.isEmpty()){
                    xy x = pq.poll();
                    for(Road road : roads[x.now]){
                        long val = (((road.t + m) - (x.cur_t % m)) % m ) + 1;
                        if(dp[road.next] > x.cur_t + val){
                            dp[road.next] = x.cur_t + val;
                            pq.add(new xy(road.next, dp[road.next]));
                        }
                    }
                }

            }

            static class xy{
                int now;
                long cur_t;
                xy(int now, long cur_t){
                    this.now = now;
                    this.cur_t = cur_t;
                }
            }

            static class Road{
                int next;
                long t;
                Road(int n, long t){
                    this.next = n;
                    this.t = t;
                }
            }

        }

