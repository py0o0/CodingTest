#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char,int> m;
    
    int i= 0;
    for(auto c:survey){
        if(choices[i] < 4)
            m[c[0]] += 4 - choices[i];
        
        else if(choices[i] > 4)
            m[c[1]] += choices[i] - 4;
                  
        i++;
    }
    
    if(m['R'] >= m['T'])
        answer+='R';
    else
        answer += "T";
    
    if(m['C'] >= m['F'])
        answer+='C';
    else
        answer += "F";
    
    if(m['J'] >= m['M'])
        answer+='J';
    else
        answer += "M";
    
    if(m['A'] >= m['N'])
        answer+='A';
    else
        answer += "N";
    
    
    return answer;
}