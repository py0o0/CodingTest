#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int flag = 1;
    for(auto c:s){
        if(c == ' ')
            flag = 1;
        else if(flag){
            flag = 0;
            if(isalpha(c))
                answer += toupper(c);
            else
                answer += c;
            continue;
        }
        answer += tolower(c);            
    }
    return answer;
}