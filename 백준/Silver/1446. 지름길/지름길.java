import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] visit;
    static ArrayList<Integer>[] g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] v = new int[D+1];

        for(int i=0;i<=D;i++)
            v[i] = i;

        xy[] road = new xy[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            road[i] = new xy(s, e, d);
        }

        Arrays.sort(road, new Comparator<xy>(){
            @Override
            public int compare(xy x, xy y) {
                if (x.s != y.s)
                    return x.s - y.s;
                 else if (x.d != y.d)
                    return x.d - y.d;
                 else
                    return x.e - y.e;
            }
        });



        for(xy x : road){
            if(x.e > D ||v[x.s] + x.d > v[x.e])
                continue;

            v[x.e] = v[x.s] + x.d;
            int cur = 0;
            for(int i = x.e; i <= D; i++){
                v[i] = Math.min(v[i], v[x.e] + cur);
                cur++;
            }
        }
        System.out.println(v[D]);

    }

    static public class xy{
        int s;
        int e;
        int d;
        xy(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }
    }





}
