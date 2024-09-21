import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] map = new int[101];
        int[] visit = new int[101];

        for(int i = 0; i<101; i++)
            map[i] = i;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i< n+m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        Queue<xy> q = new LinkedList<>();

        q.add(new xy(1,1));

        int flag = 0;
        while(!q.isEmpty()){
            xy x = q.poll();

            for(int i= 1; i<7; i++){
                int nx = x.x + i;

                if(nx > 100)
                    continue;

                nx = map[nx];
                
                if(visit[nx] == 1)
                    continue;
                
                visit[nx] = 1;
                
                if(nx == 100){
                    System.out.println(x.cnt);
                    flag = 1;
                    break;
                }

                q.add(new xy(nx,x.cnt + 1));

            }
            if(flag == 1)
                break;
        }




    }
    static public class xy{
        int x;
        int cnt;
        xy(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }

}
