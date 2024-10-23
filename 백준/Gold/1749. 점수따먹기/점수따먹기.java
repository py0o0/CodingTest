        import javax.lang.model.type.ArrayType;
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
                int[][] map = new int[n + 1][m + 1];
                int[][] dp = new int[n + 1][m + 1];

                for(int i = 1; i <= n; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 1; j <= m; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int Max = Integer.MIN_VALUE;
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= m; j++){
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + map[i][j] - dp[i - 1][j - 1];
                    }
                }

                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= m; j++){
                        for(int k = i; k <= n; k++){
                            for(int l = j; l <= m; l++){
                                Max = Math.max(Max, dp[k][l] + dp[i - 1][j - 1] - dp[k][j - 1] - dp[i - 1][l] );
                            }
                        }
                    }
                }

                System.out.println(Max);
            }


        }


