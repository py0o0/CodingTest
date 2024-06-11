#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    int i=0;
    for(auto c:s){
        if(c == ' '){
            answer += " ";
            i=0;
            continue;
        }
        if(i==0){
            answer +=toupper(c);
        }
        else
            answer += tolower(c);
        i= (i+1)%2;
        
    }
    return answer;
}