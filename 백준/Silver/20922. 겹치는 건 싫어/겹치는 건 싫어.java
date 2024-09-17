import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        st  = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());

        int[] m = new int[100001];
        int max = 0;
        int start = 0;
        for(int i = 0; i< n; i++){
            m[v[i]]++;
            if(m[v[i]] > k){
                while(m[v[i]] > k){
                    m[v[start]]--;
                    start++;
                }
            }
            max = Math.max(max, i - start + 1);
        }
        System.out.println(max);
    }
    

}
