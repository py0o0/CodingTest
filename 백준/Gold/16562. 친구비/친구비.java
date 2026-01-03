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
        int k = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for(int i = 0; i <= n; i++) parents[i] = i;

        int[] cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) cost[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int[] v = new int[n + 1];
        for(int i = 1; i <= n; i++) v[i] = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++){
            int root = find(i);
            v[root] = Math.min(v[root], cost[i]);
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(v[i] != Integer.MAX_VALUE) sum += v[i];
        }

        if(sum > k)
            System.out.println("Oh no");
        else System.out.println(sum);
    }

    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        parents[a] = b;
    }

}
