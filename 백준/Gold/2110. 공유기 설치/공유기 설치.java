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

        long[]v = new long[n];

        for(int i = 0; i < n; i++)
            v[i] = Long.parseLong(br.readLine());

        Arrays.sort(v);

        long start = 1;
        long end = v[n-1];

        while(start < end){
            long mid = (start + end)/2;

            long x = v[0];
            int cnt = 1;
            for(int i = 1; i < n; i++){
                if(x + mid < v[i]){
                    cnt++;
                    x = v[i];
                }
            }

            if(cnt < k)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println(start);

    }
    
}