        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static char[][] map;
            static int[][] visit;
            static int n,m,cnt,flag;
            static int[] dx = {-1,0,1};
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                map = new char[n][m];
                visit = new int[n][m];
                for (int i = 0; i < n; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < m; j++)
                        map[i][j] = line.charAt(j);
                }


                for(int i = 0; i<n; i++) {
                    flag = 0;
                    gogo(i,0);
                }
                System.out.println(cnt);

            }
            static void gogo(int start, int y){
                if(start < 0 || start >= n) return;
                if(map[start][y] == 'x' || visit[start][y] == 1) return;
                if(y == m - 1){
                    flag = 1;
                    cnt++;
                    return;
                }
                visit[start][y] = 1;
                for(int i = 0; i < 3; i++){
                    if(flag == 1) break;
                    int nx = start + dx[i];
                    gogo(nx, y + 1);
                }

            }



        }

