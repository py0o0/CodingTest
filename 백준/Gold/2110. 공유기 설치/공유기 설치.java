import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] v = new int[n];
        for(int i = 0; i < n; i++){
            v[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(v);

        int start = 0;
        int end = v[n - 1];

        while(start < end){
            int mid = (start + end) / 2;

            int cnt = 1;
            int x = v[0];
            for(int i = 1; i < n; i++){
                if(x + mid < v[i]){
                    cnt++;
                    x = v[i];
                }
            }

            if(cnt < m){
                end = mid;
            }else start = mid + 1;
        }
        System.out.println(start);

    }
}