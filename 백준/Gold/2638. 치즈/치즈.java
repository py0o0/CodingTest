        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static int[] dx = {0,-1,0,1};
            static int[] dy = {1,0,-1,0};
            static int[][] map;
            static int[][] visit;
            static int n,m;
            static Queue<xy> cheses = new LinkedList<>();
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                map = new int[n][m]; visit = new int[n][m];
                int total = 0;
                for(int i = 0; i<n;i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j<m;j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                        if(map[i][j]==1)
                            total++;
                    }
                }
                cheses.add(new xy(0,0));

                int tar = 0, turn = 0;
                while(!cheses.isEmpty()){
                    Queue<xy> temp = new LinkedList<>();
                    while(!cheses.isEmpty())
                        temp.add(cheses.poll());

                    while(!temp.isEmpty()){ //바깥면과 인접해있는 치즈 추가
                        xy x = temp.poll();
                        dfs(x.x, x.y);
                    }

                    int size = cheses.size();
                    while(size-->0){ // 녹일 수 있는 치즈만 거르기
                        xy x = cheses.poll();
                        visit[x.x][x.y] = 0;
                        if(check(x.x, x.y)) cheses.add(new xy(x.x,x.y));
                    }

                    size = cheses.size();
                    while(size-->0){ // 치츠 녹이기
                        xy x = cheses.poll();
                        map[x.x][x.y] = 0;
                        cheses.add(new xy(x.x,x.y));
                    }
                    
                    tar += cheses.size();
                    turn++;
                    if(tar == total) break;

                }
                System.out.println(turn);
            }
            static boolean check(int x, int y){
                int cnt =0;
                for(int i =0; i<4;i++){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if( nx < 0 || nx >= n || ny < 0 || ny >= m ) continue;
                    if(map[nx][ny] == 0 && visit[nx][ny] == 1) //외부 공기 = 비짓 처리된 공기
                        cnt++;
                }
                if(cnt > 1) return true;
                return false;
            }

            static void dfs(int x, int y){
                if(x < 0 || x >= n || y < 0 || y >= m) return;
                if(visit[x][y] == 1) return;

                visit[x][y] = 1;
                if(map[x][y] == 1){
                    cheses.add(new xy(x, y)); //치즈 다넘
                    return;
                }
                dfs(x + 1, y); dfs(x - 1, y); dfs(x, y - 1); dfs(x, y + 1);

            }

            static class xy{
                int x,y;
                xy(int x,int y){
                    this.x = x; this.y = y;
                }
            }

        }


