import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        xy[] v = new xy[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            v[i] = new xy();
            v[i].name = st.nextToken();
            v[i].x = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(v,(a,b)->a.x-b.x);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            int x = Integer.parseInt(br.readLine());

            int start = 0;
            int end = n;

            while(start<end){
                int mid = (start+end)/2;

                if(v[mid].x>=x)
                    end = mid;
                else start = mid + 1;
            }
            sb.append(v[start].name + "\n");

        }
        System.out.println(sb.toString());



    }

    static class xy{
        String name;
        int x;
    }

}