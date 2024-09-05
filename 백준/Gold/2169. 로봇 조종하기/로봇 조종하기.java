import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int[][] an;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];
        an = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                map[i][j] = sc.nextInt();
            sc.nextLine();
        }

        an[0][0] = map[0][0];
        for(int i=1;i<m;i++)
            an[0][i] = an[0][i-1] + map[0][i];

        for(int i=1;i<n;i++)
            an[i][0] = an[i-1][0] + map[i][0];

        for(int i=1;i<n;i++){
            int[] right = new int[m];
            int[] left = new int[m];

            right[0] = an[i-1][0] + map[i][0];
            left[m-1] = an[i-1][m-1] + map[i][m-1];

            for(int j=1;j<m;j++)
                right[j] = Math.max(right[j - 1], an[i-1][j]) + map[i][j];

            for(int j = m-2;j>-1;j--)
                left[j] = Math.max(left[j+1], an[i-1][j]) + map[i][j];

            for(int j=0;j<m;j++)
                an[i][j] = Math.max(right[j], left[j]);
        }

        System.out.println(an[n-1][m-1]);
    }

}
