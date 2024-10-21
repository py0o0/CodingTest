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
                xy[] v = new xy[n];

                for(int i = 0; i < n; i++){
                    xy x = new xy();
                    st = new StringTokenizer(br.readLine());

                    x.dead = Integer.parseInt(st.nextToken());
                    x.cup = Integer.parseInt(st.nextToken());
                    v[i] = x;
                }

                Arrays.sort(v, (a, b) -> {
                    if (a.dead == b.dead)
                        return b.cup - a.cup;
                    else
                        return a.dead - b.dead;});

                int an = 0;
                PriorityQueue<Integer> pq = new PriorityQueue<>();

                for(xy x : v){
                    pq.add(x.cup);
                    if(x.dead < pq.size()) pq.poll();
                }
                while(!pq.isEmpty()) an += pq.poll();



                System.out.println(an);

            }
            static class xy{
                int dead;
                int cup;
            }



        }
