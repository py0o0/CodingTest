import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) v[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(v);

        long an = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int sum = v[i] + v[j];

                long start = j + 1, end = n;
                while(start < end){
                    int mid = (int)(start + end) / 2;
                    if(v[mid] + sum >= 0) end = mid;
                    else start = mid + 1;
                }
                long a = start;

                start = j + 1; end = n;
                while(start < end){
                    int mid = (int)(start + end) / 2;
                    if(v[mid] + sum > 0) end = mid;
                    else start = mid + 1;
                }

                long b = start;
                an += b - a;

            }
        }
        System.out.println(an);
    }


}
