            import javax.lang.model.type.ArrayType;
            import java.io.BufferedReader;
            import java.io.IOException;
            import java.io.InputStreamReader;
            import java.util.*;

            public class Main {


                static ArrayList<Road>[] roads;
                static int[] dp;
                static int an;
                public static void main(String[] args) throws IOException {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    StringTokenizer st;

                    st = new StringTokenizer(br.readLine());
                    int n = Integer.parseInt(st.nextToken());
                    int m = Integer.parseInt(st.nextToken());

                    roads = new ArrayList[n + 1];
                    dp = new int[n + 1];

                    for(int i = 0; i <= n; i++)
                        roads[i] = new ArrayList<>();


                    for(int i = 0; i < m; i++){
                        st = new StringTokenizer(br.readLine());
                        int s = Integer.parseInt(st.nextToken());
                        int e = Integer.parseInt(st.nextToken());
                        int w = Integer.parseInt(st.nextToken());
                        roads[s].add(new Road(e,w));
                    }

                    an = Integer.MAX_VALUE;
                    for(int i = 1; i <= n; i++) {
                        Arrays.fill(dp,Integer.MAX_VALUE);
                        dijkstra(i);
                    }
                    if(an == Integer.MAX_VALUE) an = -1;
                    System.out.println(an);



                }
                static void dijkstra(int start){
                    PriorityQueue<xy> pq = new PriorityQueue<>((a,b) -> a.now_t - b.now_t);
                    pq.add(new xy(start,0));

                    while(pq.size() > 0){
                        xy x = pq.poll();

                        if(dp[x.now] < x.now_t) continue;

                        for(Road road : roads[x.now]){
                            if(dp[road.next] > x.now_t + road.t){
                                dp[road.next] = x.now_t + road.t;
                                pq.add(new xy(road.next , dp[road.next]));
                            }
                        }
                    }
                    an = Math.min(an, dp[start]);

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


