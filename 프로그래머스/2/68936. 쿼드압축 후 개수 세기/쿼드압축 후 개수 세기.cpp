#include <string>
#include <vector>

using namespace std;

int zero;
int one;

int map[1025][1025];

void dfs(int x,int y, int size){
    int a = map[x][y];
    
    int fail = 0;
    for(int i=x;i<x + size;i++){
        for(int j=y;j<y + size;j++){
            if(map[i][j] != a){
                fail = 1;
                break;
            }
        }
        if(fail)
            break;
    }
    
    if(!fail){
        if(a == 1)
            one++;
        else
            zero++;
        return;
    }
    
    dfs(x,y,size/2);
    dfs(x + size/2,y,size/2);
    dfs(x,y+ size/2,size/2);
    dfs(x+ size/2,y+ size/2,size/2);
    
    
}

vector<int> solution(vector<vector<int>> arr) {
    vector<int> answer;
    
    for(int i=0;i<arr.size();i++)
        for(int j=0;j<arr[0].size();j++)
            map[i][j] = arr[i][j];
    
    dfs(0,0,arr.size());
    
    answer.push_back(zero);
    answer.push_back(one);
    return answer;
}