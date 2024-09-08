import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {


    static Scanner sc = new Scanner(System.in);
    static char[][] map;
    static int[] al;
    static int Max = 0;
    public static void main(String[] args){
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        al = new int[26];
        for(int i = 0; i < n; i++){
            String input = sc.next();
            for(int j = 0; j < m; j++)
                map[i][j] = input.charAt(j);
        }

        dfs(0,0,n,m,0);
        System.out.println(Max);
    }
    public static void dfs(int x,int y,int n,int m,int cnt){
        if(x<0 || y<0 || x>=n || y>=m) return;
        if(al[map[x][y] - 'A'] > 0) return;
        cnt++;
        Max = Math.max(Max,cnt);
        al[map[x][y] - 'A'] = 1;
        dfs(x+1,y,n,m,cnt);
        dfs(x,y+1,n,m,cnt);
        dfs(x-1,y,n,m,cnt);
        dfs(x,y-1,n,m,cnt);
        al[map[x][y] - 'A'] = 0;


    }

}
