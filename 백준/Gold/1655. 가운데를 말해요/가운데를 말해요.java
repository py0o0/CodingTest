import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lq = new PriorityQueue<>();
        PriorityQueue<Integer> hq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());

            if(hq.isEmpty()) hq.add(n);
            else if(hq.peek() < n) lq.add(n);
            else hq.add(n);

            if(hq.size() > i / 2 + 1){
                while(hq.size() > i / 2 + 1) lq.add(hq.poll());
            }
            else {
                while(hq.size() < i/2 + 1) hq.add(lq.poll());
            }

            System.out.println(hq.peek());
        }
    }



}