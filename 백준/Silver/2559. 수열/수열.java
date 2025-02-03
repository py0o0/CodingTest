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

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(i + k > n) break;
            int sum = 0;
            for(int j = i; j < i + k; j++){
                sum += v[j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }




}