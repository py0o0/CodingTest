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
                int[] visit = new int[200001];
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                Queue<xy> q = new LinkedList<>();
                q.add(new xy(n, 0));

                while(!q.isEmpty()) {
                    xy x = q.poll();

                    if(x.val == k){
                        System.out.println(x.cnt);
                        break;
                    }
                    if(x.val < 0 || x.val > 200000 || visit[x.val] == 1) continue;
                    visit[x.val] = 1;

                    q.add(new xy(x.val * 2, x.cnt + 1));
                    q.add(new xy(x.val - 1, x.cnt + 1));
                    q.add(new xy(x.val + 1, x.cnt + 1));


                }

            }
            static class xy{
                int val;
                int cnt;
                xy(int val, int cnt) {
                    this.val = val;
                    this.cnt = cnt;
                }
            }


        }


