import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    static ArrayList<Integer> arr = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            arr.add(x);
        }
        dp = new int[N];

        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr.get(i) > arr.get(j))
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N-max);

    }


}
