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
        int m = Integer.parseInt(st.nextToken());

        String[] str = new String[2];
        str[0] = "WBWBWBWB";
        str[1] = "BWBWBWBW";

        char[][] mask = new char[8][8];
        int cur = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                mask[i][j] = str[cur].charAt(j);
            }
            cur = (cur + 1) % 2;
        }

        char[][] board = new char[n][m];

        for(int i = 0; i<n;i++){
            String s = br.readLine();
            for(int j = 0; j<m; j++)
                board[i][j] = s.charAt(j);
        }

        int min = Integer.MAX_VALUE;


        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                int cnt = 0;
                for(int k = 0; k<8; k++){
                    for(int l = 0; l<8; l++){
                        if(board[k + i][l + j] != mask[k][l])
                            cnt++;
                    }
                }
                cnt = Math.min(cnt, 64 - cnt);
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);


    }


}
