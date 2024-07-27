#include <string>
#include <vector>
#include <queue>
using namespace std;

int visit[1000001];
struct xy{
    int a;
    int cnt;
};

int solution(int x, int y, int n) {
    int answer = -1;
    queue<xy> q;
    q.push({x,0});
    
    while(q.size()!=0){
        int a = q.front().a;
        int cnt = q.front().cnt;
        visit[a] = 1;
        q.pop();
        
        if(a == y){
            answer = cnt;
            break;
        }
        else{
            if(a + n <= y and !visit[a+n])
                q.push({a+n,cnt+1});
            if(a * 2 <= y and !visit[a*2])
                q.push({a*2,cnt+1});
            if(a * 3 <= y and !visit[a*3])
                q.push({a*3,cnt+1});
        }
    }
    return answer;
}