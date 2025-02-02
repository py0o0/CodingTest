import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 1;


        xy[] v = new xy[n];

        for(int i=0; i<n - 1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            v[i] = new xy();
            v[i].x = x;
            v[i].g = g;
        }

        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        v[n - 1] = new xy();
        v[n - 1].x = target;
        v[n - 1].g = 0;

        Arrays.sort(v,(a,b) -> a.x - b.x);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b- a);

        int pre = 0;
        int an = 0;
        for(int i=0; i<n; i++){
            int use = v[i].x - pre;
            g -= use;

            if(g < 0){
                int flag = 0;
                while(pq.size() > 0){
                    g += pq.poll();
                    an++;
                    if(g >= 0){
                        flag = 1; break;
                    }
                }
                if(flag == 0){
                    System.out.println(-1);
                    return;
                }
            }
            pre = v[i].x;
            pq.add(v[i].g);

        }
        System.out.println(an);
    }

    static class xy{
        int x;
        int g;
    }
}