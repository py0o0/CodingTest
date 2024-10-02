#include <string>
#include <vector>
#include <iostream>
using namespace std;

struct xy{
    int x;
    int y;
    bool operator==(xy a){
        return (a.x == x && a.y == y);
    }
};

int visit[201][201];
int solution(vector<vector<int>> points, vector<vector<int>> routes) {
    int answer = 0;
    int Max = 0;
    vector<vector<xy>> v;
    for(int i = 0; i<routes.size(); i++){
        xy start = {points[routes[i][0] - 1][0],points[routes[i][0] - 1][1]};
        vector<xy> temp;
        temp.push_back(start);
        for(int j = 1; j<routes[i].size(); j++){
            xy end = {points[routes[i][j] - 1][0],points[routes[i][j] - 1][1]};
            
            while(!(start == end)){
                if(start.x != end.x)
                    start.x += (start.x < end.x ? 1 : -1);
                else start.y += (start.y < end.y ? 1 : -1);
                temp.push_back(start);
            }
        }
        v.push_back(temp);
        Max = max(Max,(int)temp.size());
    }

    for(int i = 0; i<Max;i++){
        
        for(int j = 0; j<101;j++)
            for(int k = 0; k<101;k++)
                visit[j][k] = 0;
        
        for(int j=0; j<v.size(); j++){
            if(v[j].size() <= i) continue;
            for(int k = j + 1; k<v.size(); k++){
                if(v[k].size() <= i) continue;
                if(v[j][i] == v[k][i] and visit[v[j][i].x][v[j][i].y] == 0){
                    visit[v[j][i].x][v[j][i].y] = 1;
                    answer++; break;
                }
            }
        }
    }
    
    /*for(int i =0; i<v.size(); i++){
        for(int j = 0; j<v[i].size(); j++)
            cout<<v[i][j].x<<","<<v[i][j].y<<" ";
        cout<<"\n";
    }*/
    
    return answer;
}