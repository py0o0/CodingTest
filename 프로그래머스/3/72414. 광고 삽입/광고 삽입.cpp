#include <string>
#include <vector>
#include <iostream>
using namespace std;


int map[400000];

void trans1(string s, int& start, int& end){
    string h1 = s.substr(0,2);
    string m1 = s.substr(3,2);
    string s1 = s.substr(6,2);
    
    
    start = stoi(h1) * 3600 + stoi(m1) * 60 + stoi(s1);
    
    string h2 = s.substr(9,2);
    string m2 = s.substr(12,2);
    string s2 = s.substr(15,2);
    
    end = stoi(h2) * 3600 + stoi(m2) * 60 + stoi(s2);
    
}

void trans2(string s, int& t){
    string h1 = s.substr(0,2);
    string m1 = s.substr(3,2);
    string s1 = s.substr(6,2);
    
    t = stoi(h1) * 3600 + stoi(m1) * 60 + stoi(s1);
}

void trans3(string &s, int x){
    int h = x/3600;
    int m = x%3600/60;
    int se = x%60;
    
    if(h < 10)
        s += '0';
    s+= to_string(h) + ":";
    if(m<10)
        s+='0';
    s+=to_string(m) + ":";
    if(se<10)
        s+='0';
    s+=to_string(se);
}

string solution(string play_time, string adv_time, vector<string> logs) {
    string answer = "";
    for(auto log : logs){
        int start = 0, end = 0;
        trans1(log,start,end);
        map[start]++;
        map[end]--;
    }
    
    int end_time = 0;
    trans2(play_time,end_time);
    
    for(int i = 1; i< end_time;i++)
        map[i] += map[i-1];
    
    int start = 0;
    int ad_end = 0;
    
    long long sum = 0;
    long long Max = 0;
    int an = 0;
    
    trans2(adv_time,ad_end);
        
    for(int i = 0; i<end_time;i++){
        sum += map[i];
        if(ad_end <= i){
            sum -= map[start];
            start++;
        }
        if(Max < sum){
            an = start;
            Max = sum;
        }
    }
    
    trans3(answer, an);
    return answer;
}