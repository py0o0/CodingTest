import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        v = new int[n+1];
        for(int i = 1; i <= n; i++) v[i] = i;

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(x == 0){
                union(a,b);
            }else{
                if(findHead(a) == findHead(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    static int findHead(int x){
        if(x != v[x])
            v[x] = findHead(v[x]);
        return v[x];
    }
    static void union(int a, int b){
        int c = findHead(a);
        int d = findHead(b);
        if(c != d){
            v[c] = d;
        }
    }
}