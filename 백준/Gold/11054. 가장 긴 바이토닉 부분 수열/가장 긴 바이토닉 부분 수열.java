import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());

            int[] v = new int[n];
            int[] ldp = new int[n];
            int[] rdp = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
                ldp[i] = 1;
                rdp[i] = 1;
            }

            for(int i = 1; i<n;i++)
                for(int j = 0; j<i; j++){
                    if(v[i]> v[j]){
                        ldp[i] = Math.max(ldp[i],ldp[j] + 1);
                    }
                }
            for(int i = n - 2; i>=0; i--)
                for(int j = n-1; j>i; j--){
                    if(v[i] > v[j]){
                        rdp[i] = Math.max(rdp[i],rdp[j] + 1);
                    }
                }
            int max = 1;
            for(int i = 0; i<n; i++) 
                max = Math.max(max, rdp[i] + ldp[i] - 1);
            
            System.out.println(max);
        }
    }
