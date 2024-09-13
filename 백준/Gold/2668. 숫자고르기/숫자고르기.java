import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++)
            v[i] = Integer.parseInt(br.readLine());

        int []visit = new int[n + 1];
        int max = 0;
        ArrayList<Integer> an = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if (visit[i] == 1) continue;

            int a = i;

            ArrayList<Integer> al = new ArrayList<>();

            while (visit[a] == 0) {
                al.add(a);
                visit[a] = 1;
                a = v[a];
            }

            int index = 0;
            while(index < al.size() && al.get(index) != a) index++;
            if(al.size() - index > 0){
                max += al.size() - index;
                for(int j = index; j< al.size(); j++)
                    an.add(al.get(j));
            }

        }
        Collections.sort(an);
        
        System.out.println(max);

        for(int i = 0; i < an.size(); i++)
            System.out.println(an.get(i));

    }


}
