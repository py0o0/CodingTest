        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                int[] parent = new int[1000001];
                while(true){
                    st = new StringTokenizer(br.readLine());
                    int n = Integer.parseInt(st.nextToken());
                    int find = Integer.parseInt(st.nextToken());

                    if(n == 0 && find == 0)break;

                    int prev_n = 0;
                    int cur = -1;
                    Arrays.fill(parent, 0);
                    int[] node = new int[n];

                    st = new StringTokenizer(br.readLine());
                    for(int i = 0; i < n; i++){
                        int x = Integer.parseInt(st.nextToken());
                        node[i] = x;

                        if(i == 0){
                            prev_n = x;
                            parent[x] = -1;
                            continue;
                        }

                        if(prev_n + 1 !=x) cur++;

                        parent[x] = node[cur];
                        prev_n = x;

                    }

                    if(find == node[0]){
                        System.out.println("0"); continue;
                    }
                    int an = 0;
                    for(int x : node){
                        if(x == node[0]) continue;
                        if(parent[x] != parent[find] && parent[parent[x]] == parent[parent[find]]) an++;
                    }
                    System.out.println(an);
                }
            }





        }


