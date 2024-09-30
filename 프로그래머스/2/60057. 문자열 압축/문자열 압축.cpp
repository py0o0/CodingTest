#include <string>
#include <vector>
#include <iostream>
#include <climits>
using namespace std;

int solution(string s) {
    int answer = INT_MAX;
    int cur = 1;
    while(cur <= s.size()/2){
        string com = s.substr(0,cur);
        string an = "";
        
        int cnt = 0;
        for(int i = 0; i < s.size(); i += cur){
            if(i + cur > s.size()){
                
                an += com + s.substr(i);
                if(cnt > 1)
                    an += to_string(cnt);
                com = "";
                cnt = 0;
                break;
            }
            string str = s.substr(i,cur);
            if(str == com){
                cnt++;
            }
            else{
                if(cnt < 2)
                    an += com;
                else
                    an += com + to_string(cnt);
                cnt = 1;
                com = str;
            }
        }
        if(com != "")
            an += com;
        if(cnt > 1)
            an += to_string(cnt);
        
        int size = an.size();
        answer = min(answer,size);
        cur++;
        
    }
    if(answer == INT_MAX)
        answer = 1;
    return answer;
}