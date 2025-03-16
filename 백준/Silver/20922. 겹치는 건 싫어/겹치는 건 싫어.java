import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());

        int[] map = new int[100001];
        int start = 0;
        int cnt = 0;
        int an = 0;
        for(int i = 0; i < n; i++){
            map[v[i]]++;

            if(map[v[i]] > k){
                while(map[v[i]] > k){
                    map[v[start++]]--;
                    cnt--;
                }
            }
            cnt++;
            an = Math.max(an, cnt);
        }
        System.out.println(an);
    }


}