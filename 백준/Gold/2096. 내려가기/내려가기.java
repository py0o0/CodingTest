    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[3];
            int[] dp_max = new int[3];
            int[] dp_min = new int[3];
            int[] temp = new int[3];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                arr[0] = Integer.parseInt(st.nextToken());
                arr[1] = Integer.parseInt(st.nextToken());
                arr[2] = Integer.parseInt(st.nextToken());

                temp[0] = Math.max(dp_max[0], dp_max[1]) + arr[0];
                temp[2] = Math.max(dp_max[1], dp_max[2]) + arr[2];
                temp[1] = Math.max(dp_max[0],Math.max(dp_max[1],dp_max[2])) + arr[1];

                dp_max[0] = temp[0];
                dp_max[1] = temp[1];
                dp_max[2] = temp[2];

                temp[0] = Math.min(dp_min[0], dp_min[1]) + arr[0];
                temp[2] = Math.min(dp_min[1],dp_min[2]) + arr[2];
                temp[1] = Math.min(dp_min[0],Math.min(dp_min[1],dp_min[2])) + arr[1];

                dp_min[0] = temp[0];
                dp_min[1] = temp[1];
                dp_min[2] = temp[2];

            }
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                max = Math.max(max, dp_max[i]);
                min = Math.min(min, dp_min[i]);
            }
            System.out.println(max + " " + min);


        }

    }
