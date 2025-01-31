import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n, k;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            xy[] items = new xy[n];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                items[i] = new xy(v, w);
            }
            int[][] dp = new int[n + 1][k + 1];
            for(int i = 1; i<=n; i++){
                for(int j = 1; j <=k; j++){
                    if(items[i-1].w > j)
                        dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - items[i-1].w] + items[i-1].v);
                }
            }
            System.out.println(dp[n][k]);


        }
        public static class xy{
            int w;
            int v;

            public xy(int w, int v) {
                this.w = w;
                this.v = v;
            }
        }
    }
