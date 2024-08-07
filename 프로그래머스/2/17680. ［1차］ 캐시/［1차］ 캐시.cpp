#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    deque<string> dq;
    
    if(cacheSize == 0)
        return cities.size() * 5;
    
    for(int i=0;i<cities.size();i++)
        for(int j=0;j<cities[i].size();j++)
            cities[i][j] = tolower(cities[i][j]); 
    
    for(auto c:cities){
        answer++;
        int flag = 0;
        int index = 0;
        for(int i=0;i<dq.size();i++)
            if(dq[i] == c){
                flag = 1;
                index = i;
                break;
            }
        
        if(flag){
            dq.erase(dq.begin()+index);
            dq.push_back(c);
            continue;
        }
        
        answer += 4;
        if(dq.size() >= cacheSize)
            dq.pop_front();
        dq.push_back(c);
    }
    
    return answer;
}