#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    for(auto c:skill_trees){
        int index = 0;
        int flag = 0;
        for(auto s:c){
            if(s == skill[index])
                index++;
            else{
                for(int i = index;i<skill.size();i++){
                    if(skill[i] == s){
                        flag = 1;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }
        if(!flag)
            answer++;
    }
    
    return answer;
}