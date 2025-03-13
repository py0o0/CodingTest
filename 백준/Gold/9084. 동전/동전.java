import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] v = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                v[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());

            int[] dp = new int[target+1];
            dp[0] = 1;
            for(int i = 0; i < n; i++){
                for(int j = v[i]; j <= target; j++){
                    dp[j] += dp[j - v[i]];
                }
            }
            System.out.println(dp[target]);
        }
    }

}