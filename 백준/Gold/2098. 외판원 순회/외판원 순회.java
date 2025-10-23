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

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int an = dfs(0, 1);
        System.out.println(an);
    }

    static int dfs(int x, int visit){
        if(visit == (1 << n) - 1){
            if(map[x][0] == 0) return Integer.MAX_VALUE;
            return map[x][0];
        }

        if(dp[x][visit] != -1) return dp[x][visit];

        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if((visit & (1 << i)) != 0 || map[x][i] == 0) continue;
            int cost = dfs(i, visit | (1 << i));
            if(cost == Integer.MAX_VALUE) continue;
            minCost = Math.min(minCost, cost + map[x][i]);
        }
        return dp[x][visit] = minCost;
    }
}