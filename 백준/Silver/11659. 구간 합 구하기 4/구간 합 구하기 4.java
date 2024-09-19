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
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        int[] sum = new int[n];

        st = new StringTokenizer(br.readLine());
        int s =0;
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            v[i] = x;
            s += x;
            sum[i] = s;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if(start == 0){
                System.out.println(sum[end]);
                continue;
            }
            System.out.println(sum[end] - sum[start - 1]);
        }


    }
}
