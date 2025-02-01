import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(a);

            int m = Integer.parseInt(br.readLine());
            StringBuilder stb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {

                int key = Integer.parseInt(st.nextToken());

                int start = 0;
                int end = a.length;
                while(start < end){
                    int mid = (start + end) / 2;

                    if(key <= a[mid])
                        end = mid;

                    else
                        start = mid + 1;
                }
                int low = start;

                start = 0;
                end = a.length;
                while(start < end){
                    int mid = (start + end) / 2;

                    if(key < a[mid])
                        end = mid;

                    else
                        start = mid + 1;
                }
                int up = start;
                stb.append((up - low) + " " );
            }
            System.out.println(stb.toString());




        }

    }
