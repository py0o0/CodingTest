import java.util.*;
import java.io.*;

    class Main {

        static int[][][] map = new int[21][21][21]; 
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            while (true) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (a == -1 && b == -1 && c == -1) 
                    break;
                
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + re(a, b, c));

            }
        }
        static int re(int a, int b, int c){
            if(a<=0 || b<=0 || c<=0){
                return 1;
            }

            if(a>20 || b>20 || c>20){
                return re(20, 20, 20);
            }

            if(map[a][b][c]!=0){
                return map[a][b][c];
            }
            if(a<b && b<c){
                map[a][b][c] = re(a, b, c-1) + re(a, b-1, c-1) - re(a, b-1, c);
            }
            else
                map[a][b][c] = re(a-1,b,c)+re(a-1,b-1,c)+re(a-1, b, c-1)-re(a-1,b-1,c-1);

            return map[a][b][c];
        }
    }
