import java.io.*;
import java.util.*;

class Main{

    static int[][] v;
    static int[][] r;
    static int e,n;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) v[i][0] = Integer.parseInt(st.nextToken());

        r = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                r[i][j] = Integer.parseInt(st.nextToken());
        }
        e = Integer.parseInt(br.readLine());

        dfs(0,n);
        System.out.println(max);
    }

    static void dfs(int cnt, int num){
        if(num == 1) return;

        if(num % 2 == 1){
            int max = Integer.MIN_VALUE;
            int i = 0;

            for(int j = 0; j < n; j++){
                if(v[j][1] == 1) continue;

                if(max < v[j][0]){
                    max = v[j][0];
                    i = j;
                }

            }

            if(i == e) return;

            v[i][1] = 1; // 죽임
            dfs(cnt, num-1);
            v[i][1] = 0;
        }
        else{
            cnt++;
            max = Math.max(cnt, max);

            for(int i = 0; i < n; i++){
                if(v[i][1] == 1) continue;
                if(i == e) continue;

                for(int j = 0; j < n; j++){
                    if(i == j) continue;

                    v[j][0] += r[i][j];
                }
                v[i][1] = 1;
                dfs(cnt, num-1);
                v[i][1] = 0;
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    v[j][0] -= r[i][j];
                }

            }
        }
    }

}