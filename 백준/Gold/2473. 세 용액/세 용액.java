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

        long min = Long.MAX_VALUE;
        int a  = 0, b = 0, c = 0;
        for(int i = 0; i < n - 2; i++){
            int start = i + 1; int end = n - 1;

            while(start < end){
                long val = (long)v[i] + v[start] + v[end];
                if(Math.abs(val) < min){
                    min = Math.abs(val);
                    a = v[i]; b = v[start]; c = v[end];
                }

                if(val < 0) start++;
                else end--;
            }
        }
        System.out.println(a + " " + b + " " + c);
        
    }

}
