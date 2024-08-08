#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<string> b;

struct xy{
    int x;
    int y;
};

void check(vector<xy> &v,int i,int j,int &flag){
    if(b[i][j] == b[i+1][j] and b[i][j+1] == b[i+1][j+1] and b[i][j] == b[i+1][j+1]){
        v.push_back({i,j});
        v.push_back({i,j+1});
        v.push_back({i+1,j});
        v.push_back({i+1,j+1});
        flag = 1;
    }
}

void move(){
    for(int i=0;i<b.size();i++){
        for(int j=0;j<b[i].size();j++){
            if(b[i][j] == 'X'){
                if(i-1 > -1 and b[i-1][j] != 'X'){
                    int index = i;
                    while(index > 0){
                        b[index][j]  = b[index-1][j];
                        index--;
                    }
                    b[0][j] = 'X';
                }
            }
        }
    }
}

int solution(int m, int n, vector<string> board) {
    int answer = 0;
    
    b = board;
    int flag = 1;
    
    while(flag){
        flag = 0;
        vector<xy> v;
        
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(b[i][j]== 'X')
                    continue;
                check(v,i,j,flag);
            }
        }
        
        for(auto c:v){
            if(b[c.x][c.y] != 'X')
                answer++;
            b[c.x][c.y] = 'X';
        }
        
        move(); 
      
    }
    return answer;
}