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
            v[i].w = Integer.parseInt(st.nextToken());
            v[i].val = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(v,(a,b)->{
            if(a.val == b.val) return b.w-a.w;
            return a.val - b.val;
        });

        int sum = 0;
        int x = 0;
        for(int i=0; i<n; i++){
            sum += v[i].w;
            if(sum >= m){
                x = v[i].val;

                int j = i - 1;
                while(j > -1){
                    if(v[j].val != v[i].val) break;
                    x += v[j--].val;
                }

                for(j = i+1; j<n; j++){
                    if(v[j].val == v[i].val) continue;
                    if(x < v[j].val) break;
                    x = Math.min(x, v[j].val);
                }
                System.out.println(x);


                return;
            }
        }
        System.out.println(-1);

    }
    static class xy{
        int w;
        int val;
    }




}