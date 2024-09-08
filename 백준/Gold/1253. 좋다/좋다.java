import java.util.*;

public class Main {


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int n = sc.nextInt();
        long [] v = new long[n];
        for(int i = 0; i < n; i++)
            v[i] = sc.nextLong();
        Arrays.sort(v);
        int cnt = 0;

        for(int i = 0; i < n; i++){
            int start = 0;
            int end = n-1;

            if(i == start)
                start++;
            if(i == end)
                end--;

            while(start < end){
                long sum = v[start] + v[end];
                if(sum == v[i]){
                    cnt++;
                    break;
                }
                if(sum < v[i]) {
                    start++;
                    if(start == i)
                        start++;
                }
                else if(sum > v[i]) {
                    end--;
                    if(end == i)
                        end--;
                }
            }
        }
        System.out.println(cnt);

    }


}
