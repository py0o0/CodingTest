import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0, 0, 1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] map = new int[h][m][n];

        Queue<xy> q = new LinkedList<>();
        for(int i = 0; i< h; i++){
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1)
                        q.add(new xy(i,j,k));
                }
            }
        }

        int flag = 0;
        int cnt = 0;
        while(flag == 0){

            Queue<xy> temp = new LinkedList<>();
            flag = 1;
            while(!q.isEmpty()){
                xy x = q.poll();
                for(int k = 0; k < 6; k++){
                    int nx = x.x + dx[k];
                    int ny = x.y + dy[k];
                    int nz = x.z + dz[k];

                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) continue;

                    if(map[nz][nx][ny] == 0){
                        temp.add(new xy(nz,nx,ny));
                        map[nz][nx][ny] = 1;
                        flag = 0;
                    }

                }
            }

            if(flag == 1) break;

            cnt++;
            q = temp;

        }

        for(int i = 0; i< h; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    if(map[i][j][k] == 0)
                        cnt = -1;
                }
            }
        }


        System.out.println(cnt);



    }
    static public class xy{
        int x;
        int y;
        int z;
        public xy(int z, int x, int y){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


}
