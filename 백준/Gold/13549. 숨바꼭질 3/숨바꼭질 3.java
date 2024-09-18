import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visit = new int[100001];

        PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.s));

        pq.add(new xy(n,0));

        while(!pq.isEmpty()) {
            xy x = pq.poll();
            if(x.x < 0 || x.x > 100000 || visit[x.x] == 1)
                continue;
            visit[x.x] = 1;
            if(x.x == k) {
                System.out.println(x.s);
                break;
            }

            pq.add(new xy(x.x * 2,x.s ));
            pq.add(new xy(x.x + 1,x.s + 1));
            pq.add(new xy(x.x - 1,x.s + 1));
        }


    }
    public static class xy{
        int x;
        int s;
        public xy(int x,int s){
            this.x = x;
            this.s = s;
        }
    }


}
