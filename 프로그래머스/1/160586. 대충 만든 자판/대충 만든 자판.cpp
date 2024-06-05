#include <string>
#include <vector>
#include <climits>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    for(int i=0;i<targets.size();i++){
        int total = 0;
        int suc = 1;
        for(auto c:targets[i]){
            int cnt = INT_MAX;
            int index = 0;
            while(1){
                if(index >= keymap.size())
                    break;
                for(int k=0;k<keymap[index].size();k++){
                    if(c == keymap[index][k]){
                        cnt = min(cnt,k + 1);
                        break;
                    }
                }
                index++;
            }
            if(cnt == INT_MAX){
                answer.push_back(-1);
                suc = 0;
                cout<<": "<<total<<"\n";
                break;
            }
            total += cnt;
        }
        if(suc)
            answer.push_back(total);
    }
    return answer;
}