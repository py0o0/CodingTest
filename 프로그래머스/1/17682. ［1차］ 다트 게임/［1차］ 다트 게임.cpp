#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> an;

void calcul(int score, string cal){
    for(auto c : cal){
        if(c == 'S') an.push_back(score);
        else if(c == 'D') an.push_back(score * score);
        else if(c == 'T') an.push_back(score * score * score);
        else if(c == '*'){
            an[an.size()-1] *= 2;
            if(an.size() > 1) an[an.size() - 2] *= 2;
        }
        else if(c == '#') an[an.size()-1] = -an[an.size()-1];
    }
}

int solution(string dartResult) {
    int answer = 0;
    
    for(int i = 0; i<dartResult.size(); ){
        string score = "";
        string cal = "";
        
        while(isdigit(dartResult[i]))
            score += dartResult[i++];
        
        while(i < dartResult.size()&&!isdigit(dartResult[i]))
            cal += dartResult[i++];
        
        calcul(stoi(score),cal);
    }
    for(auto a : an)
        answer += a;
    
    return answer;
}