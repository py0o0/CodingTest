import java.util.*;
import java.io.*;

    class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            String s = br.readLine();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                left.push(s.charAt(i));
            }

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while(n-- > 0){
                st = new StringTokenizer(br.readLine());
                char x = st.nextToken().charAt(0);
                if(x == 'L'){
                    if(left.isEmpty()) continue;
                    right.push(left.pop());
                }
                else if(x == 'D'){
                    if(right.isEmpty()) continue;
                    left.push(right.pop());
                }
                else if(x == 'B'){
                    if(left.isEmpty()) continue;
                    left.pop();
                }
                else if(x == 'P'){
                    char x2 = st.nextToken().charAt(0);
                    left.push(x2);
                }
            }
            StringBuilder an = new StringBuilder();
            while (!left.isEmpty()) right.push(left.pop());
            while (!right.isEmpty()) an.append(right.pop());

            System.out.print(an);

        }


    }
