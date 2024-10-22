       import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static int flag;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                int n = Integer.parseInt(br.readLine());
                for(int i = 0; i < n; i++){
                    String s = br.readLine();
                    int start = 0;
                    int end = s.length() - 1;

                    flag = 0;
                    search(s,start,end,0);

                    if(flag == 0) System.out.println(2);
                }
            }

            public static void search(String s, int start, int end, int x){
                if(start >= end){
                    if(x == 1) System.out.println(1);
                    else System.out.println(0);
                    flag = 1;
                    return;
                }

                if(s.charAt(start) == s.charAt(end))
                    search(s,start+1,end-1,x);
                else if(x == 0){
                    search(s,start,end-1,1);
                    if(flag == 0)
                        search(s,start+1,end,1);
                }

            }





        }


