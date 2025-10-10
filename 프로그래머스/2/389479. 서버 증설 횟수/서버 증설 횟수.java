import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<xy> q = new LinkedList<>();
        
        int x = m - 1;
        for(int i = 0; i < 24; i++){
            if(!q.isEmpty() && i == q.peek().t){ // 서버 반납 시간
                x -= q.peek().x * m; // 최대치
                q.poll();
            }
            
            if(players[i] > x){ // 이용자 수가 최대치 보다 많아짐
                int v = players[i] - x; // 초과된 사용자 수
                v = (v % m == 0 ? v / m : v / m + 1);  // 필요한 서버 수
                q.add(new xy(v ,i + k));
                x += v * m;
                answer += v;
            }

        }
        
        return answer;
    }
    static class xy{
        int x, t;
        xy(int a, int b){
            x  = a; t = b;
        }
    }
}