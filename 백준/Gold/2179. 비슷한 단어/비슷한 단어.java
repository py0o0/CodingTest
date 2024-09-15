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

       String[] str = new String[n];

       for (int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine());
           str[i] = st.nextToken();
       }

       int max = 0;
       String[] an = new String[2];
       for (int i = 0; i < n; i++) {
           for (int j = i + 1; j < n; j++) {
               if(str[i] == str[j])
                   continue;

               int size = Math.min(str[i].length(), str[j].length());
               int cnt = 0;
               for(int k = 0; k < size; k++){
                   if(str[i].charAt(k) != str[j].charAt(k))
                       break;
                   cnt++;
               }
               if(max < cnt){
                   max = cnt;
                   an[0] = str[i];
                   an[1] = str[j];
               }

           }
       }

       System.out.println(an[0]);
       System.out.println(an[1]);
    }



}
