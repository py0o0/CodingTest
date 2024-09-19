import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n;
        n = Integer.parseInt(st.nextToken());

        int[][] v = new int[n][3];
        int[][] an = new int[n][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v[i][0] = Integer.parseInt(st.nextToken());
            v[i][1] = Integer.parseInt(st.nextToken());
            v[i][2] = Integer.parseInt(st.nextToken());

        }

        for(int i = 0; i < 3; i++)
            an[0][i] = v[0][i];

        for(int i=1;i<n;i++) {

            for(int j = 0; j<3;j++) {
                int[] x = new int[2];
                int cur = 0;
                for(int k = 0; k<3; k++) {
                    if(j == k)
                        continue;
                    x[cur++] = an[i - 1][k];
                }
                an[i][j] = Math.min(x[0], x[1]) + v[i][j];

            }

        }
        System.out.println(Math.min(an[n - 1][0], Math.min( an[n - 1][1], an[n - 1][2]) ));

    }

}
