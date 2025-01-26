import java.util.*;
import java.io.*;

    class Main {

        static char[][] map;
        static int r, c;
        static int max;
        static int[] check = new int[26];
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new char[r][c];

            for(int i =0; i<r;i++){
                String line = br.readLine();
                for(int j =0; j<c;j++)
                    map[i][j] = line.charAt(j);
            }

            dfs(0,0,1);
            System.out.println(max);

        }
        static void dfs(int x, int y, int cnt){
            if(x < 0 || y < 0 || x >= r || y >= c) return;

            char c = map[x][y];
            if(check[c - 'A'] == 1) return;

            check[c - 'A'] = 1;
            max = Math.max(max, cnt);
            char c2 = map[x][y];
            dfs(x, y+1, cnt+1);
            dfs(x, y-1, cnt+1);
            dfs(x+1, y, cnt+1);
            dfs(x-1, y, cnt+1);
            check[c - 'A'] = 0;
        }



    }
