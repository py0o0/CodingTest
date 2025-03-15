import java.io.*;
import java.util.*;

class Main{

    static int r,c;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n = 1;
        for(int i = 0; i < x; i++)
            n *= 2;


        dfs(0,0,n);


    }
    static void dfs(int x, int y, int n){
        if(n == 1){
            System.out.println(cnt);
            return;
        }
        if(r < x + n/2 && c < y + n/2) {
            dfs(x, y, n / 2);
        }
        else if( r < x + n/2 && c >= y + n/2 ) {
            cnt += ((n * n) / 4);
            dfs(x, y + n/2, n / 2);
        }
        else if(r >= x + n/2 && c < y + n/2 ) {
            cnt += ((n * n) / 4) * 2;
            dfs(x + n/2, y, n / 2);
        }
        else if (r >= x + n/2 && c >= y + n/2 ) {
            cnt += ((n * n) / 4) * 3;
            dfs(x + n / 2, y + n / 2, n / 2);
        }

    }
}