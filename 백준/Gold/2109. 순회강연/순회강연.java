import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        xy[] v = new xy[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[i] = new xy(a, b);
        }

        Arrays.sort(v, (a, b) -> a.date - b.date);
        PriorityQueue<xy> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i = 0; i < n; i++){
            if(pq.isEmpty() || pq.size() < v[i].date){
                pq.add(v[i]);
                continue;
            }

            if(pq.peek().val < v[i].val){
                pq.poll();
                pq.add(v[i]);
            }
        }
        int an = 0;
        while(!pq.isEmpty()){
            an += pq.poll().val;
        }
        System.out.println(an);

    }
    static class xy{
        int val, date;
        xy(int a, int b){
            val = a; date = b;
        }
    }

}
