import java.util.*;
import java.io.*;

    class Main {

        static int r_cnt = 1;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            fi(n);

            int[] fibo = new int[n + 1];
            int cnt = 0;
            fibo[1] = 1;
            fibo[2] = 1;
            for(int i = 3; i<= n; i++){
                cnt++;
                fibo[i] = fibo[i-1] + fibo[i-2];
            }

            System.out.println(r_cnt + " " + cnt);

        }
        static int fi(int n) {
            if( n == 1 || n == 2)
                return 1;
            r_cnt++;
            return fi(n-1) + fi(n-2);
        }
    }
