import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int r,c;
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int[][] map = new int[r][c];
            int[][] visit = new int[r][c];
            int[][] an = new int[r][c];
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,-1,1};
            int sx =0,sy =0;
            for(int i = 0; i<r;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<c;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    an[i][j] = -1;
                    if(map[i][j] == 2) {
                        sx = i; sy = j;
                    }
                }
            }
            Queue<xy> q = new LinkedList<>();
            visit[sx][sy]= 1;
            an[sx][sy] = 0;
            q.add(new xy(sx,sy,0));
            while(!q.isEmpty()){
                xy x = q.poll();
                for(int i = 0; i<4;i++){
                    int nx = x.x+dx[i];
                    int ny = x.y+dy[i];
                    if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
                    if(visit[nx][ny]==1) continue;
                    visit[nx][ny]=1;
                    if(map[nx][ny]==0) continue;

                    an[nx][ny]=x.cnt + 1;
                    q.add(new xy(nx,ny,x.cnt + 1));
                }
            }
            for(int i = 0; i<r;i++){
                for(int j = 0; j<c;j++) {
                    if (map[i][j] == 0 && an[i][j] == -1)
                        System.out.print("0 ");
                    else
                        System.out.print(an[i][j] + " ");
                }
                System.out.println();
            }
        }
        static class xy{
            int x, y, cnt;
            xy(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
        
    }
