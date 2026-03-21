import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] map;
    static int[][] visit;
    static Queue<xy> fire = new LinkedList<>();
    static Queue<xy> person = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new int[n][m];

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'J'){
                    person.add(new xy(i, j));
                }
                else if(map[i][j] == 'F'){
                    fire.add(new xy(i, j));
                }
            }
        }

        int cnt = 0;
        while(true){
            cnt++;
            if(person.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
            if(movePerson()){
                System.out.println(cnt);
                return;
            }
            moveFire();
        }

    }
    static class xy{
        int x, y;
        public xy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean movePerson(){
        int size = person.size();
        while(size-- > 0){
            xy x = person.poll();
            if(map[x.x][x.y] == 'F') continue;
            for(int i = 0; i < 4; i++){
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) return true;
                if(map[nx][ny] == '#' || map[nx][ny] == 'F' || visit[nx][ny] == 1) continue;
                visit[nx][ny] = 1;
                person.add(new xy(nx, ny));
            }
        }
        return false;
    }

    static void moveFire(){
        int size = fire.size();
        while(size-- > 0){
            xy x = fire.poll();
            for(int i = 0; i < 4; i++){
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny] == '#' || map[nx][ny] == 'F') continue;
                map[nx][ny] = 'F';
                fire.add(new xy(nx, ny));
            }
        }
    }
}
