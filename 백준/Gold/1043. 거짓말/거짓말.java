import java.util.*;
import java.io.*;

public class Main {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for(int i = 1; i <= n; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        int[] noPeople = new int[x];
        for(int i = 0; i < x; i++){
            noPeople[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> parties = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());

            int[] people = new int[x];
            for(int j = 0; j < x; j++){
                people[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(people);

            for(int j = 1; j < x; j++){
                union(parties.get(i)[0], parties.get(i)[j]);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int p : noPeople) set.add(find(p));

        int an = 0;
        for(int i = 0; i < m; i++){
            int flag = 0;
            for(int party : parties.get(i)){
                if(set.contains(find(party))){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) an++;
        }
        System.out.println(an);
    }

    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y) parents[x] = y;
    }
}
