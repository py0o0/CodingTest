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

                for(int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

                for(int i = 0; i<m;i++){
                    st = new StringTokenizer(br.readLine());
                    int k = Integer.parseInt(st.nextToken());

                    int prev = Integer.parseInt(st.nextToken());
                    for(int j = 1;j<k;j++){
                        int x = Integer.parseInt(st.nextToken());
                        graph[prev].add(x);
                        indegree[x]++;
                        prev = x;
                    }
                }

                Queue<Integer> q = new LinkedList<>();
                for(int i = 1; i<=n;i++) if(indegree[i] == 0) q.add(i);

                ArrayList<Integer> ans = new ArrayList<>();
                while(!q.isEmpty()){
                    int x = q.poll();
                    ans.add(x);

                    for(int next : graph[x]){
                        indegree[next]--;
                        if(indegree[next] == 0) q.add(next);
                    }


                }
                if(ans.size() == n ) {
                    for (int a : ans)
                        System.out.println(a);
                }
                else System.out.println(0);


            }



        }


