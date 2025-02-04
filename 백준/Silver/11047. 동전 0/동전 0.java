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
        for(int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }

        int an = 0;
        for(int i = n-1; i >= 0; i--) {
            if(k >= v[i]){
                int x = k/v[i];
                an += x;
                k -= x * v[i];
            }
        }
        System.out.println(an);



    }



}