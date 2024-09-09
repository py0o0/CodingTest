import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new int[n][m][2];
        if(n == 1 && m == 1){
            System.out.println(1);
            return;
        }
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++)
                map[i][j] = s.charAt(j)-'0';

        }
        System.out.print(bfs(n,m));


    }
    public static int bfs(int n, int m) {
        Queue<xy> q = new LinkedList<>();
        q.add(new xy(0,0,1,0));
        visit[0][0][0] = 1;


        while(!q.isEmpty()){
            xy temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int cnt = temp.cnt;
            int smash = temp.smash;
            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(smash == 1 && map[nx][ny] == 1) continue;
                if(visit[nx][ny][smash] == 1)continue;
                visit[nx][ny][smash] = 1;

                if(nx == n-1 && ny == m-1)
                    return cnt + 1;


                if(map[nx][ny] == 0)
                    q.add(new xy(nx,ny,cnt + 1,smash));
                else if(map[nx][ny] == 1)
                    q.add(new xy(nx,ny,cnt + 1,1));

            }

        }
        return -1;
    }
    public static class xy{
        int x,y,cnt,smash;
        xy(int x,int y,int cnt,int smash){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.smash = smash;
        }
    };


}
