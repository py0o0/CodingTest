import java.io.*;
import java.util.*;

class Main{

    static int[][] map;
    static int w,b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,n);
        System.out.println(w);
        System.out.println(b);
    }
    static void dfs(int x, int y, int n){
        int val = map[x][y];
        int flag = 0;
        for(int i = x; i < x+n; i++){
            for(int j = y; j < y+n; j++){
                if(val != map[i][j]){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) break;
        }

        if(flag == 0){
            if(val == 1) b++;
            else w++;
        }
        else{
            dfs(x , y , n/2);
            dfs(x+n/2 , y , n/2);
            dfs(x , y+n/2 , n/2);
            dfs(x+n/2 , y+n/2 , n/2);
        }
    }



}