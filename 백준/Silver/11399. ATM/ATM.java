import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(v);

        int sum = 0;
        int an = 0;
        for(int i = 0; i < n; i++){
            an += v[i] + sum;
            sum += v[i];
        }
        System.out.println(an);



    }



}