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
                    int m = Integer.parseInt(st.nextToken());

                    xy[] v = new xy[n + 1];
                    for(int i = 0; i <= n; i++) v[i] = new xy();

                    while(m-- > 0){
                        st = new StringTokenizer(br.readLine());
                        int s = Integer.parseInt(st.nextToken());
                        int e = Integer.parseInt(st.nextToken());
                        v[e].indegree++;
                        v[s].children.add(e);
                    }

                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    for(int i = 1; i <= n; i++){
                        if(v[i].indegree == 0) pq.add(i);
                    }
                    while(pq.size() > 0){
                        int x = pq.poll();
                        System.out.print(x + " ");
                        for(int next : v[x].children){
                            v[next].indegree--;
                            if(v[next].indegree == 0) pq.add(next);
                        }
                    }



                }

                static class xy{
                    int indegree;
                    ArrayList<Integer> children;
                    xy(){
                        indegree = 0;
                        children = new ArrayList<>();
                    }
                }







            }


