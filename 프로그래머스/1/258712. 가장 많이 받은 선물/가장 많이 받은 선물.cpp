#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <iostream>
using namespace std;

struct xy{
    int receive;
    int give;
};

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    map<string,xy> m;
    map<pair<string,string>,int> pyo;
    map<string,int> an;

    
    for(auto gift: gifts){
        string x, y;
        stringstream s(gift);
        s >> x >> y;
        m[x].give++;
        m[y].receive++;
        pyo[{x,y}]++;
    }
    
    for(int i = 0; i < friends.size();i++){
        for(int j = i+1; j<friends.size();j++){
            string x = friends[i];
            string y = friends[j];
            if(pyo[{x,y}] != pyo[{y,x}]){
                if(pyo[{x,y}] > pyo[{y,x}])
                    an[x]++;
                else
                    an[y]++;
            }
            else if(pyo[{x,y}] == pyo[{y,x}]){
                if(m[x].give - m[x].receive > m[y].give - m[y].receive)
                    an[x]++;
                else if(m[x].give - m[x].receive < m[y].give - m[y].receive)
                    an[y]++;
            }  
        }
    }
    for(auto c:an)
        answer = max(answer,c.second);
    
    
    return answer;
}
