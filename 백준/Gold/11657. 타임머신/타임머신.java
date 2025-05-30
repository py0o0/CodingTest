import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Road[] roads;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new long[n + 1];
        roads = new Road[m];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            roads[i] = new Road();
            roads[i].s = Integer.parseInt(st.nextToken());
            roads[i].e = Integer.parseInt(st.nextToken());
            roads[i].t = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n ; i++) dp[i] = Long.MAX_VALUE;
        dp[1] = 0;

        bellman(1,n);


    }static void bellman(int start, int n){
        dp[start] = 0;

        for(int i = 1; i <= n; i++){
            for(Road road : roads){
                if(dp[road.s] == Long.MAX_VALUE) continue;
                if(dp[road.e] > dp[road.s] + road.t){
                    if(i == n){
                        System.out.println(-1); return;
                    }

                    dp[road.e] = dp[road.s] + road.t;
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            if(dp[i] == Long.MAX_VALUE) System.out.println(-1);
            else System.out.println(dp[i]);
        }
    }

    static class Road{
        int s,e,t;
    }
}