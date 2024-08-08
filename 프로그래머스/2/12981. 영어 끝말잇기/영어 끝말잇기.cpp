#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    
    int i = 0, turn = 1;
    map<string,int> m;
    char prev = words[0][0];
    for(auto c:words){
        if(m[c] > 0 or prev != c[0]){
            answer.push_back(i+1);
            answer.push_back(turn);
            break;
        }
        m[c]++;
        prev = c[c.size()-1];
        i = (i+1)%n;
        if(i==0)
            turn++;
    }
    if(answer.size()==0){
        answer.push_back(0);
        answer.push_back(0);
    }
    
    return answer;
}