import java.io.*;
import java.util.*;

class Main{

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[][][] visit = new int[n][m][4];

        xy start = new xy(-1,-1);

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'C') {
                    if (start.x == -1) {
                        start.x = i;
                        start.y = j;
                        map[i][j] = '.';
                    }
                }
                for(int k = 0; k < 4; k++)
                    visit[i][j][k] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Q> q = new PriorityQueue<>((a,b) -> a.cnt - b.cnt);
        q.add(new Q(start.x, start.y, 0,-1));


        while(!q.isEmpty()){
            Q x = q.poll();

            if(map[x.x][x.y] == 'C'){
                System.out.println(x.cnt);
                return;
            }

            for(int i = 0; i < 4; i++){
                if(x.dir != -1 && Math.abs(x.dir - i) == 2) continue;
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];

                int val = x.cnt;
                if(x.dir != i && x.dir != -1) val++;

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;


                if(map[nx][ny] == '*') continue;
                if(visit[nx][ny][i] <= val) continue;

                visit[nx][ny][i] = val;
                q.add(new Q(nx,ny,val,i));
            }

        }

    }
    static class Q{
        int x,y,cnt,dir;
        Q(int x,int y,int cnt,int dir){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    static class xy{
        int x,y;
        xy(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


}