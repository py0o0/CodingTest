import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int x = (int) Math.round(n * 0.15);

        for(int i=0;i<x;i++)
            pq.poll();

        int sum = 0;
        int cnt = 0;
        while(pq.size() > x) {
            sum += pq.poll();
            cnt++;
        }
        if(sum == 0)
            System.out.println(0);
        else
            System.out.println(Math.round((double) sum/cnt));


    }

}
