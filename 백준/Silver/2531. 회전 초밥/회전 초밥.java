import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int [] m  = new int[3001];
    static int [] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, d, k, c;
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        v = new int[n];
        for(int i = 0; i < n; i++)
            v[i] = sc.nextInt();

        int cur_food = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == c)
                cur_food = 1;
        }

        int Max = 0;
        int size = 0;
        int flag = 0;
        for (int i = 0; i < k; i++) {
            if (m[v[i]] == 0)
                size++;
            if (v[i] == c)
                flag = 1;
            m[v[i]]++;
        }

        if (cur_food == 0 || flag == 0)
            Max = Math.max(Max, size + 1);
        else
            Max = Math.max(Max, size);


        for (int i = 1; i < n; i++) {
            int cur = (i + k - 1) % n;

            m[v[i-1]]--;
            if (m[v[i-1]] == 0)
                size--;
            m[v[cur]]++;
            if (m[v[cur]] == 1)
                size++;

            if (m[c] > 0)
                flag = 1;
            else
                flag = 0;

            if (cur_food == 0 || flag == 0)
                Max = Math.max(Max, size + 1);
            else
                Max = Math.max(Max, size);
        }

        System.out.println(Max);
    }
}
