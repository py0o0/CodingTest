import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        xy[] v = new xy[n + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].x = Integer.parseInt(st.nextToken());
            v[i].y = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int cnt = 0;

        v[n] = new xy();
        v[n].x = target;
        v[n].y = 0;
        
        Arrays.sort(v,(a,b)->a.x-b.x);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int dist = 0;
        for(int i =0; i<=n; i++){
            int use = v[i].x - dist;
            dist = v[i].x;

            total -= use;
            if(total < 0){
                while(!pq.isEmpty()){
                    total += pq.poll();
                    cnt++;
                    if(total >= 0)
                        break;
                }
                if(total < 0 && pq.isEmpty()){
                    System.out.println(-1 );
                    return;
                }
            }
            pq.add(v[i].y);

        }
        System.out.println(cnt);
    }
    static class xy{
        int x,y;
    }

}