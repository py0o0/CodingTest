#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    
    stack<int> st;
    
    int cur = 0;
    for(int i=0;i<order.size();i++){
        if(cur + 1 == order[i]){
            cur++;
            answer++;
        }
        else if(cur<order[i]){
            while(cur < order[i]){
                cur++;
                st.push(cur);
            }
            st.pop();
            answer++;
        }
        else if(st.size() != 0 && st.top() == order[i]){
            st.pop();
            answer++;
        }
        else
            break;
    }
    
    return answer;
    
}