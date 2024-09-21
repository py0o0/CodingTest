import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];

        ArrayList<Integer>[] dp = new ArrayList[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            v[i] = Integer.parseInt(st.nextToken());
            dp[i] = new ArrayList<>();
        }

        dp[0].add(v[0]);
        int max_cur =  0;

        for(int i = 1; i < n; i++){
            int len = 0;
            int cur = i;
            for(int j = 0; j < i; j++){
                if(v[i] > v[j] && dp[j].size()  > len){
                    len = dp[j].size();
                    cur = j;
                }
            }
            for(int j = 0; j < len; j++)
                dp[i].add(dp[cur].get(j));

            dp[i].add(v[i]);

            if(dp[max_cur].size() < dp[i].size())
                max_cur = i;
        }

        System.out.println(dp[max_cur].size());
        for(int i = 0; i < dp[max_cur].size(); i++)
            System.out.print(dp[max_cur].get(i) + " ");


    }

}
