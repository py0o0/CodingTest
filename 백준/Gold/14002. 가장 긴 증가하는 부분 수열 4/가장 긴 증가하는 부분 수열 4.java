import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            v[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }


        int len = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(v[i] > v[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            len = Math.max(len, dp[i]);
        }
        System.out.println(len);

        int[] an = new int[len];
        for(int i = n - 1; i >= 0; i--){
            if(dp[i] == len){
                len--;
                an[len] = v[i];
            }
        }
        for(int i = 0; i < an.length; i++)
            System.out.print(an[i] + " ");

    }
}
