        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static int flag;
            static int[] dx = {1,0,-1,0};
            static int[] dy = {0,1,0,-1};
            static char[][] map;
            static ArrayList<xy> teachers = new ArrayList<>();
            static int n;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;
                n = Integer.parseInt(br.readLine());
                map = new char[n][n];

                for(int i = 0; i < n; i++){
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < n; j++) {
                        map[i][j] = st.nextToken().charAt(0);
                        if(map[i][j] == 'T'){
                            teachers.add(new xy(i, j));
                        }
                    }

                }
                dfs(0,0);
                if(flag == 1) System.out.println("YES");
                else System.out.println("NO");

            }
            static void dfs(int index, int cnt){
                if(cnt == 3){
                    if(check()) flag = 1;
                    return;
                }
                for(int i = index; i < n*n; i++){
                    int x = i / n;
                    int y = i % n;
                    if(map[x][y] == 'X'){
                        map[x][y] = 'B';
                        dfs(i + 1, cnt + 1);
                        map[x][y] = 'X';
                    }
                }
            }
            static boolean check(){
                for(xy teacher : teachers){
                    for(int i = 0; i<4;i++){
                        int x = teacher.x;
                        int y = teacher.y;
                        while(true) {
                            x += dx[i];
                            y += dy[i];
                            if (x < 0 || x >= n || y < 0 || y >= n) break;
                            if (map[x][y] == 'B') break;
                            if (map[x][y] == 'S') return false;
                        }

                    }
                }
                return true;
            }



            static class xy{
                int x;
                int y;
                    xy(int x, int y){
                        this.x = x;
                        this.y = y;
                    }
            }

        }


