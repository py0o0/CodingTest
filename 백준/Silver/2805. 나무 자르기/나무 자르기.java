import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long[] v = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                v[i] = Long.parseLong(st.nextToken());

            Arrays.sort(v);

            long start = 0;
            long end = v[v.length - 1] + 1;

            while(start < end){
                long mid = (start + end) / 2;

                long val = 0;
                for(int i = 0; i<n; i++){
                    if(v[i] > mid)
                        val += v[i] - mid;
                }

                if(k > val)
                    end = mid;
                else
                    start = mid + 1;
            }
            System.out.println(start - 1);

        }

    }
