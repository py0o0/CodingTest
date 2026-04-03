import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) v[i] = Integer.parseInt(st.nextToken());
        v[n] = k;
        Arrays.sort(v);


        int start = 1;
        int end = k;

        while (start < end) {
            int mid = (start + end) / 2;
            int cnt = 0;

            int cur = 0;
            for(int i = 0; i <= n; i++){
                if(v[i] - cur > mid){
                    while(v[i] - cur > mid){
                        cur += mid; cnt++;
                    }
                }
                cur = v[i];
            }

            if(cnt > m) start = mid + 1;
            else end = mid;
        }
        System.out.println(start);

    }


}
