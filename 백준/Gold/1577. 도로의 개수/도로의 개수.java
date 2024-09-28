 import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {

        static Cons[] cons;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(br.readLine());

            cons = new Cons[k];
            for(int i = 0; i<k;i++){
                st  = new StringTokenizer(br.readLine());
                cons[i] = new Cons();
                cons[i].x = Integer.parseInt(st.nextToken());
                cons[i].y = Integer.parseInt(st.nextToken());
                cons[i].nx = Integer.parseInt(st.nextToken());
                cons[i].ny = Integer.parseInt(st.nextToken());
            }
            long[][] map = new long[n + 1][m + 1];
            map[0][0] = 1;
            for(int i = 0; i<=n;i++){
                for(int j = 0; j<=m;j++){
                    if(i == 0 && j == 0) continue;
                    if(i == 0){
                        if(!block(i,j-1,i,j))
                            map[i][j] = map[i][j-1];

                    }
                    else if(j == 0){
                        if(!block(i - 1,j,i,j))
                            map[i][j] = map[i-1][j];
                    }
                    else{
                        if(!block(i,j-1,i,j))
                            map[i][j] += map[i][j-1];

                        if(!block(i - 1,j,i,j))
                            map[i][j] += map[i-1][j];
                    }

                }
            }

            System.out.println(map[n][m]);
        }
        static boolean block(int x, int y, int nx, int ny){
            for(Cons con : cons){
                if(con.x == x && con.y == y && con.nx == nx && con.ny == ny)
                    return true;
                if(con.nx == x && con.ny == y && con.x == nx && con.y == ny)
                    return true;
            }
            return false;
        }

        static class Cons{
            int x;
            int y;
            int nx;
            int ny;
        }



    }
