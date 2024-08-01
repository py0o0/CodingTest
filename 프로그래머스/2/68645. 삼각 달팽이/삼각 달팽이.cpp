#include <string>
#include <vector>
#include <iostream>
using namespace std;
int map[1001][1001];

struct xy{
    int x;
    int y;
};

int dx[] = {-1,1,0};
int dy[] = {-1,0,1};

vector<int> solution(int n) {
    vector<int> answer;
    int total = 0;
    int t = n;
    while(t > 0)
        total += t--;
    int cnt = 1;
    
    xy d = {-1,0};
    
    for(int i = 0;i<n;i++){
        d.x++;
        map[d.x][d.y] = cnt++; 
    }
    
    for(int i = 0;i<n - 1;i++){
        d.y++;
        map[d.x][d.y] = cnt++;
    }
    
    int k = 0;
    for(int i = 0;i<total - n - (n - 1);i++){
        if(map[d.x + dx[k]][d.y + dy[k]] != 0)
            k  = (k + 1) % 3;    
        d.x += dx[k];
        d.y += dy[k];
        map[d.x][d.y] = cnt++;
    }
    
    for(int i=0;i<n;i++)
        for(int j=0;j<=i;j++)
            answer.push_back(map[i][j]);
    
    return answer;
}