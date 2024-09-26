    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(n == 1 && m == 1){
                System.out.println(0);
                return;
            }

            int[][] map = new int[n][m];
            int[][] visit = new int[n][m];

            for(int i = 0; i < n; i++){
                String s = br.readLine();
                for(int j = 0; j < m; j++)
                    map[i][j] = s.charAt(j) - '0';
            }
            PriorityQueue<xy> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
            pq.add(new xy(0,0,0));
            visit[0][0] = 1;

            int[] dx = {1,0,-1,0};
            int[] dy = {0,1,0,-1};
            int flag = 0;
            while(!pq.isEmpty()){
                xy x = pq.poll();
                for(int i =0; i<4; i++){
                    int nx = x.x + dx[i];
                    int ny = x.y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(visit[nx][ny] == 1) continue;
                    visit[nx][ny] = 1;

                    if(nx == n-1 && ny == m-1){
                        System.out.println(x.cnt);
                        flag = 1;
                        break;
                    }

                    if(map[nx][ny] == 0)
                        pq.add(new xy(nx,ny,x.cnt));
                    else
                        pq.add(new xy(nx,ny,x.cnt + 1));
                }
                if(flag ==1)
                    break;
            }



        }
        static class xy{
            int x;
            int y;
            int cnt;
            xy(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }

    }
