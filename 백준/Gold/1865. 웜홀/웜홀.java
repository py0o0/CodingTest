import java.io.*;
import java.util.*;

class Main{

    static Road[] roads;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            roads = new Road[2*m + w];
            dp = new long[n+1];

            for(int i = 0; i < 2 * m; i+=2){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                long tt = Long.parseLong(st.nextToken());

                roads[i] = new Road();
                roads[i].s = s;
                roads[i].e = e;
                roads[i].t = tt;

                roads[i+1] = new Road();
                roads[i+1].e = s;
                roads[i+1].s = e;
                roads[i+1].t = tt;
            }

            for(int i = 2*m; i < 2*m + w;i++ ) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                long tt = Long.parseLong(st.nextToken());

                roads[i] = new Road();
                roads[i].s = s;
                roads[i].e = e;
                roads[i].t = -tt;
            }

            for(int i = 1; i<= n; i++)
                dp[i] = Long.MAX_VALUE;

            int flag = 0;
            for(int i = 1; i<=n; i++){
                if(dp[i] == Long.MAX_VALUE){
                    if(!bellman(i,n)) {
                        flag = 1;
                        break;
                    }
                }
            }

            if(flag == 1) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    static boolean bellman(int x, int n){
        dp[x] = 0;

        for(int i = 1; i <= n; i++){
            for(Road road: roads){
                if(dp[road.s] == Long.MAX_VALUE) continue;

                if(dp[road.e] > dp[road.s] + road.t){
                    dp[road.e] = dp[road.s] + road.t;

                    if(i == n) return false;
                }
            }
        }
        return true;
    }

    static class Road{
        int s,e;
        long t;
    }

}