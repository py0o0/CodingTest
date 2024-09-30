#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

struct xy{
    string par;
    int money;
};

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    vector<int> answer;
    
    map<string,xy> m;
    
    for(int i = 0; i<enroll.size();i++)
        m[enroll[i]].par = referral[i];
    
    int cur = 0;
    for(auto sell : seller){
        
        int money = amount[cur] * 100;
        
        string name = sell;
        while(name != "-"){
            int plus = money - (int)(money * 0.1);
            
            if(plus == 0)
                break;
            
            m[name].money += plus;
            name = m[name].par;
            money = money * 0.1;
   
        }
        cur++;
      
    }
    for(auto en : enroll)
        answer.push_back(m[en].money);
    

    return answer;
}