import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String input = sc.nextLine();
            int k = sc.nextInt();
            sc.nextLine();

            ArrayList<Integer>[] arr = new ArrayList[26];

            for(int i=0;i<26;i++)
                arr[i] = new ArrayList<>();

            for(int i=0;i<input.length();i++)
                arr[input.charAt(i)-'a'].add(i);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i=0;i<26;i++){
                if(arr[i].size() >= k){
                    for(int j=k-1;j<arr[i].size();j++){
                        min = Math.min(min, arr[i].get(j) - arr[i].get(j-k+1) + 1);
                        max = Math.max(max, arr[i].get(j) - arr[i].get(j-k+1) + 1);
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                System.out.println(-1);
                continue;
            }

            System.out.println(min);
            System.out.println(max);

        }
    }

}
