import java.util.*;
import java.io.*;

public class Main {

    static int[][] map;
    static int[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int an = tsp(0, 1);
        System.out.println(an);
    }

    static int tsp(int cur, int visit){
        if(visit == (1 << n) - 1){
            if(map[cur][0] == 0) return Integer.MAX_VALUE;
            return map[cur][0];
        }

        if(dp[cur][visit] != -1) return dp[cur][visit];

        int minCost = Integer.MAX_VALUE;
        for(int next = 0; next < n; next++){
            if((visit & (1 << next)) != 0 || map[cur][next] == 0) continue;
            int cost = tsp(next, visit | (1 << next));
            if(cost == Integer.MAX_VALUE) continue;
            minCost = Math.min(minCost, cost + map[cur][next]);
        }
        return dp[cur][visit] = minCost;
    }

}