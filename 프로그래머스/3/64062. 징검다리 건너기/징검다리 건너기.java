class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int n = stones.length;
        
        int max = 0;
        for(int x : stones){
            max = Math.max(x, max);
        }
        
        int start = 1;
        int end = max + 1;
        
        while(start < end){
            int mid = (start + end) / 2;
            int flag = 0;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                
                if(stones[i] < mid){ //돌을 다 못밟을 때의 경우가 연속 K 까지면 실패
                    cnt++;
                    if(cnt >= k){
                        flag = 1; break;
                    }
                }else cnt = 0;
            }
            
            
            if(flag == 1){
                end = mid;
            }
            else 
                start = mid + 1;
        }
        answer = start - 1;
        return answer;
    }
}