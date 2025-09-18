import java.util.*;
import java.io.*;

public class Main{

    static int[] visit, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        xy[] v = new xy[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].m = Integer.parseInt(st.nextToken());
            v[i].p = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(v,(x,y)->y.p - x.p);

        int[] dp = new int[target];

        for(int i = 0; i < target; i++) dp[i] = Integer.MAX_VALUE;

        dp[0] = 0;
        int min = Integer.MAX_VALUE;

        for(xy x : v) {
            for(int i = target - 1; i >= 0; i--){
                if(dp[i] == Integer.MAX_VALUE && i != 0) continue;

                int j = i;
                while(true){
                    if(j + x.p >= target){
                        min = Math.min(min, dp[j] + x.m);
                        break;
                    }
                    dp[j + x.p] = Math.min(dp[j] + x.m, dp[j + x.p]);
                    j += x.p;
                }
            }
        }
        System.out.println(min);

    }
    static class xy{
        int m,p;
    }


}