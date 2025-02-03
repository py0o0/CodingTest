import java.io.*;
import java.util.*;

class Main{

    static int[][] map;
    static int[][] visit;
    static int r,c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visit = new int[r][c];

        Queue<xy> q = new LinkedList<>();

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) q.add(new xy(i,j,map[i][j]));
            }
        }
        int an = 0;
        while(!q.isEmpty()){


            an++;
            int size = q.size();
            while(size-- > 0){    //이 로직만 고쳐잇!
                xy x = q.poll();

                int cnt = 0;
                if(map[x.x+1][x.y] == 0) cnt++;
                if(map[x.x][x.y+1] == 0) cnt++;
                if(map[x.x][x.y-1] == 0) cnt++;
                if(map[x.x-1][x.y] == 0) cnt++;

                x.val -= cnt;

               q.add(x);
            }

            size = q.size();
            while(size-- > 0){
                xy x = q.poll();

                map[x.x][x.y] = x.val;
                if(map[x.x][x.y] < 1) map[x.x][x.y] = 0;
                else q.add(x);

            }


            for(int i = 0; i < r; i++)
                for(int j = 0; j < c; j++) visit[i][j] = 0;

            int cnt = 0;
            size = q.size();
            while(size-- > 0){
                xy x = q.poll();

                if(visit[x.x][x.y] == 0){
                    cnt++;
                    dfs(x.x,x.y);
                }

                if(cnt > 1){
                    System.out.println(an);
                    return;
                }
                q.add(x);
            }

        }
        System.out.println(0);
    }

    static void dfs(int x, int y){
        if(x < 0 || y < 0 || x >= r || y >= c) return;
        if(visit[x][y] == 1 || map[x][y] == 0) return;
        visit[x][y] = 1;
        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x, y-1);
        dfs(x-1, y);
    }

    static class xy{
        int x,y,val;
        xy(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

}