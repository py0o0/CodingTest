#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int index = 0;
    while(1){
        if(index == progresses.size())
            break;
        
        for(int i=index;i<progresses.size();i++)
            progresses[i] += speeds[i];
        
        if(progresses[index] > 99){
            int cnt = 0;
            for(;index<progresses.size();index++){
                if(progresses[index] <100)
                    break;
                cnt++;
            }
            answer.push_back(cnt);
        }
    }
    return answer;
}