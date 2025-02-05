import java.io.*;
import java.util.*;

class Main{

    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++)
                map[i][j] = line.charAt(j) - '0';
        }

        dfs(0,0,n);

    }
    static void dfs(int x, int y, int n){
        int val = map[x][y];
        int flag=  0;
        for(int i = x; i < x+n; i++){
            for(int j = y; j < y+n; j++){
                if(map[i][j] != val){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) break;
        }

        if(flag == 0){
            System.out.print(val);
            return;
        }
        System.out.print('(');
        dfs(x,y,n/2);
        dfs(x,y + n/2,n/2);
        dfs(x+ n/2,y,n/2);
        dfs(x+n/2,y+n/2,n/2);
        System.out.print(')');
    }



}