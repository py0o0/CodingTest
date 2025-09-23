import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Ball[] balls = new Ball[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            balls[i] = new Ball();
            balls[i].color = Integer.parseInt(st.nextToken());
            balls[i].val = Integer.parseInt(st.nextToken());
            balls[i].i = i;
        }

        Arrays.sort(balls,(x,y) -> x.val - y.val);

        int[] color = new int[200001];
        xy[] an = new xy[n];
        int sum = 0;

        int i = 0;
        while(i < n){

            int j = i;
            while(j < n && balls[j].val == balls[i].val) j++;

            for(int k = i; k < j; k++){
                an[k] = new xy();
                an[k].score = sum - color[ balls[k].color ];
                an[k].i = balls[k].i;
            }
            for(int k = i; k < j; k++){
                color[ balls[k].color ] += balls[k].val;
                sum += balls[k].val;
            }

            i = j;
        }

        Arrays.sort(an, (x,y) -> x.i - y.i);
        for(i = 0; i < n; i++){
            System.out.println(an[i].score);
        }

    }
    static class Ball{
        int color, val, i;
    }
    static class xy{
        int score, i;
    }

}