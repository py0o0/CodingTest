#include <string>
#include <vector>

using namespace std;

int dx[] = {1,-1,0,0};
int dy[] = {0,0,1,-1};

struct XY{
    int x;
    int y;
};

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    XY start;
    
    for(int i=0;i<park.size();i++)
        for(int j=0;j<park[0].size();j++)
            if(park[i][j]=='S'){
                park[i][j] = 'O';
                start.x = i;
                start.y = j;
            }
    
    for(int i=0;i<routes.size();i++){
        int k = 0;
        if(routes[i][0]== 'E')
            k = 2;
        else if(routes[i][0]== 'W')
            k = 3;
        else if(routes[i][0]== 'N')
            k = 1;
        else if(routes[i][0]== 'S')
            k = 0;
        
        XY po = start;
        int fail = 0;
        
        string s = "";
        s+=routes[i][2];
        int a = stoi(s);
        
        for(int j=0;j<a;j++){
            po.x += dx[k];
            po.y += dy[k];
            
            if(po.x <0 or po.x >= park.size() or po.y < 0 or po.y>=park[0].size()){
                fail = 1;
                break;
            }
            if(park[po.x][po.y] == 'X'){
                fail = 1;
                break;
            }
        }
        if(!fail)
            start = po;
        
    }
    answer.push_back(start.x);
    answer.push_back(start.y);
    
    return answer;
}