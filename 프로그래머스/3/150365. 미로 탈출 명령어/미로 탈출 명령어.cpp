#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

struct xy{
    int x;
    int y;
    int cnt;
    string s;
};

struct cmp{
    bool operator()(xy a, xy b){
        return a.s > b.s;
    }
};

int dx[] = {1,0,0,-1};
int dy[] = {0,-1,1,0};
string str[] = {"d","l","r","u"};

int map[51][51];
int visit[51][51];

string solution(int n, int m, int x, int y, int r, int c, int k) {
    string answer = "";
    queue<xy> q;
    
    
    q.push({r,c});
    visit[r][c] = 1;
    while(!q.empty()){
        xy x = q.front();
        q.pop();
        for(int i = 0; i<4; i++){
            int nx = x.x + dx[i];
            int ny = x.y + dy[i];
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if(visit[nx][ny]) continue;
            visit[nx][ny] = 1;
            map[nx][ny] = x.cnt + 1;
            
            q.push({nx,ny,x.cnt+1});
        }
    }
    
   
    priority_queue<xy,vector<xy>,cmp> pq;
    
    pq.push({x,y,0});
    int flag = 0;
    while(!pq.empty()){
        xy x = pq.top();
        pq.pop();
        for(int i = 0; i<4;i++){
            int nx = x.x + dx[i];
            int ny = x.y + dy[i];
            if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if(k == x.cnt + 1 && nx == r && ny == c){
                answer = x.s + str[i];
                flag = 1;
                break;
            }
            if(k - (x.cnt + 1) < map[nx][ny] ) continue;
            if(map[nx][ny] % 2 == 0 && (k - (x.cnt + 1)) % 2 == 1) continue;
            pq.push({nx,ny,x.cnt + 1,x.s + str[i] });
        }
        if(flag)
            break;
    }
    
    if(answer == "")
        answer = "impossible";
    return answer;
}