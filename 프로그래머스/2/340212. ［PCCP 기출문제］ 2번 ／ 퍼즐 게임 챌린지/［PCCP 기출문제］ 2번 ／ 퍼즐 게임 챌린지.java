class Solution {
    static int[] diff, time;
    static long l;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        diff = diffs;
        time = times;
        l = limit;
        int start = 1;
        int end = 0;
        for(int diff : diffs) end = Math.max(end, diff);
        
        while(start < end){
            int mid = (start + end) / 2;
            if(check(mid)){
                end = mid;
            }
            else start = mid + 1;
        }
        answer = start;
        
        return answer;
    }
    static boolean check(int level){
        
        long t = 0;
        for(int i = 0; i < diff.length; i++){
            if(level >= diff[i]){
                t += time[i];
            }
            else{
                int re = diff[i] - level;
                t += (time[i] + time[i - 1]) * re + time[i];
            }
        }
        return (t <= l);
    }
}