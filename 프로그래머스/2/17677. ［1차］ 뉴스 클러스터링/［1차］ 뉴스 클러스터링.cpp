#include <string>
#include <algorithm>
#include <iostream>
#include <cmath>
using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    vector<string> v1,v2;
    
    int cur = 0;
    while(cur + 2 <= str1.size()){
        string s = str1.substr(cur,2);
        if(isalpha(s[0]) and isalpha(s[1])){
            string temp = "";
            temp += tolower(s[0]);
            temp += tolower(s[1]);
            v1.push_back(temp);
        }
        cur++;
    }
    
    
    cur = 0;
    while(cur + 2 <= str2.size()){
        string s = str2.substr(cur,2);
        if(isalpha(s[0]) and isalpha(s[1])){
            string temp = "";
            temp += tolower(s[0]);
            temp += tolower(s[1]);
            v2.push_back(temp);
        }
        cur++;
    }
    if(v1.size() == 0 and v2.size() == 0)
        return 65536;
    
    sort(v1.begin(),v1.end()); sort(v2.begin(),v2.end());
    
    double Min = 0,Max = 0;
    int cur1 = 0,cur2 = 0;
    
    while(cur1 < v1.size() && cur2 < v2.size()){
        if(v1[cur1] > v2[cur2]) cur2++;
        else if(v1[cur1] < v2[cur2]) cur1++;
        else{
            Min++; cur1++; cur2++;
        }
    }
    if(Min == 0) return 0;
    
    cur1 = 0, cur2 = 0;
    
   while(cur1 < v1.size() && cur2 < v2.size()){
        Max++;
        if(v1[cur1] > v2[cur2]) cur2++;
        else if(v1[cur1] < v2[cur2]) cur1++;
        else{
             cur1++; cur2++;
        }
    }
    while(cur1 < v1.size()){
        cur1++; Max++;
    }
    while(cur2 < v2.size()){
        cur2++; Max++;
    }

    double per = (Min/Max)*65536.0;
    answer = floor(per);
    
    return answer;
}