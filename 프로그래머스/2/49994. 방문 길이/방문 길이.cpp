#include <string>
#include <iostream>
using namespace std;
int m[11][11][11][11];

int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

struct xy{
    int x;
    int y;
};

int solution(string dirs) {
    int answer = 0;
    xy x = {0,0};
    for(auto c:dirs){
        int i = 0;
        if(c=='L')
            i = 1;
        else if(c=='U')
            i = 2;
        else if(c=='D')
            i = 3;
        
        xy n;
        n.x = x.x + dx[i];
        n.y = x.y + dy[i];
        
        if(n.x<-5 or n.x >5 or n.y<-5 or n.y >5)
            continue;
        if(!m[n.x+5][x.x+5][n.y+5][x.y+5]){
            m[n.x+5][x.x+5][n.y+5][x.y+5] = 1;
            m[x.x+5][n.x+5][n.y+5][x.y+5] = 1;
            m[x.x+5][n.x+5][x.y+5][n.y+5] = 1;
            m[n.x+5][x.x+5][x.y+5][n.y+5] = 1;
            answer++;
        }
        x = n;
    }
    return answer;
}