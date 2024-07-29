#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<double> solution(int k, vector<vector<int>> ranges) {
    vector<double> answer;
    vector<double> v;
    
    int j=0;
    while(k != 1){
        v.push_back(k);
        j++;
        if(k > 1 && k%2 == 0)
            k /=2;
        else
            k = k*3 + 1;
    }
    v.push_back(1);
    
    for(int i=0;i<ranges.size();i++){
        int s = ranges[i][0];
        int e = j + ranges[i][1];
        if(s == e){
            answer.push_back(0);
            continue;
        }
        if(s > e){
            answer.push_back(-1);
            continue;
        }
        
        double sum = 0;
        for(int k=s;k<e;k++){
            sum += (v[k] + v[k+1]) / 2.0;
        }
        answer.push_back(sum);

    }
    
    
    return answer;
}