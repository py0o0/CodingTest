        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

        public class Main {

            static Node[] sege;
            static int[] v;
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st;

                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                v = new int[n];
                for(int i = 0; i < n; i++)
                    v[i] = Integer.parseInt(br.readLine());

                sege = new Node[4 * n];
                for(int i = 0; i < 4 * n; i++)
                    sege[i] = new Node();

                init(1, 0, n - 1);
                for(int i = 0; i< m;i++){
                    st = new StringTokenizer(br.readLine());
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());

                    Node node = seek(1,0,n-1,left - 1,right - 1);
                    System.out.println(node.Min + " " + node.Max);
                }

            }
            static Node seek(int node, int start, int end, int left, int right){
                if( left > end || right < start) return null;
                if(left <= start && right >= end) return sege[node];
                int mid = (start + end)/2;
                Node node1 = seek(node*2,start,mid,left,right);
                Node node2 = seek(node*2 + 1,mid+1,end,left,right);

                if(node1 == null) return node2;
                if(node2 == null) return node1;

                Node node3 = new Node();
                node3.Min = Math.min(node1.Min,node2.Min);
                node3.Max = Math.max(node1.Max,node2.Max);
                return node3;


            }
            static Node init(int node, int start, int end){
                if(start == end){

                    sege[node].Min = v[start];
                    sege[node].Max = v[start];
                    return sege[node];
                }
                int mid = (start + end)/2;
                Node node1 = init(node * 2, start, mid);
                Node node2 = init(node * 2 + 1, mid + 1, end);
                sege[node].Min = Math.min(node1.Min, node2.Min);
                sege[node].Max = Math.max(node1.Max, node2.Max);
                return sege[node];
            }

            static class Node{
                int Min;
                int Max;
            }

        }

