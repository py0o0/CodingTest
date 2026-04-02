import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<xy> q = new LinkedList<>();
        int[][][] map = new int[n][m][k];
        int[][][] visit = new int[n][m][k];

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        for(int i = 0; i < k; i++){
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                for(int l = 0; l < n; l++){
                    map[l][j][i] = Integer.parseInt(st.nextToken());
                    if(map[l][j][i] == 1){
                        visit[l][j][i] = 1;
                        q.add(new xy(l, j, i));
                    }
                }
            }
        }

        int an = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                xy x = q.poll();
                for(int i = 0; i < 6; i++){
                    int nx = x.x + dx[i];
                    int ny = x.y + dy[i];
                    int nz = x.z + dz[i];
                    if(nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= k) continue;
                    if(visit[nx][ny][nz] == 1) continue;
                    if(map[nx][ny][nz] == 0){
                        visit[nx][ny][nz] = 1;
                        map[nx][ny][nz] = 1;
                        q.add(new xy(nx, ny, nz));
                    }
                }
            }
            an++;
        }

        for(int i = 0; i < k; i++){
            for(int j = 0; j < m; j++){
                for(int l = 0; l < n; l++){
                    if(map[l][j][i] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(an - 1);

    }
    static class xy{
        int x, y, z;
        public xy(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
