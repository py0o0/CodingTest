#include <string>
#include <vector>
#include <iostream>
using namespace std;
int N;
struct xy{
    int bo;
    int gi;
};

xy map[102][102];

bool check(int x, int y, int a){
    if(a == 0){
        if(y == 0) return true;
        else if(map[x][y - 1].gi == 1) return true;
        else if(map[x][y].bo == 1) return true;
        else if(x > 0 and map[x - 1][y].bo == 1) return true;
    }
    else{
        if(map[x][y - 1].gi == 1) return true;
        else if(map[x + 1][y - 1].gi == 1) return true;
        else if(x > 0 and map[x - 1][y].bo ==1 and map[x + 1][y].bo ==1)
            return true;
    }
    return false;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    vector<vector<int>> answer;
    
    N = n;
    for(auto c : build_frame){
        int x = c[0];
        int y = c[1];
        int flag = 0;
        if(c[3] == 1){
            if(check(x,y,c[2])){
                if(c[2] == 0) map[x][y].gi = 1;
                else map[x][y].bo = 1;
            }
        }
        else{
            if(c[2] == 0){
                map[x][y].gi = 0;
                
                if(map[x][y+1].gi == 1 and !check(x,y+1,0)) flag = 1;
                if(map[x][y+1].bo == 1 and !check(x,y+1,1)) flag = 1;
                if(x>0 and map[x-1][y+1].bo == 1 and !check(x-1,y+1,1)) flag = 1;
                
                if(flag == 1) map[x][y].gi = 1;
            }
            else{
                map[x][y].bo = 0;
                
                if(map[x][y].gi == 1 and !check(x,y,0)) flag = 1;
                if(map[x+1][y].gi == 1 and !check(x+1,y,0)) flag = 1;
                if(map[x+1][y].bo == 1 and !check(x+1,y,1)) flag = 1;
                if(x>0 and map[x-1][y].bo == 1 and !check(x-1,y,1)) flag = 1;
                
                if(flag == 1) map[x][y].bo = 1;
            }
        }
        
    }
   
        
        for(int i = 0; i<=n; i++)
            for(int j = 0; j<=n;j++){
                if(map[i][j].gi == 1) answer.push_back({i,j,0});
                   
                if(map[i][j].bo == 1) answer.push_back({i,j,1});
            
            }
    
    return answer;
}