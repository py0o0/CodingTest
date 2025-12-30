import java.util.*;
import java.io.*;

public class Main {

    static int n, max;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        eggs = new Egg[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg();
            eggs[i].s = Integer.parseInt(st.nextToken());
            eggs[i].w = Integer.parseInt(st.nextToken());
        }

        smash(0, 0);
        System.out.println(max);
    }
    static void smash(int cur, int smashEgg){
        if(cur == n){
            max = Math.max(max, smashEgg);
            return;
        }
        if(eggs[cur].s <= 0){
            smash(cur + 1, smashEgg);
            return;
        }
        int temp = smashEgg;

        int flag = 0;
        for(int i = 0; i < n; i++) {
            if(i == cur) continue;
            if (eggs[i].s <= 0) continue;
            flag = 1;
            eggs[cur].s -= eggs[i].w;
            eggs[i].s -= eggs[cur].w;

            if (eggs[cur].s <= 0) smashEgg++;
            if (eggs[i].s <= 0) smashEgg++;

            smash(cur + 1, smashEgg);
            eggs[cur].s += eggs[i].w;
            eggs[i].s += eggs[cur].w;
            smashEgg = temp;
        }
        if(flag == 0){
            max = Math.max(max, smashEgg);
            return;
        }
    }

    static class Egg{
        int s, w;
    }
}
