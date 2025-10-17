import java.io.*;
import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        ArrayList<String> an = new ArrayList<>();
        for(int c : course){
            map.clear();
            for(String s : orders){
                dfs(s, c, -1, "");
            }
            int max = 0;
            for(String key : map.keySet()){
                max = Math.max(max, map.get(key));
            }
            if(max < 2) continue;
            for(String key : map.keySet()){
                if(max == map.get(key)) an.add(key);
            }
        }
        answer = new String[an.size()];
        for(int i = 0; i < an.size(); i++) answer[i] = an.get(i);
        Arrays.sort(answer, (a,b)->a.compareTo(b));
        
        return answer;
    }
    static void dfs(String order, int max, int index, String s){
        if(s.length() == max){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
            if(map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
            else map.put(temp, 1);
            return;
        }
        
        for(int i = index + 1; i < order.length(); i++)
            dfs(order, max, i, s + order.charAt(i));
    }
}