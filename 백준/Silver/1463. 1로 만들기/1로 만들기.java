import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Queue<xy> q = new LinkedList<>();

        int[] visit = new int[n + 1];
        q.add(new xy(n, 0));

        while(!q.isEmpty()) {
            xy x = q.poll();

            if(x.x == 1){
                System.out.print(x.cnt);
                break;
            }

            if(visit[x.x] == 1)
                continue;
            visit[x.x] = 1;

            if(x.x % 3 == 0)
                q.add(new xy(x.x / 3, x.cnt + 1));
            if(x.x % 2 == 0)
                q.add(new xy(x.x / 2, x.cnt + 1));
            q.add(new xy(x.x - 1, x.cnt + 1));
        }

    }

    static public class xy{
        int x;
        int cnt;
        xy(int x,int cnt){
            this.x=x;
            this.cnt=cnt;
        }
    }





}
