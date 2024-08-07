#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    
    map<string,int> m;
    for(int i=0;i<26;i++)
        m[string(1,i+'A')] = i+1;

    int index = 27;
    for(int i=0;i<msg.size();i++){
        string w;
        w = msg[i];
        while(m[w] != 0){
            i++;
            if(i>=msg.size()){
                answer.push_back(m[w]);
                return answer;
            }
            w += msg[i];
        }
        i--;
        m[w] = index++;
        w.pop_back();
        answer.push_back(m[w]);
    }
    
    return answer;
}