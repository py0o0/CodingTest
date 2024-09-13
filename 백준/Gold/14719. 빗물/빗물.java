import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       st = new StringTokenizer(br.readLine());
       int h = Integer.parseInt(st.nextToken());
       int w = Integer.parseInt(st.nextToken());

       st = new StringTokenizer(br.readLine());
       int[][] m = new int[h][w];
       for(int i=0;i<w;i++) {
           int x = Integer.parseInt(st.nextToken());
           for(int j=0;j<x;j++)
               m[j][i] = 1;
       }

       
       int t = 0;
       for(int i=0;i<h;i++) {
           int cnt = 0;
           int start = -1;
           for(int j=0;j<w;j++) {
               if(start==-1 && m[i][j]==1) {
                   start = j;
                   cnt = 0;
                   continue;
               }
               else if(start!=-1 && m[i][j]==1) {
                   start = j;
                   t += cnt;
                   cnt = 0;
                   continue;
               }
               cnt++;
           }
       }

       System.out.println(t);

    }


}
