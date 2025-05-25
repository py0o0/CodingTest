import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] man = new int[n];
        int[] woman = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            man[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            woman[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(man);
        Arrays.sort(woman);

        int index = n - 1;
        int an = 0;
        int i = 0;
        for(; i < n; i++){
            if(man[i] > 0) break;

            while(index >= 0 && woman[index] > 0 && Math.abs(man[i]) <= Math.abs(woman[index])){
                index--;
            }
            if(index < 0) break;
            if(woman[index] > 0){
                an++; index--;
            }
        }

        i = n-1;
        for(index = 0; index < n; index++){
            if(woman[index] > 0) break;

            while(i >= 0 && man[i] > 0 && Math.abs(man[i]) >= Math.abs(woman[index])){
                i--;
            }
            if(i < 0)break;
            if(man[i] > 0){
                an++; i--;
            }
        }
        System.out.println(an);


    }




}