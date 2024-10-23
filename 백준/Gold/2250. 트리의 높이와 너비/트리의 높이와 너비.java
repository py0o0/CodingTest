        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static Node[] tree;
            static ArrayList<xy> node_xy;
            static int cnt;
            static int Mlev;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                int n = Integer.parseInt(br.readLine());

                tree = new Node[n+1];
                node_xy = new ArrayList<>();

                int[] find_root = new int[n+1];

                for(int i = 0;i < n+1;i++) tree[i] = new Node();


                for(int i = 1; i <= n; i++){
                    st = new StringTokenizer(br.readLine());
                    int par = Integer.parseInt(st.nextToken());
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());

                    if(left != -1) {tree[par].left = left; find_root[left]++;}
                    if(right != -1) {tree[par].right = right; find_root[right]++;}
                }

                int root = 0;
                for(int i = 1; i <= n; i++)
                    if(find_root[i] == 0) root = i;

                cnt = 1;
                Mlev = 1;
                dfs(root, 1);

                ArrayList<Integer>[] v = new ArrayList[Mlev + 1];

                for(int i = 0; i <=Mlev; i++) v[i] = new ArrayList<>();

                for(xy x : node_xy){
                    v[x.lev].add(x.x);
                }

                int tall = 1;
                int weight = 1;

                for(int i = 1; i <= Mlev; i++){
                    int Min = v[i].get(0);
                    int Max = v[i].get(0);

                    for(int j = 1; j < v[i].size(); j++){
                        Min = Math.min(v[i].get(j), Min);
                        Max = Math.max(v[i].get(j), Max);
                    }
                    int dis = Max - Min + 1;
                    if(dis > weight){
                        weight = dis;
                        tall = i;
                    }

                }
                System.out.println(tall + " " + weight);



            }
            static void dfs(int par, int level){
                if(par == -1) return;

                dfs(tree[par].left, level + 1);

                node_xy.add(new xy(par, level, cnt));
                cnt++;

                dfs(tree[par].right, level + 1);

                Mlev = Math.max(Mlev,level);


            }

            static class xy{
                int n;
                int lev;
                int x;
                xy(int n, int lev, int x){
                    this.n = n;
                    this.lev = lev;
                    this.x = x;
                }
            }
            static class Node{
                int left;
                int right;
                Node(){
                    left = right = -1;
                }
            }


        }


