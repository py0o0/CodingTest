import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] v = new long[n]; 
        for (int i = 0; i < n; i++) v[i] = Long.parseLong(st.nextToken());

        Arrays.sort(v);

        int an = 0;
        for (int i = 0; i < n; i++) { 
            int start = 0;
            int end = n - 1;

            while (start < end) {
                if (start == i) { start++; continue; }
                if (end == i) { end--; continue; }

                long val = v[start] + v[end]; 
                if (val == v[i]) {
                    an++;
                    break;
                }
                if (val < v[i]) start++;
                else end--;
            }
        }
        System.out.println(an);
    }
}