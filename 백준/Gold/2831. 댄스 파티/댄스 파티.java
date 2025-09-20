import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] man = new int[n];
        int[] woman = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) man[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) woman[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(man);
        Arrays.sort(woman);

        int an = 0;
        int index = n - 1;

        for(int i = 0; i < n; i++) {
            if (woman[i] > 0) break;

            while (index >= 0 && man[index] > 0 && Math.abs(woman[i]) <= Math.abs(man[index])) index--;
            if (index < 0) break;
            if (man[index] < 0) break;
            an++;
            index--;
        }

        index = n - 1;
        for(int i = 0; i < n; i++){
            if(man[i] > 0) break;

            while(index >= 0 && woman[index] > 0 && Math.abs(man[i]) <= Math.abs(woman[index])) index--;
            if (index < 0) break;
            if(woman[index] < 0) break;
            an++;
            index--;
        }
        System.out.println(an);

    }
}