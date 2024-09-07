import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int []v = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = sc.nextInt();

        int sum = 0;
        int start = 0;
        int an = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum += v[i];
            if(sum == s)
                an = Math.min(i - start + 1, an);
            else if(sum > s){
                while(start<=i){
                    an = Math.min(i - start + 1, an);
                    sum -= v[start++];
                    if(sum == s){
                        an = Math.min(i - start + 1, an);
                    }
                    else if(sum < s)
                        break;
                }
            }
        }
        if(an == Integer.MAX_VALUE)
            System.out.println(0);
        else
        System.out.println(an);

    }


}