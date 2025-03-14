import java.io.*;
import java.util.*;

class Main{

    static int[] dx = {1,-1,0,0,2,2,-2,-2,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1,2,-2,2,-2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if(n == 1 && m == 1){
            System.out.println(0);
            return;
        }

        int[][]map = new int[n][m];
        int[][][] visit = new int[n][m][k+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Monkey> monkey = new LinkedList<>();
        monkey.add(new Monkey(0,0,k,0));

        while(!monkey.isEmpty()){
            Monkey x = monkey.poll();
            for(int i = 0; i < dx.length; i++){
                if(x.k == 0 && i > 3) continue;
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(nx == n-1 && ny == m-1){
                    System.out.println(x.cnt + 1); return;
                }

                int index = 0;
                if(i > 3) index = 1;

                if(map[nx][ny] == 1 || visit[nx][ny][x.k - index]==1) continue;
                visit[nx][ny][x.k - index] = 1;

                monkey.add(new Monkey(nx,ny,x.k - index,x.cnt+1));

            }

        }
        System.out.println(-1);

    }
    static class Monkey{
        int x,y,k,cnt;
        Monkey(int x,int y,int k,int cnt){
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}