import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[]v =  new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) v[i] = Integer.parseInt(st.nextToken());

            int max = 0;
            long sum = 0;

            for(int i = n - 1; i >= 0; i--){
                if(max < v[i]) max = v[i];
                else sum += max - v[i];
            }
            System.out.println(sum);

        }

    }

}