#include <string>
#include <vector>
#include <map>
#include <sstream>
using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    map<string,int> check;
    map<string,int> repo;
    map<string,int> an;
    for(auto re : report){
        string a,b;
        stringstream s(re);
        s >> a >> b;
        check[re]++;
        if(check[re] == 1)
            repo[b]++;
    }
    check.clear();
    for(auto re : report){
        string a,b;
        stringstream s(re);
        s >> a >> b;
        check[re]++;
        if(check[re] == 1 && repo[b] >= k)
            an[a]++;
    }
    for(auto id : id_list)
        answer.push_back(an[id]);
    
    
    return answer;
}