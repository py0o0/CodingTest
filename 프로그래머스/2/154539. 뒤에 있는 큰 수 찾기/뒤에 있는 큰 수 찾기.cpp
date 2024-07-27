#include <string>
#include <vector>
#include <stack>
using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    stack<int> st;
    vector<int> v;
    
    for(int i=numbers.size()-1;i>-1;i--){
        if(st.size() == 0){
            v.push_back(-1);
            st.push(numbers[i]);
        }
        else if(st.top() > numbers[i]){
            v.push_back(st.top());
            st.push(numbers[i]);
        }
        else if(st.top() <= numbers[i]){
            while(st.size()!=0){
                if(st.top() > numbers[i]){
                    v.push_back(st.top());
                    st.push(numbers[i]);
                    break;
                }
                st.pop();
            }
            
            if(st.size() ==0){
                v.push_back(-1);
                st.push(numbers[i]);
            }
    
        }
    }
    
    for(int i=v.size()-1; i>-1;i--)
        answer.push_back(v[i]);
    return answer;
}