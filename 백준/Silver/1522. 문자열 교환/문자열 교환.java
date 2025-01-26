import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            String s = br.readLine();
            int a = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'a') a++;
            }
            int Min = Integer.MAX_VALUE;
            for(int i = 0; i<s.length(); i++) {
                int cnt = a;
                int change = 0;
                for(int j = i; j<i+s.length();j++){
                    if(cnt == 0) break;
                    cnt--;
                    if(s.charAt(j % s.length()) == 'b') change++;
                }
                Min = Math.min(Min, change);
            }
            System.out.println(Min);
        }



    }
