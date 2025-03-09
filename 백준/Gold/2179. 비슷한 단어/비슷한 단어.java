import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String[] arr = new String[n];

        for(int i = 0; i < n; i++)
            arr[i] = br.readLine();

        int x = 0;
        int y = 0;
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int size = Math.min(arr[i].length(), arr[j].length());
                int cnt = 0;

                for(int k = 0; k < size; k++){
                    if(arr[i].charAt(k) != arr[j].charAt(k)) break;
                    cnt++;
                }
                if(cnt > max){
                    max = cnt;
                    x = i; y = j;
                }
            }
        }
        System.out.println(arr[x]);
        System.out.println(arr[y]);
    }

}