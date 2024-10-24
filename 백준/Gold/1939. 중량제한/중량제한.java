            import javax.lang.model.type.ArrayType;
            import java.io.BufferedReader;
            import java.io.IOException;
            import java.io.InputStreamReader;
            import java.util.*;

            public class Main {


                static ArrayList<Road>[] roads;
                static int[] dp;
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
                        roads[e].add(new Road(s,w));
                    }
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());
                    dijkstra(s);
                    System.out.println(dp[e]);



                }
                static void dijkstra(int start){
                    PriorityQueue<xy> pq = new PriorityQueue<>((a,b) -> b.weight - a.weight);
                    dp[start] = 1000000001;
                    pq.add(new xy(start,1000000001));



                    while(!pq.isEmpty()){
                        xy x = pq.poll();

                        if(dp[x.now] > x.weight) continue;

                        for(Road road : roads[x.now]){
                            int weight = Math.min(road.weight, dp[x.now]);
                            if(dp[road.next] < weight){
                                dp[road.next] = weight;
                                pq.add(new xy(road.next, dp[road.next]));
                            }
                        }
                    }
                }
                static class xy{
                    int now;
                    int weight;
                    xy(int now, int weight){
                        this.now = now;
                        this.weight = weight;
                    }
                }

                static class Road{
                    int next;
                    int weight;
                    Road(int next, int weight){
                        this.next = next;
                        this.weight = weight;
                    }
                }



            }


