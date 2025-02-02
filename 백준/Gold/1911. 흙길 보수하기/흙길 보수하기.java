import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long l = Long.parseLong(st.nextToken());

        xy[] v = new xy[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            v[i] = new xy();
            v[i].s = s;
            v[i].e = e;
        }

        Arrays.sort(v,(a,b)->{
            return Long.compare(a.s,b.s);
        });

        long an = 0;
        long pre = 0;
        for(int i = 0; i < n; i++){
            if(pre >= v[i].e) continue;
            else if(pre > v[i].s) v[i].s = pre;

            long x = v[i].e - v[i].s;

            if(l >= x){
                an++;
                pre = v[i].s + l;
            }

            else if(x%l == 0){
                an += x/l;
                pre = v[i].e;
            }
            else{
                an += x/l + 1;
                long val = l - (x%l);
                pre = v[i].e + val;
            }

        }
        System.out.println(an);

    }
    static class xy{
        long s;
        long e;
    }
}