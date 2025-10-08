import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : gems) map.put(s, 0);
        
        int n = map.size();
        
        int x = 0;
        int start = 0;
        int a, b, len;
        a = b = len = Integer.MAX_VALUE;
        
        for(int i = 0; i < gems.length; i++){
            map.put(gems[i], map.get(gems[i]) + 1);
            
            if(map.get(gems[i]) == 1) x++;
            
            if(x < n) continue;
            
            while(start <= i && x == n){
                if(len > i - start){
                    len = i - start;
                    a = start;
                    b = i;
                }
                
                map.put(gems[start], map.get(gems[start]) - 1);
                if( map.get(gems[start]) == 0) x--;
                start++;
                
            }
            
            
        }
        answer[0] = a + 1;
        answer[1] = b + 1;
        
        return answer;
    }
}