#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    stack<int> st;
    
    for(auto move : moves){
        move -= 1;
        int cur = 0;
        while(cur < board.size()&&board[cur][move] == 0) cur++;
        
        if(cur < board.size()){
            if(st.size() == 0) st.push(board[cur][move]);
            else if(st.top() == board[cur][move]){st.pop(); answer+=2;}
            else st.push(board[cur][move]);
            board[cur][move] = 0;
        }
    }
    
    return answer;
}