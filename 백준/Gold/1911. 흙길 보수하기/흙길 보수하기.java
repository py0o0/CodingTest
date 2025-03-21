import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long l = Integer.parseInt(st.nextToken());

        xy[] v = new xy[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].s = Long.parseLong(st.nextToken());
            v[i].e = Long.parseLong(st.nextToken());
        }

        Arrays.sort(v,(a,b)->Long.compare(a.s,b.s));

        long x = v[0].s;
        long an = 0;
        for(int i = 0; i < n; i++){
            if(x >= v[i].e) continue;
            
            x = Math.max(v[i].s, x);

            long temp = v[i].e - x;
            long cnt =  temp / l;

            if(temp % l != 0) cnt++;

            x = x + l * cnt;

            an += cnt;
        }
        System.out.println(an);
    }
    static class xy{
        long s,e;
    }
}