import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(dp[j] != 0) continue;
                if(cnt == x) {
                    dp[j] = i + 1; break;
                }
                if(dp[j] == 0) cnt++;
            }
        }
        for(int i = 0; i < n; i++)
            System.out.print(dp[i] + " ");
    }


}