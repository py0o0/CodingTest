import java.util.*;
import java.io.*;

public class Main {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for(int i = 1; i <= n; i++) parents[i] = i;

        int[] power = new int[n + 1];
        for(int i = 1; i <= n; i++){
            power[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                power[find(c)] += power[find(b)];
                union(b, c);
            }
            else{
                b = find(b);
                c = find(c);

                if(power[b] > power[c]){
                    power[b] -= power[c];
                    union(c, b);
                }
                else if(power[b] == power[c]){
                    parents[b] = 0;
                    parents[c] = 0;
                }
                else{
                    power[c] -= power[b];
                    union(b, c);
                }

            }
        }

        int[] v = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 1; i <= n; i++){
            int root = find(i);
            if(root == 0) continue;
            if(v[root] == 1) continue;
            v[root] = 1;
            pq.add(power[root]);
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }


    }

    static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parents[a] = b;
    }


}
