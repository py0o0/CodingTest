import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] v = new int[m];
        for (int i = 0; i < m; i++) v[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(v);

        int start = 1;
        int end = 1000000000;

        while(start < end){
            int mid = (start + end) / 2;
            long cnt = 0;

            for(int i = 0; i < m; i++){
                cnt += (long)v[i] / mid;
            }

            if(cnt >= n) start = mid + 1;
            else end = mid;
        }

   
        System.out.println(start - 1);

    }

}
