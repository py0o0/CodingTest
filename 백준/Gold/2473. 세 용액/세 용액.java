        import javax.lang.model.type.ArrayType;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                int n = Integer.parseInt(br.readLine());
                long[] v = new long[n];

                st = new StringTokenizer(br.readLine());
                for(int i = 0 ; i < n ; i++)
                    v[i] = Integer.parseInt(st.nextToken());

                Arrays.sort(v);

                int[] an = new int[3];

                long dis = x(v[0] + v[1] + v[2]);
                an[0] = (int)v[0]; an[1] = (int)v[1]; an[2] = (int)v[2];

                for(int i = 1; i < n - 1; i++){
                    int start = 0;
                    int end = n-1;
                    while(start < end){
                        if(start == i){
                            start++; continue;
                        }
                        if(end == i){
                            end--; continue;
                        }
                        long val = x(v[i] + v[start] + v[end]);
                        if(dis > val){
                            dis = val;
                            an[0] = (int)v[start];
                            an[1] = (int)v[i];
                            an[2] = (int)v[end];
                        }
                        if(v[i] + v[start] + v[end] < 0)
                            start++;
                        else end--;
                    }
                }
                Arrays.sort(an);
                for(int i = 0 ; i < 3 ; i++)
                    System.out.print(an[i] + " ");



            }
            static long x(long val){
                return val < 0 ? -val : val;
            }




        }


