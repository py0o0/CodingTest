        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static Node[] tree;
            static int[] cnt;
            static int[] visit;

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int root = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                tree = new Node[n + 1];
                visit = new int[n + 1];
                cnt = new int[n + 1];

                for(int i = 0; i <= n; i++)
                    tree[i] = new Node();

                for(int i = 0; i < n - 1; i++){
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    tree[x].children.add(y);
                    tree[y].children.add(x);
                }


                dfs(root);
                while (m-- > 0) {
                    int node = Integer.parseInt(br.readLine());
                    System.out.println(cnt[node]);
                }


            }
            static int dfs(int node){
                if(visit[node] == 1) return 0;
                visit[node] = 1;
                cnt[node] = 1;
                for(Integer son : tree[node].children){
                    cnt[node] += dfs(son);
                }
                return cnt[node];
            }


            static class Node{
                ArrayList<Integer> children;
                Node(){
                    children = new ArrayList<>();
                }
            }


        }


