import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        xy[] v = new xy[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].x = Integer.parseInt(st.nextToken());
            v[i].y = Integer.parseInt(st.nextToken());
        }

        int an = 0;
        for(xy c:v){
            for(xy s:v){
                int cnt = 0;
                for(xy k:v){
                    if(k.x >= c.x && k.x <= c.x + L && k.y >= s.y && k.y <= s.y + L)
                        cnt++;
                }
                an = Math.max(an, cnt);
            }

        }
        System.out.println(K - an);

    }
    public static class xy{
        int x,y;
    }

}
