import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v = new int[n];

        for(int i = 0; i < n; i++){
            v[i] = 1; // 카약이 있는 팀
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(st.nextToken()) - 1;
            v[x] = 0; // 카약이 없는 팀
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            int x = Integer.parseInt(st.nextToken()) - 1;
            if(v[x] == 0) v[x] = 1; // 예비를 사용
            else v[x] = 2; // 예비 있음
        }

        for(int i = 0; i < n; i++){
            if(v[i] == 2){
                if(i > 0 && v[i - 1] == 0) v[i - 1] = 1;
                else if(i < n - 1 && v[i + 1] == 0) v[i + 1] = 1;
            }
        }

        int an = 0;
        for(int i = 0; i < n; i++){
            if(v[i] == 0) an++;
        }

        System.out.println(an);

    }

}
