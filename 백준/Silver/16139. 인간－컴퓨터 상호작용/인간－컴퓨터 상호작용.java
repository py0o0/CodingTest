import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[line.length() + 1][26];

        for(int i = 1; i<=line.length(); i++){
            for(int j = 0; j < 26; j++)
                dp[i][j] = dp[i-1][j];
            dp[i][line.charAt(i - 1) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken()) + 1;
            int e = Integer.parseInt(st.nextToken()) + 1;

            int cnt = dp[e][x - 'a'] - dp[s - 1][x - 'a'];
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }




}