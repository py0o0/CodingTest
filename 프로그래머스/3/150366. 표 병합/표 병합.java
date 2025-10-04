import java.io.*;
import java.util.*;
class Solution {
    static int[] v;
    static String[] an;
    public String[] solution(String[] commands) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();
        
        v = new int[2501];
        an = new String[2501];
        for(int i = 0; i < 2501; i++) {
            v[i] = i;
            an[i] = "";
        }
        
        for(String com : commands){
            StringTokenizer st = new StringTokenizer(com);
            String s1 = st.nextToken();
            if(s1.equals("UPDATE")){
                String s2 = st.nextToken();
                String s3 = st.nextToken();
                
                if(st.hasMoreTokens()){
                    int x = Integer.parseInt(s2);
                    int y = Integer.parseInt(s3);
                    
                    String val = st.nextToken();
                    int parents = find((x - 1) * 50 + (y - 1));
                    an[ parents ] = val;
                    continue;
                }
                for(int i = 0; i < 2501; i++){
                    if(an[ find(i) ].equals(s2)) an[ find(i) ] = s3;
                }
                
            }else if(s1.equals("MERGE")){
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                
                int a = (x1 - 1) * 50 + (y1 - 1);
                int b = (x2 - 1) * 50 + (y2 - 1);
                int parA = find(a);
                int parB = find(b);
                if(parA == parB) continue;
                
                String val = an[parA];
                if(an[parA].equals("")) val = an[parB];
                union(parA, parB);
                an[parA] = val;
                
            }else if(s1.equals("UNMERGE")){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                int par = find((x - 1) * 50 + (y - 1));
                String val = an[ par ];
                
                for(int i = 0; i < 2501; i++) find(i); // 부모 업데이트
                
                for(int i = 0; i < 2501; i++){
                    if(find(i) == par){
                        an[i] = "";
                        v[i] = i;
                    }
                }
                
                an[(x - 1) * 50 + (y - 1)] = val;
            }else{
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int par = find((x-1) * 50 + (y - 1));
                if(an[par].equals("")) answerList.add("EMPTY");
                else answerList.add(an[par]);
            }
        }
       
        answer = new String[answerList.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);
        return answer;
    }
    
    
    static int find(int x){
        if(v[x] == x) return x;
        return v[x] = find(v[x]);
    }
    static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        v[b] = a;
    }
}