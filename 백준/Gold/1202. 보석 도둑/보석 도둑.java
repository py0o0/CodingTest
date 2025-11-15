import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Item[] items = new Item[n];
        int[] bags = new int[m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item();
            items[i].w = Integer.parseInt(st.nextToken());
            items[i].val = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items, (a,b)->a.w-b.w);
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        long sum = 0;
        int index = 0;

        for(int bag : bags) {
            while(index < n && bag >= items[index].w){
                pq.add(items[index++].val);
            }

            if(!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);

    }
    static class Item{
        int w, val;
    }


}