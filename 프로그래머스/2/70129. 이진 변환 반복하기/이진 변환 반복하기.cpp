#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int zero = 0;
    int i = 0;
    while(s != "1"){
        string str = "";
        for(auto c:s){
            if(c == '0')
                zero++;
            else
                str += '1';
        }
        
        int n = str.size();
        str = "";
        while(n>1){
            str = to_string(n%2) + str;
            n /=2;
        }
        str = to_string(n) + str;
        s = str;
        i++;
    }
    answer.push_back(i);
    answer.push_back(zero);
    return answer;
}