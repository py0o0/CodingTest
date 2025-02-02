import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++)
            v[i] = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = v[k-1];
        while(start < end){
            int mid = (start + end) / 2;

            int x = v[0];
            int cnt = 1;
            for(int i = 1; i < k; i++){
                if(x + mid < v[i]){
                    x = v[i];
                    cnt++;
                }
            }
            if(cnt < m)
                end = mid;
            else start = mid + 1;
        }
        int dis = start - 1;

        System.out.print(1);
        int x = v[0]; m--;
        for(int i = 1; i < k; i++){
            if(m == 0){
                System.out.print(0); continue;
            }
            if(v[i] - x > dis){
                x = v[i];
                System.out.print(1);
                m--;
            }
            else System.out.print(0);
        }

    }

}