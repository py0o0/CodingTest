import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

       st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());

       int[][] stair = new int[n][3];

       for(int i = 0; i < n; i++){
           st = new StringTokenizer(br.readLine());
           stair[i][0] = Integer.parseInt(st.nextToken());
       }
       if(n==1){
           System.out.println(stair[0][0]);
           return;
       }
       
       stair[0][1] = stair[0][0];

       stair[1][1] = stair[1][0];
       stair[1][2] = stair[0][1] + stair[1][0];
       for(int i = 2; i < n; i++){
           stair[i][1] = Math.max(stair[i-2][1] ,stair[i-2][2]) + stair[i][0];
           stair[i][2] = stair[i-1][1] + stair[i][0];
       }

       System.out.println(Math.max(stair[n-1][1], stair[n-1][2]));

    }


}
