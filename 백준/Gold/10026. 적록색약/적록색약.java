import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int visit[][];
    static char[][][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new char[2][n][n];
        visit = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == 'G')
                    map[0][i][j] = 'R';
                else
                    map[0][i][j] = s.charAt(j);
                map[1][i][j] = s.charAt(j);
            }
        }

        int non_color = 0;
        int color = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visit[i][j] == 0){
                    dfs(0,i,j,n,map[0][i][j]);
                    non_color++;
                }
            }
        }

        for(int i = 0; i< n; i++)
            Arrays.fill(visit[i], 0);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visit[i][j] == 0){
                    dfs(1,i,j,n,map[1][i][j]);
                    color++;
                }
            }
        }
        System.out.println(color + " " + non_color);
    }

    static void dfs(int col, int x,int y, int n, char c){
        if(x < 0 || x >= n || y < 0 || y >= n) return;
        if(visit[x][y] == 1) return;
        if(map[col][x][y] != c) return;
        visit[x][y] = 1;

        for(int i = 0; i<4; i++)
            dfs(col,x+dx[i],y+dy[i],n,c);
    }

}
