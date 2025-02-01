import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[] v = new int[n];
            st= new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                v[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(v);

            int m  = Integer.parseInt(br.readLine());
            st= new StringTokenizer(br.readLine());
            StringBuilder stb =  new StringBuilder();
            for(int i = 0; i < m; i++){
                int x = Integer.parseInt(st.nextToken());

                int start = 0;
                int end = v.length - 1;

                while(start < end){
                    int mid = (start + end)/2;

                    if(x <= v[mid])
                        end = mid;
                    else
                        start = mid + 1;
                }
                if(v[start] == x) stb.append(1 +"\n");
                else stb.append(0+"\n");
            }
            System.out.println(stb.toString());

        }

    }
