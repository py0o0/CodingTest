#include <string>
#include <vector>
#include <iostream>
#include <climits>
#include <cmath>
using namespace std;

struct XY{
    long long x;
    long long y;
};

vector<string> solution(vector<vector<int>> line) {
    vector<string> answer;
    
    vector<XY> v;
    
    for(int i=0;i<line.size();i++){
        for(int j=i+1;j<line.size();j++){
            long long BF = (long long)line[i][1] * (long long)line[j][2];
            long long ED = (long long)line[i][2] * (long long)line[j][1];
            
            long long AD = (long long)line[i][0] * (long long)line[j][1];
            long long BC = (long long)line[i][1] * (long long)line[j][0];
            
            long long EC = (long long)line[i][2] * (long long)line[j][0];
            long long AF = (long long)line[i][0] * (long long)line[j][2];
            
            if(AD == BC)
                continue;
            
            if((BF - ED) % ( AD - BC ) == 0 and (EC - AF) % ( AD - BC ) == 0 ){
                v.push_back({(BF - ED) / ( AD - BC ), (EC - AF) / ( AD - BC )});
            }
        }
    }
    

    
    long long maxX = LLONG_MIN ,minX = LLONG_MAX, maxY = LLONG_MIN ,minY = LLONG_MAX;
    for(auto c:v){
        maxX = max(maxX,c.x);
        minX = min(minX,c.x);
        
        maxY = max(maxY,c.y);
        minY = min(minY,c.y);
    }
    
    string s = "";
    for(int i=0;i<= maxX - minX;i++)
        s +='.';
    
    for(int i=0;i<= maxY - minY;i++)
        answer.push_back(s);
    
    
    for(auto c:v){
        answer[abs(maxY - c.y)][abs(c.x - minX)] = '*';
    }
    
    
    return answer;
}