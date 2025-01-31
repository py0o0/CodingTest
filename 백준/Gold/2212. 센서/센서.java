import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            if(k >= n) {
                System.out.println(0); return;
            }

            int[] v = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                v[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(v);

            int [] dif = new int[n - 1];
            for(int i = 0; i < n - 1; i++)
                dif[i] = v[i+1] - v[i];

            Arrays.sort(dif);

            int an = 0;
            for(int i = 0; i < n - k; i++) 
                an += dif[i];
            

            System.out.println(an);

        }

    }
