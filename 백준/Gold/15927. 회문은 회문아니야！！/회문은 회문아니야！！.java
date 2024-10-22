        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static HashMap<Character, Integer> m = new HashMap<>();
            static int flag = 0;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                String s = br.readLine();


                int start = 0;
                int end = s.length() - 1;
                check(s,start,end);

                if(flag == 0) System.out.println(s.length());
                else{
                    if(m.size() > 1) System.out.println(s.length() - 1);
                    else System.out.println(-1);
                }

            }

            static void check(String s, int start, int end) {
                m.put(s.charAt(start), 1);
                m.put(s.charAt(end), 1);
                if(start >= end){
                    flag = 1;
                    return;
                }

                if(s.charAt(start) == s.charAt(end))
                    check(s,start + 1, end - 1);
            }


        }


