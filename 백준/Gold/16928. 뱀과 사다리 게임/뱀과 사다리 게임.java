import java.util.*;
import java.io.*;

    class Main {

        static int[]move;
        static int[]visit;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n,k;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            move = new int[101];
            visit = new int[101];
            for (int i = 0; i < n + k; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                move[s] = e;
            }

            Queue<xy> q = new LinkedList<>();
            for(int i = 1; i<7;i++)
                q.add(new xy(1,1,i));
            visit[1] = 1;

            while(!q.isEmpty()) {
                xy x = q.poll();
                int next = x.cur + x.move;

                if(next == 100){
                    System.out.println(x.cnt);
                    return;
                }

                if(next > 100) continue;
                if(move[next] != 0)
                    next = move[next];
                if(visit[next] == 1) continue;

                visit[next] = 1;
                for(int i = 1; i<7;i++)
                    q.add(new xy(next,x.cnt + 1,i));
            }


        }
        static class xy{
            int cur;
            int cnt;
            int move;
            xy(int cur,int cnt,int move){
                this.cur = cur;
                this.cnt = cnt;
                this.move = move;
            }
        }




    }
