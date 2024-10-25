            import javax.lang.model.type.ArrayType;
            import java.io.BufferedReader;
            import java.io.IOException;
            import java.io.InputStreamReader;
            import java.util.*;

            public class Main {

                public static void main(String[] args) throws IOException {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    StringTokenizer st;

                    st = new StringTokenizer(br.readLine());
                    int n = Integer.parseInt(st.nextToken());
                    long target = Integer.parseInt(st.nextToken());

                    long[] v = new long[n];
                    for(int i = 0; i < n; i++)
                        v[i] = Integer.parseInt(br.readLine());

                    Arrays.sort(v);

                    long start = v[0];
                    long end = v[n-1] * target;

                    long an = Long.MAX_VALUE;
                    while(start <= end){
                        long mid = (start + end) / 2;

                        long pass = 0;
                        for(int i = 0; i < n; i++){
                            pass += mid / v[i];
                            if(pass > target) break;
                        }
                        if(pass >= target){
                            an = Math.min(an, mid);
                            end = mid - 1;
                        }
                        else{
                            start = mid + 1;
                        }


                    }
                    System.out.println(an);
                }



            }


