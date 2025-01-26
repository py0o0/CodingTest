import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] v = new int[n];
            int[] an = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<n; i++)
                v[i] = Integer.parseInt(st.nextToken());

            for(int i = 0; i<n; i++){
                int x = v[i];
                int j = -1;
                while(x >= 0){
                    x--; j++;
                    while(an[j] != 0) j++;
                }
                an[j] = i + 1;
            }
            for(int i = 0; i<n; i++){
                System.out.print(an[i] + " ");
            }
        }



    }
