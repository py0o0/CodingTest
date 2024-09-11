import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] v = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            v[i] = Long.parseLong(st.nextToken());

        int start = 0;
        int end = N - 1;
        Long near0 = Long.MAX_VALUE;

        long v1 = 0,v2 = 0;
        while(start < end) {
            long sum = v[start] + v[end];

            if(Math.abs(sum) < Math.abs(near0)) {
                near0 = sum;
                v1 = v[start];
                v2 = v[end];
            }

            if(sum < 0)
                start++;
            else if(sum > 0)
                end--;
            else if(sum == 0){
                v1 = v[start];
                v2 = v[end];
                break;
            }

        }

        System.out.print(v1 + " " + v2);

    }


}
