import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(v);

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = n - 1;
        int a = start;
        int b = end;
        while (start < end) {
            int val = Math.abs(v[start] + v[end]);
            if (val < min) {
                a = start;
                b = end;
                min = val;
            }

            if (Math.abs(v[start]) > Math.abs(v[end]))
                start++;
            else
                end--;
        }

        System.out.println(v[a] + " " + v[b]);
    }
}
