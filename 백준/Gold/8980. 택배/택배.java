import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int vol = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        xy[] truck = new xy[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            truck[i] = new xy();
            truck[i].s = Integer.parseInt(st.nextToken());
            truck[i].e = Integer.parseInt(st.nextToken());
            truck[i].x = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(truck, (a,b)->{
            if(a.e == b.e){
                if(a.x == b.x) return a.s-b.s;
                return a.x - b.x;
            }
            return a.e - b.e;
        });

        int[] town = new int[n];
        for (int i = 0; i < n; i++)
            town[i] = vol; // 마을에서 보낼 수 있는 최대치

        int an = 0;
        for(xy t : truck){ // 우선순위 별로 정렬햇으니 무조건 실으셈

            int x = t.x;
            for(int i = t.s; i < t.e; i++) // 짐은 원 무게 or 마을에서 보낼 수 있는 용량 만큼
                x = Math.min(x, town[i]);
            
            for(int i = t.s; i < t.e; i++) // 마을에서 보낼 수 있는 용량 업데이트
                town[i] -= x;

            an += x;
        }
        System.out.println(an);

    }
    static class xy{
        int s,e,x;
    }

}