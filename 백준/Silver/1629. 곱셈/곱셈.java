import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(dfs(a,b,c));

    }
    static long dfs(long a, long b, long c){
        if(b == 1)
            return a % c;

        long val = dfs(a,b/2,c);
        val %= c;
        val = (val * val) % c;

        if(b%2 == 0)
            return val;
        else
            return (a * val) % c;
    }




}