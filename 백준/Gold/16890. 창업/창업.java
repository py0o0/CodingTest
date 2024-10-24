        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                String a = br.readLine();
                String b = br.readLine();

                char[] s1 = a.toCharArray();
                char[] s2 = b.toCharArray();

                int size = s1.length;

                Arrays.sort(s1);
                Arrays.sort(s2);



                int s1_s = 0;
                int s1_e = size / 2 + size % 2 - 1;
                int s2_s = s1_e + 1;
                int s2_e = size - 1;

                int cur_start = 0;
                int cur_end = size - 1;

                int cnt = 0;
                int flag = 0;

                char[] an = new char[size];
                while(cnt < size){
                    if(flag == 0){
                        if(s1[s1_s] < s2[s2_e]){
                            an[cur_start++] = s1[s1_s++];
                        }
                        else
                            an[cur_end--] = s1[s1_e--];

                    }
                    else{
                        if(s1[s1_s] < s2[s2_e]){
                            an[cur_start++] = s2[s2_e--];
                        }
                        else
                            an[cur_end--] = s2[s2_s++];
                    }
                    flag = (flag + 1) % 2;
                    cnt++;
                }
                for(char x : an)
                    System.out.print(x);


            }




        }


