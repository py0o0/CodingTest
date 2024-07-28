#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int storey) {
    int answer = 0;
    string s = to_string(storey);
    
    for(int i=s.size()-1;i>-1;i--){
       if(s[i] < '5')
           answer += s[i] - '0';
        else if(s[i] > '5'){
            answer += 10 - (s[i]-'0');
            if(i == 0)
                answer += 1;
            else 
                s[i-1] = s[i-1] + 1;
        }
        else if(s[i] == '5'){
            int j = i;
            while(j != -1){
                if(s[j] != '5')
                    break;
                j--;
            }
            if(j == -1){
                if(i == 0)
                    answer += 5;
                else{
                    answer += 4* (i - j);
                    answer += 2;
                }
                break;
            }
            else if(s[j] < '5')
                answer += 5;
            else if(s[j] > '5'){
                answer += 5;
                s[i - 1] = s[i-1] +1;
            }
        }
    }

    
    return answer;
}