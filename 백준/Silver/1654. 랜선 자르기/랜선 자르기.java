import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[] v = new long[n];
            for(int i = 0; i < n; i++)
                v[i] = Long.parseLong(br.readLine());


            Arrays.sort(v);

            long start = 0;
            long end = v[v.length - 1] + 1;

            while(start < end){
                long mid = (start + end)/2;

                long cnt = 0;
                for(int i = 0; i < n; i++)
                    cnt += v[i] / mid;

                if(k > cnt)
                    end = mid;
                else
                    start = mid + 1;
            }
            System.out.println(start - 1); //upper bound
        }

    }
