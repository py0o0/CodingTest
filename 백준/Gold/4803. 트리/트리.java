            import javax.lang.model.type.ArrayType;
            import java.io.BufferedReader;
            import java.io.IOException;
            import java.io.InputStreamReader;
            import java.util.*;

            public class Main {

                static int cnt;
                static ArrayList<Integer>[] tree;
                static int[] visit;
                static int flag;
                public static void main(String[] args) throws IOException {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    StringTokenizer st;

                    int t = 1;
                    while(true){
                        st = new StringTokenizer(br.readLine());
                        int n = Integer.parseInt(st.nextToken());
                        int m = Integer.parseInt(st.nextToken());
                        if(n == 0 && m == 0) break;

                        tree = new ArrayList[n + 1];
                        visit = new int[n + 1];
                        for(int i = 0 ; i <= n; i++) tree[i] = new ArrayList<>();

                        for(int i = 0; i < m; i++){
                            st = new StringTokenizer(br.readLine());
                            int s = Integer.parseInt(st.nextToken());
                            int e = Integer.parseInt(st.nextToken());
                            tree[s].add(e);
                            tree[e].add(s);
                        }

                        cnt = 0;
                        for(int i = 1; i <= n; i++){
                            flag = 0;

                            if(visit[i] == 1) continue;
                            dfs(i,0);
                            if(flag == 0) cnt++;

                        }
                        System.out.print("Case " + t);
                        if(cnt > 1) System.out.println(": A forest of "+ cnt +" trees.");
                        else if (cnt == 1) System.out.println(": There is one tree.");
                        else System.out.println(": No trees.");

                        t++;
                    }

                }
                static void dfs(int node, int par){
                    visit[node] = 1;

                    for(int next : tree[node]){

                        if(next == par) continue;

                        if(visit[next] == 1){
                            flag = 1;
                            return;
                        }
                        dfs(next, node);
                    }
                }



            }


