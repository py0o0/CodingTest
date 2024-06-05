#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    
    for(int i=1;i<food.size();i++){
        for(int j=0;j<food[i]/2;j++)
            answer += to_string(i);
    }
    string s = "";
    for(int i= answer.size() - 1;i>-1;i--)
        s += answer[i];
    answer += to_string(0) + s;
    
    
    return answer;
}