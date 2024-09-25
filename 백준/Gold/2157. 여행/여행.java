    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ArrayList<Road>[] roads = new ArrayList[n + 1];

            for(int i=0;i<=n;i++)
                roads[i] = new ArrayList<>();

            for(int i= 0; i< k;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if(s < e)
                    roads[s].add(new Road(e, t));
            }

            int[][] dp = new int[m+1][n+1];

            for(Road road : roads[1])
                dp[2][road.next] = Math.max(dp[2][road.next],road.t);

            for(int change=2;change<m;change++){
                for(int node = 1; node <= n; node++){
                    if(dp[change][node] != 0)
                    for(Road road : roads[node]){
                        dp[change + 1][road.next] = Math.max(dp[change + 1][road.next], dp[change][node] +road.t);
                    }
                }
            }


            int max = 0;
            for(int i=1; i<=m;i++)
                max = Math.max(max,dp[i][n]);



            System.out.println(max);
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
