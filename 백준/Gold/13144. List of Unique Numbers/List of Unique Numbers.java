import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            v[i] = Integer.parseInt(st.nextToken());

        boolean[] map = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();

        long cnt = 0;
        int start = 0;
        for(int i=0;i<n;i++){

            while(map[v[i]]){
                map[v[start]] = false;
                start++;
                cnt += q.size();
                q.poll();

            }
            q.add(v[i]);
            map[v[i]] = true;
        }
        while(q.size()!=0){
            cnt += q.size();
            q.poll();
        }


        System.out.println(cnt);

    }


}
