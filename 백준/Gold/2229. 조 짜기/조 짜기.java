    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {



        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[] v = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++)
                v[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[n + 1];

            for(int i = 1; i<= n;i++){
                int max = v[i]; int min = v[i];
                for(int j = i-1; j > 0; j--){
                    max = Math.max(max, v[j]);
                    min = Math.min(min, v[j]);
                    dp[i] = Math.max(dp[i], dp[j - 1] + max - min);
                }
            }
            System.out.println(dp[n]);




        }



    }
