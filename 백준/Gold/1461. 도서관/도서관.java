import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minus = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> plus = new PriorityQueue<>((x, y) -> y - x);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x < 0)
                minus.add(-x);
            else plus.add(x);
        }

        int an = 0;
        int x = (minus.isEmpty()) ? 0 : minus.peek();
        int y = (plus.isEmpty()) ? 0 : plus.peek();

        if(x > y) an -= x;
        else an -= y;

        while(!minus.isEmpty() || !plus.isEmpty()) {
            if(plus.isEmpty()){
                int i = 0;
                an += minus.peek() * 2;
                while(!minus.isEmpty() && i++ < m) minus.poll();
            }
            else if(minus.isEmpty()){
                int i = 0;
                an += plus.peek() * 2;
                while(!plus.isEmpty() && i++ < m)  plus.poll();

            }
            else{
                if(minus.peek() > plus.peek()){
                    int i = 0;
                    an += minus.peek() * 2;
                    while(!minus.isEmpty() && i++ < m) minus.poll();
                }else{
                    int i = 0;
                    an += plus.peek() * 2;
                    while(!plus.isEmpty() && i++ < m)  plus.poll();
                }
            }
        }
        System.out.println(an);
    }
}