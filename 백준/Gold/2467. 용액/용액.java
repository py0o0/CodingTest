import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n;i++)
                arr[i] = Long.parseLong(st.nextToken());

            long x = arr[0];
            long y = arr[arr.length-1];
            long min = abs(x + y);

            int start = 0; int end = arr.length-1;
            while(start < end){
                long val = arr[start] + arr[end];

                if(abs(val) < min){
                    min = abs(val);
                    x = arr[start];
                    y = arr[end];
                }
                if(val < 0) start++;
                else end--;
            }

            System.out.println(x + " " + y);
        }

        public static long abs(long n){
            return n > 0 ? n : -n;
        }

    }
