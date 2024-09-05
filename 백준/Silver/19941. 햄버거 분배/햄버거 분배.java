import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[] m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        String input = sc.nextLine();
        m = new char[n];

        for(int i= 0; i < n; i++)
            m[i] = input.charAt(i);

        int an = 0;
        for(int i = 0; i<n;i++){
            if(m[i]=='P'){
                int start = Math.max(0,i-k);
                int end = Math.min(n-1, i+k);

                for(int j = start; j<=end;j++){
                    if(m[j]== 'H'){
                        m[j]= 'X';
                        an++;
                        break;
                    }
                }
            }
        }

        System.out.println(an);

    }
}
