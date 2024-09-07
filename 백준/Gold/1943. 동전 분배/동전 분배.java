import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static int an = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 3;
        while(t-->0){
            int []dp = new int[100001];
            int n = sc.nextInt();
            int sum = 0;
            ArrayList<int[]> arr = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                int cnt = sc.nextInt();
                arr.add(new int[]{val, cnt});
                sum += val * cnt;
            }
            an = 0;
            if(sum%2 != 0){
                System.out.println(an);
                continue;
            }
            dp[0] = 1;
            for(int[] coin:arr){
                int val = coin[0];
                int cnt = coin[1];
                for(int j = sum/2; j>= val; j--){
                    if(dp[j-val] > 0){
                        for(int k=0;k<cnt;k++){
                            dp[j + val * k] = 1;
                        }
                    }
                }
                if(dp[sum/2] > 0){
                    an = 1;
                    break;
                }
            }
            System.out.println(an);
        }
    }


}
