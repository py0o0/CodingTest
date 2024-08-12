#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    int answer = 0;
    
    stack<char> st;
    for(auto c:s){
        if(st.size() == 0 or st.top() != c)
            st.push(c);
        else if(st.top() == c)
            st.pop();
    }
    answer = (st.size() == 0);
    
    return answer;
}