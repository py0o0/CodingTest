        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static Queue<xy>[][] map;
            static int[][] visit;
            static int n,m;
            static boolean[][] bool;
            static int[] dx = {1,0,-1,0};
            static int[] dy = {0,1,0,-1};
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());

                map = new Queue[n][n];
                visit = new int[n][n];
                bool = new boolean[n][n];
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++) {
                        map[i][j] = new LinkedList<>();
                        bool[i][j] = false;
                    }


                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken()) -1;
                    int y = Integer.parseInt(st.nextToken()) -1;
                    int a = Integer.parseInt(st.nextToken()) -1;
                    int b = Integer.parseInt(st.nextToken()) -1;
                    map[x][y].add(new xy(a,b));
                }

                int an = 1;
                Queue<xy> q = new LinkedList<>();
                visit[0][0] = 1;
                bool[0][0] = true;
                while(!map[0][0].isEmpty()) { // 0,0에 있는 스위치 다킴, 불 켜진 방 좌표 저장
                    xy x = map[0][0].poll();
                    if(bool[x.x][x.y]) continue;
                    bool[x.x][x.y] = true;
                    q.add(x);
                    an++;
                }

                while(q.size() > 0){ // 스위치가 켜져있고, 방문 안한 장소 탐색
                    int cnt = 0;
                    int flag = 0;
                    int size = q.size();
                    while(size-- > 0){
                        xy x = q.poll();
                        if(visit[x.x][x.y] == 1) continue;
                        if(!check(x.x,x.y)) { // 불 켜진 장소가 갈 수 없는 장소면 다시 큐에 삽입
                            q.add(x); continue;
                        }
                        visit[x.x][x.y] = 1; //방문 처리
                        flag = 1;
                        while(map[x.x][x.y].size() > 0) {
                            xy a = map[x.x][x.y].poll();
                            if(bool[a.x][a.y]) continue; // 이미 불 켜진 좌표의 스위치는 넘김
                            bool[a.x][a.y] = true;
                            cnt++;
                            q.add(a);
                        }
                    }
                    an += cnt;
                    if(flag == 0) break; //방문할 수 있는 곳이 없음
                }
                System.out.println(an);


            }
            static boolean check(int x, int y) {
                for(int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(visit[nx][ny] == 1) return true;
                }
                return false;

            }

            static class xy{
                int x,y;
                xy(int x,int y){
                    this.x = x; this.y = y;
                }
            }

        }
