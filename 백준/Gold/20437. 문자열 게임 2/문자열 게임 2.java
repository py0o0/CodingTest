import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        while(t-->0){
            String s = br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] map = new ArrayList[26];

            for(int i=0;i<26;i++)
                map[i] = new ArrayList<>();

            for(int i = 0; i < s.length(); i++)
                map[s.charAt(i) - 'a'].add(i);

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 26; i++){
                if(map[i].size() < n) continue;

                for(int j = n - 1; j < map[i].size(); j++){
                    min = Math.min(min, map[i].get(j) - map[i].get(j-n+1) + 1);
                    max = Math.max(max, map[i].get(j) - map[i].get(j-n+1) + 1);
                }

            }

            if(min == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }


}