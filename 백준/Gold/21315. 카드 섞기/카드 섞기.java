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
                    for(int i = 0; i < n; i++)
                        v[i] = Integer.parseInt(st.nextToken());

                    for(int k = 0; k < n; k++){

                        Stack<Integer> deck = new Stack<>();
                        for(int i = 1; i <= n; i++)
                            deck.add(i);

                        int[] temp = sort(deck, k, n);

                        deck.clear();
                        for(int i = 0; i < n; i++)
                            deck.add(temp[i]);


                        for(int k2 = 0; k2 < n; k2++){
                            if(Math.pow(2, k2) >= n) break;

                            Stack<Integer> temp2 = new Stack<>();
                            for(int i = 0; i < n; i++)
                                temp2.add(temp[i]);

                            int[] x = sort(temp2,k2,n);

                            if(Arrays.equals(x, v)){
                                System.out.println(k + " " + k2);
                                return;
                            }
                        }

                    }

                }

                public static int[] sort(Stack<Integer> deck, int k, int n){
                    Stack<Integer> temp = new Stack();
                    int[] v = new int[n];
                    int cur = n - 1;
                    for(int i = 1; i <= k+1; i++){
                        int x= (int)Math.pow(2, k - i + 1);

                        for(int j = 0; j < x; j++)
                            temp.add(deck.pop());

                        while(deck.size() > 0)
                            v[cur--] = deck.pop();


                        while(temp.size() > 0)
                            deck.push(temp.pop());

                    }
                    while(deck.size() > 0){
                        v[cur--] = deck.pop();
                    }
                    return v;
                }





            }


