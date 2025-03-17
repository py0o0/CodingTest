import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] v = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) v[i] = Integer.parseInt(st.nextToken());
        v[0] = 0; v[n+1] = l;

        Arrays.sort(v);
        int start = 1;
        int end = l;
        while (start < end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 1; i < n+2; i++) {
                cnt += (v[i]-v[i-1] - 1)/mid;

            }
            if(cnt <= m)
                end = mid ;
            else start = mid + 1;
        }
        System.out.println(start);
    }

}