import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] v = new long[n];
            for(int i = 0; i < n; i++)
                v[i] = Long.parseLong(br.readLine());

            Arrays.sort(v);

            long start = 1;
            long end = v[n - 1];

            while(start < end){
                long mid = (start + end) / 2;

                long x = v[0];              //첫 공유기 설치
                int cnt = 1;
                for(int i = 1; i<n; i++){
                    if(x + mid < v[i]){
                        cnt++;
                        x = v[i];   //v[i]가 거리 밖에 있을 시 공유기 추가
                    }
                }

                if(cnt < m)
                    end = mid;
                else
                    start = mid + 1;
            }
            System.out.println(start);
        }

    }
