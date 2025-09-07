import java.io.*;
import java.util.*;

class Main{

    public static Queue<xy> fire = new LinkedList<>();
    public static Queue<xy> p =  new LinkedList<>();
    public static char[][] map;
    public static int[][] visit;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int n,m,cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visit = new int[n][m];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'F'){
                    fire.add(new xy(i,j));
                }
                else if(map[i][j] == 'J'){
                    p.add(new xy(i,j));
                    visit[i][j] = 1;
                }
            }
        }
        cnt = 1;
        while(true){
            if(move()){
                System.out.println(cnt);
                return;
            }
            fire();
            cnt++;

            if(p.size() == 0) break;
        }
        System.out.println("IMPOSSIBLE");
    }

    public static boolean move(){
        int size = p.size();
        while(size-- > 0){
            xy x = p.poll();
            if(map[x.x][x.y] == 'F') continue;
            for(int i = 0; i < 4; i++){

                int nx = x.x + dx[i];
                int ny = x.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    return true;

                if(visit[nx][ny] == 1 || map[nx][ny] == 'F'|| map[nx][ny] == '#') continue;

                p.add(new xy(nx,ny));
                visit[nx][ny] = 1;
            }
        }
        return false;
    }
    public static void fire(){
        int size = fire.size();
        while(size-- > 0){
            xy f = fire.poll();

            for(int i = 0; i < 4; i++){
                int nx = f.x + dx[i];
                int ny = f.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == 'F' || map[nx][ny] == '#') continue;

                map[nx][ny] = 'F';
                fire.add(new xy(nx,ny));
            }
        }
    }
    public static class xy{
        int x;
        int y;
        public xy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}