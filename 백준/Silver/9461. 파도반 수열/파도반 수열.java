import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        long[]dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=100;i++)
            dp[i] = dp[i-2] + dp[i-3];


        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }

}
