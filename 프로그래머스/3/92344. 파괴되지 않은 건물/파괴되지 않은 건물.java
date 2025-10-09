class Solution {
    static int[][] mask;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        mask = new int[n + 1][m + 1];
        
        for(int[] s : skill){
            int x = (s[0] == 1 ? -s[5] : s[5]);
            
            mask[ s[1] ][ s[2] ] += x;
            mask[ s[1] ][ s[4] + 1 ] += -x;
            mask[ s[3] + 1 ][ s[2] ] += -x;
            mask[ s[3] + 1 ][ s[4] + 1] += x;
        }
        
        for(int i = 0; i < n; i++){ //행
            for(int j = 1; j < m; j++){
                mask[i][j] += mask[i][j - 1];
            }
        }
        
        for(int i = 1; i < n; i++){ //열
            for(int j = 0; j < m; j++){
                mask[i][j] += mask[i - 1][j];
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] += mask[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}