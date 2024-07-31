#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

map<string,int> m;

int solution(string word) {
    int answer = 0;
    m["A1"] = m["A2"] = m["A3"] = m["A4"] = m["A5"] = 1;
    m["E5"] = 2, m["I5"] = 3, m["O5"] = 4, m["U5"] = 5;
    
    m["E4"] = m["A4"] + m["U5"] + 1;
    m["I4"] = m["E4"] + m["U5"] + 1;
    m["O4"] = m["I4"] + m["U5"] + 1;
    m["U4"] = m["O4"] + m["U5"] + 1;
    
    m["E3"] = m["A3"] + m["U4"] + m["U5"] + 1;
    m["I3"] = m["E3"] + m["U4"] + m["U5"] + 1;
    m["O3"] = m["I3"] + m["U4"] + m["U5"] + 1;
    m["U3"] = m["O3"] + m["U4"] + m["U5"] + 1;
    
    m["E2"] = m["A2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    m["I2"] = m["E2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    m["O2"] = m["I2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    m["U2"] = m["O2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    
    m["E1"] = m["A1"] + m["U2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    m["I1"] = m["E1"] + m["U2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    m["O1"] = m["I1"] + m["U2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    m["U1"] = m["O1"] + m["U2"] + m["U3"] + m["U4"] + m["U5"] + 1;
    
    for(int i=0;i<word.size();i++){
        string s = "";
        s += word[i] + to_string(i+1);
        answer += m[s];
    }
    return answer;
}