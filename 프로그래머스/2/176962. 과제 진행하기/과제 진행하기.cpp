#include <string>
#include <vector>
#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

struct Time{
    string s;
    int t;
    int re;
};

bool cmp(Time &t1, Time &t2){
    return t1.t < t2.t;
}

int tTOm(string s){
    string a = "";
    for(int i=0;i<2;i++)
        a += s[i];
    
    int sum = stoi(a) * 60;
    
    a = "";
    for(int i= 3;i<5;i++)
        a += s[i];
    
    sum += stoi(a);
    
    return sum;
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    
    vector<Time> time(plans.size());
    stack<Time> st;
    
    for(int i=0;i<plans.size();i++){
        time[i].t = tTOm(plans[i][1]);
        time[i].s = plans[i][0];
        time[i].re = stoi(plans[i][2]);
    }
    
    sort(time.begin(),time.end(),cmp);
    
    for(int i=0;i<plans.size()-1;i++){
        int t = time[i].t + time[i].re;
        if(t > time[i+1].t){
            st.push({time[i].s, time[i+1].t, t-time[i+1].t});
        }
        else if(t == time[i+1].t)
            answer.push_back(time[i].s);
        else if(t < time[i+1].t){
            answer.push_back(time[i].s);
            
            while(st.size() !=0){
                Time T = st.top();
                T.t = t;
                st.pop();
                
                t = T.re + T.t;
                if(t < time[i+1].t){
                    answer.push_back(T.s);
                }
                else if(t == time[i+1].t){
                    answer.push_back(T.s);
                    break;
                }
                else if(t > time[i+1].t){
                    st.push({T.s, time[i+1].t, t-time[i+1].t});
                    break;
                }
                
            }
        }
    }
    answer.push_back(time[time.size()-1].s);
    
    while(st.size()!=0){
        answer.push_back(st.top().s);
        st.pop();
    }
    
    return answer;
}