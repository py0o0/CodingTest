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

        int[] v = new int[1000001];
        int cur = 0;
        for(int i = 2;i <= m; i++){
            if(IsPrime(i))
                v[cur++] = i;
        }

        for(int i = 0; i < cur; i++){
            if(v[i] >= n && v[i] <= m)
                System.out.println(v[i]);
            if(v[i] > m)
                break;
        }

    }
    public static boolean IsPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

}
