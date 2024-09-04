import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] m;
    static int[][] visit;

    static Queue<xy> q,fire;


    static int[] dx  = {1,-1,0,0};
    static int[] dy  = {0,0,1,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        visit = new int[r][c];
        m = new char[r][c];
        q = new LinkedList<>();
        fire = new LinkedList<>();

        for(int i=0;i<r;i++){
            String s = sc.nextLine();
            for(int j=0;j<c;j++){
                m[i][j] = s.charAt(j);
                if(m[i][j] == 'J'){
                    visit[i][j] = 1;
                    m[i][j] = '.';
                    q.offer(new xy(i,j));

                    if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                        System.out.println(1);
                        return;
                    }
                }
                if(m[i][j] == 'F'){
                    fire.offer(new xy(i,j));
                }
            }
        }
        int n = 1;
        while(true){
            n++;
            Fire(r,c);
            if(Move(r,c))
                break;

            if(n > r*c){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println(n);
    }

    public static void Fire(int r, int c){
        int size = fire.size();
        for(int i=0;i<size;i++){
            xy x = fire.poll();

            for(int k=0;k<4;k++){
                int nx = x.x + dx[k];
                int ny = x.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c || m[nx][ny] != '.'){
                    continue;
                }
                m[nx][ny] = 'F';
                fire.offer(new xy(nx,ny));
            }

        }
    }

    public static boolean Move(int r, int c){
        int size = q.size();
        for(int i=0;i<size;i++){
            xy x = q.poll();

            for(int k=0;k<4;k++){
                int nx = x.x + dx[k];
                int ny = x.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c || m[nx][ny] != '.' || visit[nx][ny] == 1){
                    continue;
                }
                visit[nx][ny] = 1;
                q.offer(new xy(nx,ny));

                if(nx == 0 || nx == r - 1 || ny == 0 || ny == c - 1)
                    return true;
            }

        }
        return false;
    }


    public static class xy{
        int x;
        int y;
        xy(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
