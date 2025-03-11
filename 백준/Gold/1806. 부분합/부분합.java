import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int sum = v[0];
        int min = Integer.MAX_VALUE;
        if(sum >= k) min = 1;
        for(int i = 1; i < n; i++){
            sum += v[i];

            if(sum >= k){
                min = Math.min(min, i - start + 1);
                while(sum >= k){
                    sum -= v[start++];
                    if(sum >= k) min = Math.min(min, i - start + 1);
                }
            }

        }
        if(min == Integer.MAX_VALUE) min = 0;
        System.out.println(min);
    }



}