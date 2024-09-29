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

            int[][] map = new int[n + 1][500];
            int[] disconnect = new int[n + 1];
            for (int i = 0; i <= n; i++)
                Arrays.fill(map[i], Integer.MAX_VALUE);

            for(int i = 0; i<m; i++) {
                int x = Integer.parseInt(br.readLine());
                disconnect[x] = -1;
            }

            int[] dj = {1,0,-1};
            PriorityQueue<xy> pq = new PriorityQueue<>((a,b) -> b.x - a.x);
            pq.add(new xy(1,0,0));
            while(!pq.isEmpty()) {
                xy x = pq.poll();

                for(int i = 0; i<3; i++){
                    int nj = (x.prev + dj[i]);
                    int nx = x.x + nj;
                    if(nj < 1 ||nx <1 || nx > n) continue;
                    if(disconnect[nx] == -1) continue;

                    if(map[nx][nj] <= x.cnt + 1) continue;

                    map[nx][nj] = x.cnt + 1;
                    if (nx == n) continue;

                    pq.add(new xy(nx,x.cnt + 1,nj));

                }

            }
            int an = Integer.MAX_VALUE;
            for(int i =0; i< 500;i++)
                an = Math.min(an,map[n][i]);
            if(an == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(an);

        }
        static class xy{
            int x;
            int cnt;
            int prev;
            xy(int x,int cnt, int prev) {
                this.x = x;
                this.cnt = cnt;
                this.prev = prev;
            }
        }





    }
