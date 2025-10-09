import java.io.*;
import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        Map<String,Integer> map = new HashMap<>();
        map.put(begin, 0);
        
        while(!q.isEmpty()){
            String s = q.poll();
            for(String str : words){
                int cnt = 0;
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) != str.charAt(i)) cnt++;
                }
                if(cnt > 1) continue;
                if(map.containsKey(str)) continue;
                
                if(str.equals(target))
                    return map.get(s) + 1;
                map.put(str, map.get(s) + 1);
                q.add(str);
            }
        }
        
        return answer;
    }
}