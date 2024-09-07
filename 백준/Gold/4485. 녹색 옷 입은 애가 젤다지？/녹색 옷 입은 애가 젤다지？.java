import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int[][] v = new int[126][126];
    static int[][] dis = new int[126][126];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = 1;
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;

            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++){
                    v[i][j] = sc.nextInt();
                    dis[i][j] = Integer.MAX_VALUE;
                }

            bfs(n);

            System.out.println("Problem "+p +": " + dis[n-1][n-1]);
            p++;

        }
    }
    public static void bfs(int n){
        Queue<Dis> q = new LinkedList<>();
        q.add(new Dis(0,0,v[0][0]));
        while(q.size()!=0){
            Dis cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int sum = cur.n;
            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                int nsum = sum + v[nx][ny] ;
                if(dis[nx][ny] <= nsum) continue;
                dis[nx][ny] = Math.min(nsum, dis[nx][ny]);
                q.add(new Dis(nx,ny,nsum));
            }
        }

    }

    public static class Dis{
        int x,y,n;
        Dis(int x,int y,int n){
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

}
