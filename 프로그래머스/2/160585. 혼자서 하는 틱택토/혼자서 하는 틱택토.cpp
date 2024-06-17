#include <string>
#include <vector>

using namespace std;

int O;
int X;
int Osuc;
int Xsuc;

void row(vector<string> board,int x,int y){
    if(board[x][y] =='O' and board[x][y+1] =='O' and board[x][y+2] =='O')
        Osuc =1;
    if(board[x][y] =='X' and board[x][y+1] =='X' and board[x][y+2] =='X')
        Xsuc =1;
}
void col(vector<string> board,int x,int y){
    if(board[x][y] =='O' and board[x+1][y] =='O' and board[x+2][y] =='O')
        Osuc =1;
    if(board[x][y] =='X' and board[x+1][y] =='X' and board[x+2][y] =='X')
        Xsuc =1;
}

int solution(vector<string> board) {
    int answer = -1;
    for(int i=0;i<3;i++)
        for(int j=0;j<3;j++){
            if(board[i][j]=='O')
                O++;
            if(board[i][j]=='X')
                X++;
        }
    for(int i=0;i<3;i++)
        row(board,i,0);
    for(int i=0;i<3;i++)
        col(board,0,i);
    
    if(board[0][0]=='O' and board[1][1]=='O' and board[2][2]=='O')
        Osuc = 1;
    else if(board[0][2]=='O' and board[1][1]=='O' and board[2][0]=='O')
        Osuc = 1;
    else if(board[0][0]=='X' and board[1][1]=='X' and board[2][2]=='X')
        Xsuc = 1;
    else if(board[0][2]=='X' and board[1][1]=='X' and board[2][0]=='X')
        Xsuc = 1;
    
    if(Osuc and Xsuc)
        answer = 0;
    else if(Osuc and O-X ==1)
        answer = 1;
    else if(Xsuc and O-X ==0)
        answer = 1;
    else if(!Osuc and !Xsuc and (O-X ==0 or O-X == 1))
        answer = 1;
    else
        answer = 0;
    
    
    return answer;
}