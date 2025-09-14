import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] v = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) v[i] = Long.parseLong(st.nextToken());
        Arrays.sort(v);

        long[] an = new long[3];
        an[0] = v[0]; an[1] = v[1]; an[2] = v[2];

        long dis = Math.abs(an[0] + an[1] + an[2]);

        for(int i = 1; i < n-1; i++){
            int start = 0;
            int end = n - 1;

            while(start < end){
                if(start == i){
                    start++; continue;
                }
                if(end == i){
                    end--; continue;
                }

                long x = v[start] + v[end] + v[i];
                if(dis > Math.abs(x)){
                    dis = Math.abs(x);
                    an[0] = v[start]; an[1] = v[end]; an[2] = v[i];
                }

                if(x < 0)
                    start++;
                else
                    end--;
            }
        }
        Arrays.sort(an);
        for(int i = 0; i < 3; i++)
            System.out.print(an[i] + " ");


    }
}