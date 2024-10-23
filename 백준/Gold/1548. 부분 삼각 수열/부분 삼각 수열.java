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

                int[] v = new int[n];
                st = new StringTokenizer(br.readLine());
                for(int i = 0; i < n; i++) {
                    v[i] = Integer.parseInt(st.nextToken());
                }

                if(v.length < 3){
                    System.out.println(v.length);
                    return;
                }
                Arrays.sort(v);

                int size = 2;
                for(int i = 0; i < n - 1; i++){
                    int Min = v[i] + v[i+1];
                    int temp = 2;
                    for(int j = i + 2; j < n; j++){
                        if(Min <= v[j])
                            break;
                        temp++;
                    }
                    size = Math.max(temp, size);
                }
                System.out.println(size);
            }


        }

