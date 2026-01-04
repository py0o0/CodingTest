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

        int[] power = new int[n + 1];
        parents = new int[n + 1];
        for(int i = 1; i <= n; i++){
            power[i] = Integer.parseInt(br.readLine());
            parents[i] = i;
        }

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            b = find(b);
            c = find(c);
            if(a == 1){
                power[c] += power[b];
                union(b, c);
            }
            else{
                if(power[b] > power[c]){
                    power[b] -= power[c];
                    union(c, b);
                }
                else if(power[b] < power[c]){
                    power[c] -= power[b];
                    union(b, c);
                }
                else{
                    parents[b] = 0;
                    parents[c] = 0;
                }
            }
        }

        int an = 0;
        List<Integer> list = new ArrayList<>();
        int[] v = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int x = find(i);
            if(x == 0 || v[x] == 1) continue;
            v[x] = 1;
            list.add(power[x]);
            an++;
        }
        list.sort((a, b) -> a - b);

        System.out.println(an);
        for(int x : list) System.out.print(x + " ");

    }
    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) parents[a] = b;
    }



}
