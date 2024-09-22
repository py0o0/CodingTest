import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t=Integer.parseInt(br.readLine());
        char[] c = {'D','S','L','R'};
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int[] visit = new int[10000];

            Queue<xy> q = new LinkedList<>();
            q.add(new xy(x,""));
            int flag = 0;
            while(!q.isEmpty()){
                xy temp = q.poll();
                for(int i = 0; i< 4; i++){
                    int nx = temp.x;
                    if(i == 0)
                        nx = D(nx);
                    else if(i == 1)
                        nx = S(nx);
                    else if(i == 2)
                        nx = L(nx);
                    else
                        nx = R(nx);

                    if(visit[nx] == 1) continue;
                    visit[nx] = 1;

                    if(nx == target){
                        String an = temp.s + c[i];
                        System.out.println(an);
                        flag = 1;
                        break;
                    }
                    q.add(new xy(nx,temp.s + c[i]));
                }
                if(flag == 1) break;
            }

        }

    }
    public static int D(int nx){
        nx = (2 * nx) % 10000;
        return nx;
    }
    public static int S(int nx){
        nx-=1;
        if(nx == -1)
            nx = 9999;
        return nx;
    }
    public static int L(int nx){
        int d1 = nx/1000;
        nx %= 1000;
        nx *= 10;
        nx += d1;
        return nx;
    }
    public static int R(int nx){
        int d4 = nx%10;
        nx /= 10;
        nx += d4 * 1000;
        return nx;
    }
    static public class xy{
        int x;
        String s;
        public xy(int x,String s){
            this.x=x;
            this.s=s;
        }
    }


}
