import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            long[][] v = new long[n + 1][11];

            for(int i = 1; i< 10; i++)
                v[1][i] = 1;
            v[1][10] = 9;

            for(int i = 2; i<=n; i++){
                long sum = 0;
                v[i][0] = v[i-1][1]; //0으로 끝나는 경우 = 이전 숫자가 1로 끝났을 때
                sum = (sum + v[i][0]) % 1000000000;


                v[i][9] = v[i-1][8]; //9로 끝나는 경우 = 이전 숫자가 8로 끝났을 때
                sum = (sum +v[i][9]) % 1000000000;

                for(int j = 1; j<9;j++){
                    v[i][j] = (v[i-1][j+1] + v[i-1][j-1])  % 1000000000; //이전숫자가 지금의 숫자보다 1 크거나 1작은 경우
                    sum = (sum + v[i][j]) % 1000000000;

                }
                v[i][10] = sum;
            }
            System.out.println(v[n][10]);
        }
    }
