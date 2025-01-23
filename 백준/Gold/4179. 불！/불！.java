import java.util.*;
import java.io.*;

    class Main {

        public static char[][] map;
        public static int r,c;
        public static int[][] visit;
        public static int[] dx = {1,-1,0,0};
        public static int[] dy = {0,0,-1,1};
        public static Queue<xy> fire;
        public static Queue<xy> people;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[r][c];
            visit = new int[r][c];


            people = new LinkedList<>();
            fire = new LinkedList<>();

            for(int i = 0; i<r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    map[i][j] = line.charAt(j);
                    if(map[i][j] == 'J') {
                        people.add(new xy(i, j));
                        visit[i][j] = 1;
                    }
                    else if(map[i][j] == 'F')
                        fire.add(new xy(i,j));
                }
            }
            int turn = 1;

            while(true){
                if(move())
                    break;
                fire();
                if(people.size() == 0){
                    System.out.print("IMPOSSIBLE");
                    return;
                }
                turn++;
            }
            System.out.print(turn);

        }
        static boolean move(){
            int size = people.size();
            while(size > 0) {
                size--;
                xy x = people.poll();
                if (map[x.x][x.y] == 'F') continue;

                for (int k = 0; k < 4; k++) {
                    int nx = x.x + dx[k];
                    int ny = x.y + dy[k];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c)
                        return true;

                    if (map[nx][ny] == 'F' || map[nx][ny] == '#' || visit[nx][ny] == 1) continue;

                    visit[nx][ny] = 1;
                    people.add(new xy(nx, ny));
                }
            }
            return false;
        }

        static void fire(){
            int size = fire.size();
            while(size > 0){
                size--;
                xy y = fire.poll();

                for(int k = 0; k<4;k++){
                    int nx = y.x + dx[k];
                    int ny = y.y + dy[k];
                    if(nx < 0 || nx >= r || ny <0 || ny >= c) continue;
                    if(map[nx][ny]== 'F' || map[nx][ny]=='#') continue;
                    map[nx][ny] = 'F';
                    fire.add(new xy(nx, ny));
                }

            }
        }

        static class xy{
            int x;
            int y;
            xy(int x,int y){
                this.x = x;
                this.y = y;
            }
        }

    }
