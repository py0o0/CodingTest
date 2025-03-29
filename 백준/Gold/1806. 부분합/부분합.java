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

        int sum = 0;
        int start = 0;
        int an = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum += v[i];
            if(sum >= k){
                while(sum >= k){
                    sum -= v[start++];
                }
                an = Math.min(an, i - start + 2);
            }
        }
        if(an == Integer.MAX_VALUE) an = 0;
        System.out.println(an);
    }


}