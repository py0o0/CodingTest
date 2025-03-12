import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] v = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            v[i] = Long.parseLong(st.nextToken());

        Arrays.sort(v);

        int cnt = 0;
        for(int i = 0; i < n; i++){

            int start = 0;
            if(start == i) start++;
            
            int end = n - 1;
            if(end == i) end--;
            while(start < end){
                if(v[i] == v[start] + v[end]){
                    cnt++; break;
                }
                else if(v[i] > v[start] + v[end]) {
                    start++; if(start ==i) start++;
                }
                else if(v[i] < v[start] + v[end]){
                    end--; if(end == i) end--;
                }
            }
        }
        System.out.println(cnt);



    }

}