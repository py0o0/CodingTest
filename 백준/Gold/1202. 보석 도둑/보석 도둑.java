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
            int k = Integer.parseInt(st.nextToken());;

            Item[] items = new Item[n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                items[i] = new Item();
                items[i].w = Integer.parseInt(st.nextToken());
                items[i].val = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(items,(a, b) -> {
                return a.w != b.w ? a.w - b.w : a.val - b.val;
            });

            PriorityQueue<Integer> back = new PriorityQueue<>();

            for(int i = 0; i < k; i++){
                int w = Integer.parseInt(br.readLine());
                back.add(w);
            }

            PriorityQueue<Integer> Max = new PriorityQueue<>((a, b) -> b - a);
            int w = back.poll();
            long an = 0;
            for(int i = 0; i < n; i++){
                if(w < items[i].w) {
                    if(!Max.isEmpty())
                        an += Max.poll();
                    while (!back.isEmpty()) {
                        w = back.poll();
                        if(w >= items[i].w)
                            break;
                        if(!Max.isEmpty())
                            an += Max.poll();
                    }
                    if(w < items[i].w)
                        break;
                }
                Max.add(items[i].val);

            }
            if(w >= items[n-1].w){
                if(!Max.isEmpty())
                    an += Max.poll();
                while(!back.isEmpty()){
                    w = back.poll();
                    if(!Max.isEmpty())
                        an += Max.poll();
                }
            }


            System.out.println(an);


        }
        static class Item{
            int w;
            int val;

        }


    }
