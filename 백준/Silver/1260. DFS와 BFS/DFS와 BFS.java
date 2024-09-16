import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] visit;
    static ArrayList<Integer>[] g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visit = new int[n + 1];
        g = new ArrayList[n + 1];

        for(int i= 0; i<= n; i++)
            g[i] = new ArrayList<>();

        for(int i= 0; i<m;i++){
           st = new StringTokenizer(br.readLine());
           int s = Integer.parseInt(st.nextToken());
           int e = Integer.parseInt(st.nextToken());

           g[s].add(e);
           g[e].add(s);
        }

        for(int i=0; i<n+1; i++)
            Collections.sort(g[i]);

        ArrayList<Integer> an = new ArrayList();

        DFS(start, an);

        for(int i = 0; i < an.size(); i++)
            System.out.print(an.get(i) + " ");
        System.out.println();

        for(int i= 0; i<= n; i++)
            visit[i] = 0;
        an.clear();

        BFS(start, an);
    }

    static public void DFS(int start, ArrayList<Integer> an){
        visit[start] = 1;
        an.add(start);

        for(int i=0; i<g[start].size(); i++){
            if(visit[ g[start].get(i) ] == 0)
                DFS(g[start].get(i), an);
        }


    }

    static public void BFS(int start, ArrayList<Integer> an){
        visit[start] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int s = q.poll();
            an.add(s);
            for(int i=0; i<g[s].size(); i++){
                if(visit[g[s].get(i)] == 0) {
                    q.add(g[s].get(i));
                    visit[g[s].get(i)] = 1;
                }
            }
        }

        for(int i=0; i<an.size(); i++)
            System.out.print(an.get(i) + " ");


    }


}
