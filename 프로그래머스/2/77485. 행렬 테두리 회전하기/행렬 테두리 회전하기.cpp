#include <string>
#include <vector>
#include <iostream>
using namespace std;
int map[101][101];
int dx[] = {0,1,0,-1};
int dy[] = {1,0,-1,0};


struct xy{
    int x;
    int y;
};

bool operator==(xy a, xy b){
    if(a.x == b.x and a.y == b.y)
        return true;
    return false;
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    vector<int> answer;
    int cnt = 1;
    for(int i=0;i<rows;i++)
        for(int j=0;j<columns;j++)
            map[i][j] = cnt++;
    
    for(auto c:queries){
        xy tl = {c[0] - 1, c[1] - 1}, tr = {c[0] - 1, c[3] - 1};
        xy dl = {c[2] - 1, c[1] - 1}, dr = {c[2] - 1, c[3] - 1};
        cnt = 2*(c[2] - c[0] + 1) + 2*(c[3] - c[1] - 2 + 1);
        xy cur = tl;
        int prev = map[cur.x][cur.y];
        int Min = map[cur.x][cur.y];
        int k = 0;
        for(int i=0;i<cnt;i++){
            xy next = {cur.x + dx[k], cur.y + dy[k]};
            swap(prev, map[next.x][next.y]);
            cur = next;
            
            Min = min(map[cur.x][cur.y], Min);
            
            if(next == tl || next == tr || next == dl || next == dr)
                k++;
        }
        answer.push_back(Min);
    }

    return answer;
}