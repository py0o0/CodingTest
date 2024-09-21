import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[]dp = new long[1000001];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 4;

        for(int i = 5; i<= n; i++){
            if(i % 2 == 1)
                dp[i] = dp[i-1];
            else
                dp[i] = (dp[i-1] + dp[i/2]) % 1000000000;
        }
        System.out.println(dp[n]);
        
    }

}
