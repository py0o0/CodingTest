import java.io.*;
import java.util.*;

class Main{

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] p = new int[2][2];
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++)
                p[i][j] = -1;

        char[][] map = new char[n][m];
        int[][][] visit = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                for(int k = 0; k < 4; k++)
                    visit[i][j][k] = Integer.MAX_VALUE;

                map[i][j] = line.charAt(j);
                if(map[i][j] == 'C'){
                    if(p[0][0] == -1){
                        p[0][0] = i;
                        p[0][1] = j;
                        map[i][j] = '.';
                    }
                    else{
                        p[1][0] = i;
                        p[1][1] = j;
                    }
                }
            }
        }

        PriorityQueue<xy> pq = new PriorityQueue<>((a,b)->a.curb-b.curb);
        pq.add(new xy(p[0][0],p[0][1],0,-1));

        while(!pq.isEmpty()){
            xy x = pq.poll();

            if(map[x.x][x.y] == 'C'){
                System.out.println(x.curb - 1);
                return;
            }

            for(int i = 0; i < 4; i++){
                if(x.dir != -1 && x.dir == (i+2)%4 ) continue;
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny]== '*') continue;

                int curb = x.curb;
                if(x.dir != i) curb++;

                if(visit[nx][ny][i] <= curb) continue;
                visit[nx][ny][i] = curb;

                pq.add(new xy(nx,ny,curb,i));

            }
        }

    }
    static class xy{
        int x,y,curb,dir;
        xy(int x,int y,int curb,int dir){
            this.x = x;
            this.y = y;
            this.curb = curb;
            this.dir = dir;
        }
    }

}