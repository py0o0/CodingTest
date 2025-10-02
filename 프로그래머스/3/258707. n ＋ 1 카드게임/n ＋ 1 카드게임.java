import java.io.*;
import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        
        int n = cards.length;
        int[] keep = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0;
        for(i = 0; i < n/3; i++){
            keep[ cards[i] ] = 1; //코인이 필요 없는 카드
            int pair = n + 1 - cards[i]; // 짝이 되는 카드
            
            if(keep[ pair ] == 1){
                pq.add(0); // pair가 있으면 코인 없이 통과
            }
        }
        
        int turn = 1;
        for(; i < n; i+=2){
            
            for(int j = i; j < i + 2; j++){
                keep[ cards[j] ] = 2; // coin이 필요한 카드
                int pair = n + 1 - cards[j];
                
                if(keep[pair] == 1) pq.add(1); // coin 1개 필요
                else if(keep[pair] == 2) pq.add(2); // coin 2개 필요
            }
            
            if(pq.size() == 0) break;
            
            int needCoin = pq.poll();
            if(needCoin > coin) break;
            coin -= needCoin;
            
            turn++;
        }

        answer = turn;
        return answer;
    }
}