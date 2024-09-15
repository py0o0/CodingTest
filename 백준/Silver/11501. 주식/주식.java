import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       st = new StringTokenizer(br.readLine());
       int t = Integer.parseInt(st.nextToken());

       while(t-- > 0){
           st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());
           int[] v = new int[n];
           st = new StringTokenizer(br.readLine());

           PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt((xy o) -> o.m).reversed());

           for(int i = 0; i < n; i++) {
               v[i] = Integer.parseInt(st.nextToken());
               pq.add(new xy(v[i], i));
           }

           ArrayList<xy> arr = new ArrayList<>();
           arr.add(pq.poll());
           while(!pq.isEmpty()){
               xy x = pq.poll();
               if(x.i > arr.get(arr.size() - 1).i){
                   arr.add(x);
               }
           }

           int cur = 0;
           long sum = 0;
           int index = 0;
           while(cur < n){
               int max = arr.get(index).m;
               int max_cur = arr.get(index).i;

               int val = 0;
               int cnt = 0;
               while(cur < max_cur){
                   val += v[cur];
                   cur++; cnt++;
               }

               sum += max * cnt - val;
               cur = max_cur + 1;
               index++;
           }

           System.out.println(sum);

       }

    }


    static public class xy {
        int m;
        int i;

        // 생성자
        public xy(int m, int i) {
            this.m = m;
            this.i = i;
        }
    }

}
