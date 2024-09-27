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

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            roads = new ArrayList[n + 1];
            dp = new int[n + 1];
            for(int i = 0; i<=n; i++)
                roads[i] = new ArrayList<>();
            Arrays.fill(dp, Integer.MAX_VALUE);

            for(int i = 0; i<m;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                roads[s].add(new Road(e,t));
            }
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dijkstra(start);
            System.out.println(dp[end]);


        }
        static void dijkstra(int start){
            dp[start] = 0;
            PriorityQueue<xy> pq = new PriorityQueue<>((a, b) -> a.t - b.t);
            pq.add(new xy(start,0));

            while (!pq.isEmpty()) {
                xy x = pq.poll();
                if(dp[x.now] < x.t) continue;
                for(Road road : roads[x.now]){
                    if(dp[road.next] > dp[x.now] + road.t){
                        dp[road.next] = dp[x.now] + road.t;
                        pq.add(new xy(road.next,dp[road.next]));
                    }
                }
            }



        }
        static class xy{
            int now;
            int t;
            xy(int now,int t){
                this.now = now;
                this.t = t;
            }
        }


        static public class Road{
            int next;
            int t;
            Road(int n, int t){
                this.next = n;
                this.t = t;
            }
        }

    }
