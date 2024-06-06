#include <string>
#include <vector>
#include <iostream>
using namespace std;

int visit[501][501];
int map[501][501];
int m[501];

void dfs(int x,int y,int row, int col,int& cnt,int &minY, int &maxY){
    if(x < 0 or x>= row or y<0 or y>= col)
        return;
    if(visit[x][y] or map[x][y]==0)
        return;
    
    visit[x][y] = 1;
    minY = min(minY,y);
    maxY = max(maxY,y);
    cnt++;
    
    dfs(x+1,y,row,col,cnt,minY,maxY);
    dfs(x-1,y,row,col,cnt,minY,maxY);
    dfs(x,y+1,row,col,cnt,minY,maxY);
    dfs(x,y-1,row,col,cnt,minY,maxY);
}


int solution(vector<vector<int>> land) {
    int answer = 0;
    for(int i=0;i<land.size();i++)
        for(int j=0;j<land[0].size();j++)
            map[i][j] = land[i][j];
    
    int row = land.size();
    int col = land[0].size();
    for(int i=0;i<land.size();i++)
        for(int j=0;j<land[0].size();j++){
            int cnt = 0;
            if(map[i][j]==1 and !visit[i][j]){
                int minY = j, maxY = j;
                dfs(i,j,row,col,cnt,minY,maxY);
                
                for(int k=minY;k<=maxY;k++)
                    m[k] += cnt;
            }
        }
    
    int Max = 0;
    for(int i=0;i<land[0].size();i++)
        Max = max(Max,m[i]);
    
    answer = Max;
    return answer;
}