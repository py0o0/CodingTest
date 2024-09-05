import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int an;
    static int[][] dp = new int[10001][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            an = 0;
            
            if(dp[n][1] != 0){
                System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
                continue;
            }

            for(int j = 4; j <= n; j++){
                dp[j][1] = dp[j-1][1];
                dp[j][2] = dp[j-2][1] + dp[j-2][2]; // i-2는 중복제거를 위함. 마지막 2를 더할 땐 중복 제거를 위해 2를 1가지 방법으로 더함 +2 ,(1+1)은 중복 되는 방법이기에 X
                dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];
            }

            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }

    }
}
