#include <string>
#include <vector>
#include <iostream>
#include <stack>
using namespace std;

int solution(string s) {
    int answer = 0;
    for(int k=0;k<s.size();k++){
        char a = s[0];
        for(int i=1;i<s.size();i++)
            s[i-1] = s[i];
        s[s.size()-1] = a;
        
        stack<char> st;
        int flag = 1;
        for(auto c:s){
            if(c == '('||c == '{'||c == '[')
                st.push(c);
            else if(c == ')'||c == '}'||c == ']'){
                flag = 0;
                if(st.size() == 0)
                    break;
                if(c == ')' and st.top() != '(')
                    break;
                if(c == '}' and st.top() != '{')
                    break;
                if(c == ']' and st.top() != '[')
                    break;
                flag = 1;
                st.pop();
                
            }
        }
        if (st.size() != 0)
            flag = 0;
        
        if(flag)
            answer++;
    }
    return answer;
}