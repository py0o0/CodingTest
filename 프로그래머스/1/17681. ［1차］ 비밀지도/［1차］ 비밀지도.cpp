#include <string>
#include <vector>
#include <iostream>
using namespace std;
int map1[17][17];
int map2[17][17];

string change(int n){
    string s = "";
    while(n >= 2){
        s += to_string(n%2);
        n/=2;
    }
    s += to_string(n);
    for(int i = 0; i<s.size()/2;i++)
        swap(s[i], s[s.size() -1 -i]);
    return s;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    for(int i = 0; i<n;i++){
        string s1 = change(arr1[i]);
        string s2 = change(arr2[i]);
        
        int cur = 0;
        for(int j = n -s1.size() ; j<n;j++)
            map1[i][j] = s1[cur++] - '0';
        
        cur = 0;
        for(int j = n -s2.size() ; j<n;j++)
            map2[i][j] = s2[cur++] - '0';
        
        string an = "";
        for(int j = 0; j<n;j++){
            if(map1[i][j] == 0 and map2[i][j] == 0) an += " ";
            else an += "#";
        }
        answer.push_back(an);
        
        
    }
    
    return answer;
}