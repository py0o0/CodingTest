        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                int[] indegree = new int[n + 1];
                ArrayList<Integer>[] graph = new ArrayList[n + 1];

                for(int i = 0; i <= n; i++)
                    graph[i] = new ArrayList<>();

                for(int i = 0; i < m; i++){
                    st = new StringTokenizer(br.readLine());
                    int s = Integer.parseInt(st.nextToken());
                    int e = Integer.parseInt(st.nextToken());

                    graph[s].add(e);
                    indegree[e]++;
                }

                Queue<Integer> q = new LinkedList<>();

                for(int i = 1; i <= n; i++)
                    if(indegree[i] == 0) q.add(i);

                while(!q.isEmpty()){
                    int x = q.poll();

                    System.out.print(x + " ");
                    for(int next : graph[x]){
                        indegree[next]--;
                        if(indegree[next] == 0) q.add(next);
                    }
                }

            }



        }


