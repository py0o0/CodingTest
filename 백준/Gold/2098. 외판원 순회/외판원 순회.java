import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][1<<n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = tsp(0, 1);
        System.out.println(answer);
    }

    static int tsp(int current, int visit){
        if(visit == (1 << n) - 1){ // 모든 경우 방문
            if(map[current][0] == 0){ // 현재 노드에서 처음으로 가는 길이 없으면
                return Integer.MAX_VALUE;
            }
            return map[current][0];
        }

        if(dp[current][visit] != -1)
            return dp[current][visit];

        int minCost = Integer.MAX_VALUE;
        for(int next = 0; next < n; next++){
            if((visit & (1 << next)) != 0 || map[current][next] == 0) continue; // 이미 방문했거나 길이 없음
            int cost = tsp(next, visit | (1 << next));
            if(cost == Integer.MAX_VALUE) continue;
            minCost = Math.min(minCost, cost + map[current][next]); // 다음꺼 가는 최소 코스트
        }
        return dp[current][visit] = minCost;
    }


}