#include <string>
#include <vector>
#include <map>
using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    map<string,int> m;
    int k=0;
    for(auto c:players){
        m[c] = k;
        k++;
    }
    for(auto c:callings){
        int i = m[c];
        swap(players[i-1],players[i]);
        swap(m[players[i-1]],m[players[i]]);
    }
    answer = players;
    return answer;
}