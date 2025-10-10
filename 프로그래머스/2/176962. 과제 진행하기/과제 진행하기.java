import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        int index = 0;
        
        xy[] v = new xy[n];
        Stack<xy> st = new Stack<>();
        
        for(int i = 0; i < n; i++){
            v[i] = new xy();
            v[i].s = plans[i][0];
            int h = Integer.parseInt(plans[i][1].substring(0,2));
            int m = Integer.parseInt(plans[i][1].substring(3,5));
            int f = Integer.parseInt(plans[i][2]);
            v[i].st = h * 60 + m;
            v[i].remain = f;
        }
        Arrays.sort(v, (a, b) -> a.st - b.st);
        
        for(xy x : v){
            if(st.isEmpty()) {
                st.add(new xy(x.s, x.st, x.remain));
                continue;
            }
        
            while(!st.isEmpty()){
                int finish = st.peek().st + st.peek().remain;
                if(finish > x.st){  // 진행 중이던 과제가 끝나기 전 새과제
                st.peek().remain -= x.st - st.peek().st;
                st.peek().st = x.st;
                break;
                }
                // 새과제 스타트 전까지 진행중이던 과제 업데이트
                answer[index++] = st.pop().s;
                if(!st.isEmpty())
                    st.peek().st = finish;
            }
            st.add(new xy(x.s, x.st, x.remain));
        }
        while(!st.isEmpty()) answer[index++] = st.pop().s;
        
        
        return answer;
    }
    static class xy{
        String s;
        int st, remain;
        xy(){}
        xy(String a, int b, int c){
            s = a; st = b; remain = c; 
        }
    }
}