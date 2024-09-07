import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {


    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]an = new int[n][m];
        int [][]v = new int[n][m];
        Queue<xy> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                v[i][j] = sc.nextInt();
                an[i][j] = Integer.MAX_VALUE;
                if(v[i][j] == 2) {
                    q.add(new xy(i, j, 0));
                    an[i][j] = 0;
                }
            }

        while(q.size() != 0){
            xy d = q.poll();
            int x = d.x;
            int y = d.y;
            int sum = d.n;
            for(int k=0;k<4;k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if(v[nx][ny] == 0) continue;
                int nsum = sum+1;
                if(nsum>=an[nx][ny]) continue;
                an[nx][ny] = nsum;
                q.add(new xy(nx, ny, nsum));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(an[i][j] == Integer.MAX_VALUE){
                    if(v[i][j] == 0)
                        an[i][j] = 0;
                    else
                        an[i][j] = -1;
                }
                System.out.print(an[i][j]+" ");
            }
            System.out.println();
        }


    }
    public static class xy {
        int x;
        int y;
        int n;
        public xy(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }


}
