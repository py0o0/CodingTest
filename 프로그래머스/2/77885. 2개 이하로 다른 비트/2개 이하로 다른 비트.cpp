#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for(auto c:numbers){
        string s = "";
        while(c>1){
            s += to_string(c % 2);
            c/=2;  
        }
        s+= to_string(c);
        for(int i=0;i<s.size()/2;i++)
            swap(s[i],s[s.size()-1-i]);
        
        int cnt = 0;
        int i= s.size() - 1;
        while(i> -1 and s[i] == '1'){
            cnt++;
            i--;
        }

        if(i == -1){
            s = '1' + s;
            s[1] = '0';
        }
        else if(s.size() - i == 1){
            s[i] = '1';
        }
        else{
            s[i] = '1';
            s[i+1] = '0';
        }
        long long n = 1;
        long long sum = 0;
        for(int i = s.size()-1;i>-1;i--){
            sum += n * (s[i] - '0');
            n *= 2;
        }
        answer.push_back(sum);
    }
    return answer;
}