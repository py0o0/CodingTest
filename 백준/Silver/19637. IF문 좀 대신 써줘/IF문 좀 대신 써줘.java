import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static xy[] standards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        standards = new xy[n];

        for(int i = 0; i<n; i++){
            standards[i] = new xy();
            st = new StringTokenizer(br.readLine());
            standards[i].s = st.nextToken();
            standards[i].x = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i<m; i++){
            int power = Integer.parseInt(br.readLine());

            int cur = seekmid(power, n);

            System.out.println(standards[cur].s);


        }


    }
    public static int seekmid(int power, int n){
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = (start + end)/2;
            if(power <= standards[mid].x)
                end = mid - 1;
            else if(power > standards[mid].x)
                start = mid + 1;

        }
        return start;
    }

    public static class xy{
        String s;
        int x;
    }


}
