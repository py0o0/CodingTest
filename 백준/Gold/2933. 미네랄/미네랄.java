import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static char[][] map;
            static int[][] visit;
            static int[] dx  = {1,-1};
            static int n,m;
            static boolean isC, notC, flag;
            static ArrayList<xy> minerals = new ArrayList<>();
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                map = new char[n][m];
                visit = new int[n][m];
                for(int i = 0; i < n; i++){
                    String s = br.readLine();
                    for(int j = 0; j < m; j++)
                        map[i][j] = s.charAt(j);
                }
                int l = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                int i = 1;

                while(l-- > 0){
                    i = (i+1)%2;
                    int t = Integer.parseInt(st.nextToken());
                    xy x = Throw(n - t, i); //한칸 지우기
                    if(x == null) continue;  //지울 칸이 없으면 넘김
                    map[x.x][x.y] = '.';

                    xy a = new xy();
                    a.x = x.x -1;
                    a.y = x.y;


                    for(int j = 0; j<n;j++)
                        for(int k = 0; k<m; k++)
                            visit[j][k] = 0;

                    //초기화

                    check(a);  // 위의 클러스터 확인
                    if(!isC || notC){
                        a.x = x.x;
                        a.y = x.y - 1;
                        check(a);
                        if(!isC  || notC){
                            a.y += 2;
                            check(a);
                            if(!isC || notC) {
                                a.x = x.x + 1;
                                a.y = x.y;
                                check(a);
                            }
                        }
                    }

                    if(!isC|| notC) continue; //클러스터 존재하지 않음

                    Collections.sort(minerals,(xy xx,xy yy)->yy.x - xx.x); // 낮은 녀석 부터 정렬

                    flag = false;
                    while(!flag){

                        for(xy m : minerals){ //모든 미네랄 한 칸 씩 내림
                            map[m.x][m.y] = '.';
                            int nx = m.x+1;
                            if(nx >= n) {flag = true;break;}
                            if(map[nx][m.y] == 'x') {flag = true; break;}
                        }


                        if(flag){
                            for(xy m : minerals)
                                map[m.x][m.y] = 'x';
                            break;
                        }
                        for(xy m : minerals){
                            m.x++;
                            map[m.x][m.y] = 'x';
                        }
                    }

                }

                for(int j = 0; j< n; j++){
                    for(int k = 0; k < m; k++)
                        System.out.print(map[j][k]);
                    System.out.println();
                }

            }

            static void check(xy x){
                isC = false;
                if(x.x < 0 || x.x >= n || x.y < 0 || x.y >= m) return;
                if(map[x.x][x.y] != 'x') return;
                if(visit[x.x][x.y] == 1) return;

                isC = true;
                notC = false;
                minerals.clear();
                dfs(x.x,x.y);
            }

            static void dfs(int x, int y){
                if(x < 0 || x >= n || y < 0 || y >= m) return;
                if(map[x][y] != 'x') return;

                if(visit[x][y] == 1) return;
                if(x == n - 1){notC = true; return;}

                visit[x][y] = 1;
                xy a = new xy();
                a.x = x; a.y = y;
                minerals.add(a);

                dfs(x +1,y); dfs(x ,y - 1); dfs(x ,y + 1); dfs(x -1,y);

            }

            static xy Throw(int x, int i){
                xy a = new xy();
                a.x = x;
                if(i == 0) a.y = 0;
                if(i == 1) a.y = m - 1;
                while(true){
                    if(map[a.x][a.y] == 'x') return a;
                    int ny = a.y + dx[i];
                    if(ny < 0 || ny >= m) return null;
                    a.y = ny;

                }
            }
            static class xy{
                int x;
                int y;

            }

        }


