import java.io.*;
import java.util.*;

class Main{

    static long[] dp;
    static Road[] roads;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new long[n+1];
        roads = new Road[m];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            roads[i] = new Road();
            roads[i].s = s;
            roads[i].e = e;
            roads[i].t = t;
        }

        for(int i = 1; i <= n; i++)
            dp[i] = Long.MAX_VALUE;

        bellman(1,n);

    }
    static void bellman(int x, int n){
        dp[x] = 0;

        for(int i = 1; i <=n; i++){
            for(Road r : roads){
                if(dp[r.s] == Long.MAX_VALUE) continue;

                if(dp[r.e] > dp[r.s] + r.t){
                    if(i == n){ //n번째에서 단축될 시 음수 사이클 존재
                        System.out.println(-1);
                        return;
                    }
                    dp[r.e] = dp[r.s] + r.t;
                }

            }
        }

        for(int i = 1; i<= n; i++){
            if(i == x) continue;
            if(dp[i] == Long.MAX_VALUE) System.out.println(-1);
            else System.out.println(dp[i]);
        }

    }
    static class Road{
        int s;
        int e;
        int t;
    }

}